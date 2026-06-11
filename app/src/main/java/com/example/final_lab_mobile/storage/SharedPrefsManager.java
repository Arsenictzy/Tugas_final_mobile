package com.example.final_lab_mobile.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.final_lab_mobile.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefsManager {
    private SharedPreferences prefs;
    private Gson gson;

    public SharedPrefsManager(Context context) {
        prefs = context.getSharedPreferences("OutdoorPrefs", Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveCache(List<Product> products) {
        prefs.edit().putString("CACHE_PRODUCTS", gson.toJson(products)).apply();
    }

    public List<Product> getCache() {
        String json = prefs.getString("CACHE_PRODUCTS", null);
        if (json == null) return new ArrayList<>();
        Type type = new TypeToken<List<Product>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public void saveFavorite(Product product) {
        List<Product> favs = getFavorites();
        for (Product p : favs) {
            if (p.getId() == product.getId()) return;
        }
        favs.add(product);
        prefs.edit().putString("FAV_PRODUCTS", gson.toJson(favs)).apply();
    }

    public void removeFavorite(int productId) {
        List<Product> favs = getFavorites();
        favs.removeIf(p -> p.getId() == productId);
        prefs.edit().putString("FAV_PRODUCTS", gson.toJson(favs)).apply();
    }

    public List<Product> getFavorites() {
        String json = prefs.getString("FAV_PRODUCTS", "[]");
        Type type = new TypeToken<List<Product>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public boolean isFavorite(int productId) {
        for (Product p : getFavorites()) {
            if (p.getId() == productId) return true;
        }
        return false;
    }

    public void setTheme(boolean isDark) {
        prefs.edit().putBoolean("DARK_MODE", isDark).apply();
    }

    public boolean getTheme() {
        return prefs.getBoolean("DARK_MODE", false);
    }

    // User Account & Session
    public void registerUser(String email, String password) {
        prefs.edit().putString("USER_EMAIL", email).apply();
        prefs.edit().putString("USER_PASSWORD", password).apply();
    }

    public boolean checkLogin(String email, String password) {
        String savedEmail = prefs.getString("USER_EMAIL", "");
        String savedPass = prefs.getString("USER_PASSWORD", "");
        return email.equals(savedEmail) && password.equals(savedPass);
    }

    public void setLoggedIn(boolean isLoggedIn) {
        prefs.edit().putBoolean("IS_LOGGED_IN", isLoggedIn).apply();
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean("IS_LOGGED_IN", false);
    }

    public String getUserEmail() {
        return prefs.getString("USER_EMAIL", "Guest");
    }

    public void logout() {
        prefs.edit().putBoolean("IS_LOGGED_IN", false).apply();
    }
}
