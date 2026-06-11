package com.example.final_lab_mobile.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import com.example.final_lab_mobile.R;
import com.example.final_lab_mobile.storage.SharedPrefsManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;

public class ProfileFragment extends Fragment {
    private SharedPrefsManager prefs;
    private LinearLayout layoutAuth, layoutUserInfo;
    private EditText etEmail, etPassword;
    private TextView tvUserEmail, tvProfileTitle;
    private MaterialButton btnAuth, btnLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        
        prefs = new SharedPrefsManager(requireContext());
        
        layoutAuth = view.findViewById(R.id.layoutAuth);
        layoutUserInfo = view.findViewById(R.id.layoutUserInfo);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        tvUserEmail = view.findViewById(R.id.tvUserEmail);
        tvProfileTitle = view.findViewById(R.id.tvProfileTitle);
        btnAuth = view.findViewById(R.id.btnAuth);
        btnLogout = view.findViewById(R.id.btnLogout);
        MaterialSwitch switchTheme = view.findViewById(R.id.switchTheme);

        updateUI();

        btnAuth.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();

            if (TextUtils.isEmpty(email) || pass.length() < 6) {
                Toast.makeText(getContext(), "Email valid dan password minimal 6 karakter", Toast.LENGTH_SHORT).show();
                return;
            }

            prefs.registerUser(email, pass);
            prefs.setLoggedIn(true);
            Toast.makeText(getContext(), "Pendaftaran Berhasil!", Toast.LENGTH_SHORT).show();
            updateUI();
        });

        btnLogout.setOnClickListener(v -> {
            prefs.logout();
            updateUI();
        });

        switchTheme.setChecked(prefs.getTheme());
        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.setTheme(isChecked);
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        return view;
    }

    private void updateUI() {
        if (prefs.isLoggedIn()) {
            layoutAuth.setVisibility(View.GONE);
            layoutUserInfo.setVisibility(View.VISIBLE);
            tvProfileTitle.setText("Profil Adventurer");
            tvUserEmail.setText(prefs.getUserEmail());
        } else {
            layoutAuth.setVisibility(View.VISIBLE);
            layoutUserInfo.setVisibility(View.GONE);
            tvProfileTitle.setText("Daftar Akun");
        }
    }
}
