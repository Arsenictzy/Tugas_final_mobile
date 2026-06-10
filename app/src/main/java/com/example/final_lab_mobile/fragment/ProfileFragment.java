package com.example.final_lab_mobile.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import com.example.final_lab_mobile.R;
import com.example.final_lab_mobile.storage.SharedPrefsManager;
import com.google.android.material.materialswitch.MaterialSwitch;

public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        MaterialSwitch switchTheme = view.findViewById(R.id.switchTheme);
        SharedPrefsManager prefs = new SharedPrefsManager(requireContext());

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
}
