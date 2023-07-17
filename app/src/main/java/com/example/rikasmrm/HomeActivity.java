package com.example.rikasmrm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button buttonViewProfile;
    private LocalStorage localStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        localStorage = new LocalStorage(this);

        buttonViewProfile = findViewById(R.id.buttonViewProfile);
        buttonViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewUserProfile();
            }
        });
    }

    private void viewUserProfile() {
        if (localStorage.isLoggedIn()) {
            String userId = localStorage.getUserId();
            String email = localStorage.getUserEmail();
            String name = localStorage.getUserName();
            String dob = localStorage.getUserDOB();
            String gender = localStorage.getUserGender();
            String company = localStorage.getUserCompany();
            String position = localStorage.getUserPosition();

            View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_profile, null);
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(bottomSheetView);

            TextView textViewUserId = bottomSheetDialog.findViewById(R.id.textViewUserId);
            TextView textViewEmail = bottomSheetDialog.findViewById(R.id.textViewEmail);
            TextView textViewName = bottomSheetDialog.findViewById(R.id.textViewName);
            TextView textViewDOB = bottomSheetDialog.findViewById(R.id.textViewDOB);
            TextView textViewGender = bottomSheetDialog.findViewById(R.id.textViewGender);
            TextView textViewCompany = bottomSheetDialog.findViewById(R.id.textViewCompany);
            TextView textViewPosition = bottomSheetDialog.findViewById(R.id.textViewPosition);

            if (textViewUserId != null) {
                textViewUserId.setText("User ID: " + userId);
            }
            if (textViewEmail != null) {
                textViewEmail.setText("Email: " + email);
            }
            if (textViewName != null) {
                textViewName.setText("Name: " + name);
            }
            if (textViewDOB != null) {
                textViewDOB.setText("DOB: " + dob);
            }
            if (textViewGender != null) {
                textViewGender.setText("Gender: " + gender);
            }
            if (textViewCompany != null) {
                textViewCompany.setText("Company: " + company);
            }
            if (textViewPosition != null) {
                textViewPosition.setText("Position: " + position);
            }

            bottomSheetDialog.show();
        } else {
            Toast.makeText(this, "User data not found", Toast.LENGTH_SHORT).show();
        }
    }

}
