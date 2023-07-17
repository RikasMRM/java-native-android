package com.example.rikasmrm;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorage {
    private static final String PREF_NAME = "MyAppPrefs";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_DOB = "user_dob";
    private static final String KEY_USER_GENDER = "user_gender";
    private static final String KEY_USER_COMPANY = "user_company";
    private static final String KEY_USER_POSITION = "user_position";

    private SharedPreferences sharedPreferences;

    public LocalStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUserData(String userId, String email, String name, String dob, String gender, String company, String position) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ID, userId);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USER_NAME, name);
        editor.putString(KEY_USER_DOB, dob);
        editor.putString(KEY_USER_GENDER, gender);
        editor.putString(KEY_USER_COMPANY, company);
        editor.putString(KEY_USER_POSITION, position);
        editor.apply();
    }

    public String getUserId() {
        return sharedPreferences.getString(KEY_USER_ID, "");
    }

    public String getUserEmail() {
        return sharedPreferences.getString(KEY_USER_EMAIL, "");
    }

    public String getUserName() {
        return sharedPreferences.getString(KEY_USER_NAME, "");
    }

    public String getUserDOB() {
        return sharedPreferences.getString(KEY_USER_DOB, "");
    }

    public String getUserGender() {
        return sharedPreferences.getString(KEY_USER_GENDER, "");
    }

    public String getUserCompany() {
        return sharedPreferences.getString(KEY_USER_COMPANY, "");
    }

    public String getUserPosition() {
        return sharedPreferences.getString(KEY_USER_POSITION, "");
    }

    public boolean isLoggedIn() {
        return !sharedPreferences.getString(KEY_USER_ID, "").isEmpty();
    }

    public void clearUserData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
