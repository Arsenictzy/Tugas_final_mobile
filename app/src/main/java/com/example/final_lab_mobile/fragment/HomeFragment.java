package com.example.final_lab_mobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.final_lab_mobile.R;
import com.example.final_lab_mobile.activity.DetailProductActivity;
import com.example.final_lab_mobile.adapter.ProductAdapter;
import com.example.final_lab_mobile.repository.ProductRepository;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ProductAdapter adapter;
    private ProductRepository repository;
    private ProgressBar progressBar;
    private LinearLayout layoutError;
    private TextView tvErrorMsg;
    private RecyclerView rvProducts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        repository = new ProductRepository(requireContext());
        rvProducts = view.findViewById(R.id.rvProducts);
        progressBar = view.findViewById(R.id.progressBar);
        layoutError = view.findViewById(R.id.layoutError);
        tvErrorMsg = view.findViewById(R.id.tvErrorMsg);
        Button btnRefresh = view.findViewById(R.id.btnRefresh);

        adapter = new ProductAdapter(new ArrayList<>(), product -> {
            Intent intent = new Intent(requireContext(), DetailProductActivity.class);
            intent.putExtra("EXTRA_PRODUCT", product);
            startActivity(intent);
        });

        // Using GridLayoutManager for a more modern e-commerce look
        rvProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvProducts.setAdapter(adapter);

        btnRefresh.setOnClickListener(v -> loadData());
        loadData();

        return view;
    }

    private void loadData() {
        progressBar.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);
        rvProducts.setVisibility(View.GONE);

        repository.fetchProducts((products, error) -> {
            progressBar.setVisibility(View.GONE);
            if (products != null) {
                rvProducts.setVisibility(View.VISIBLE);
                adapter.updateData(products);
                if (error != null && error.equals("Menampilkan data offline")) {
                    // Optional: show a snackbar or small toast about offline mode
                }
            } else {
                layoutError.setVisibility(View.VISIBLE);
                tvErrorMsg.setText(error != null ? error : "Terjadi kesalahan");
            }
        });
    }
}
