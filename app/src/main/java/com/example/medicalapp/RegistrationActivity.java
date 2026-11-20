package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText regUserTxt = findViewById(R.id.regUserTxt);
        EditText regPassTxt = findViewById(R.id.regPassTxt);
        Button registerConfirmBtn = findViewById(R.id.registerConfirmBtn);

        registerConfirmBtn.setOnClickListener(v -> {
            if (regUserTxt.getText().toString().trim().isEmpty() || regPassTxt.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}