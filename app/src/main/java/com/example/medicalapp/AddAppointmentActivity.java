package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText firstNameTxt = findViewById(R.id.firstNameTxt);
        EditText lastNameTxt = findViewById(R.id.lastNameTxt);
        EditText emailTxt = findViewById(R.id.emailTxt);
        EditText phoneTxt = findViewById(R.id.phoneTxt);
        EditText ageTxt = findViewById(R.id.ageTxt);
        RadioGroup sexRadioGroup = findViewById(R.id.sexRadioGroup);
        Button saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {
            String firstName = firstNameTxt.getText().toString().trim();
            String lastName = lastNameTxt.getText().toString().trim();
            String email = emailTxt.getText().toString().trim();
            String phone = phoneTxt.getText().toString().trim();
            String ageStr = ageTxt.getText().toString().trim();

            if (firstName.isEmpty()) { firstNameTxt.setError(getString(R.string.error_required)); return; }
            if (lastName.isEmpty()) { lastNameTxt.setError(getString(R.string.error_required)); return; }
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) { emailTxt.setError(getString(R.string.error_invalid_email)); return; }
            if (phone.isEmpty() || !phone.matches("\\d+")) { phoneTxt.setError(getString(R.string.error_invalid_phone)); return; }
            if (ageStr.isEmpty()) { ageTxt.setError(getString(R.string.error_required)); return; }

            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                ageTxt.setError(getString(R.string.error_required));
                return;
            }

            if (age < 0 || age > 120) { ageTxt.setError(getString(R.string.error_invalid_age)); return; }

            int selectedSexId = sexRadioGroup.getCheckedRadioButtonId();
            if (selectedSexId == -1) { Toast.makeText(this, R.string.error_select_sex, Toast.LENGTH_SHORT).show(); return; }

            RadioButton selectedRadio = findViewById(selectedSexId);
            String sex = selectedRadio.getText().toString();

            AppointmentManager.getInstance().addPatient(new Patient(firstName, lastName, email, phone, age, sex));
            Toast.makeText(this, "Appointment Saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}