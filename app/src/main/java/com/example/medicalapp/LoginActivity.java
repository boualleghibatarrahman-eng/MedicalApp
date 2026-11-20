package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText loginUserTxt = findViewById(R.id.loginUserTxt);
        EditText loginPassTxt = findViewById(R.id.loginPassTxt);
        Button loginBtn = findViewById(R.id.loginBtn);
        Button goRegisterBtn = findViewById(R.id.goRegisterBtn);

        loginBtn.setOnClickListener(v -> {
            if (loginUserTxt.getText().toString().trim().isEmpty() || loginPassTxt.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Please enter credentials", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(new Intent(LoginActivity.this, ListActivity.class));
            finish();
        });

        goRegisterBtn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));
    }
}