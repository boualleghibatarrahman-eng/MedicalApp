package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView totalTxt = findViewById(R.id.totalTxt);
        TextView maleTxt = findViewById(R.id.maleTxt);
        TextView femaleTxt = findViewById(R.id.femaleTxt);
        TextView avgAgeTxt = findViewById(R.id.avgAgeTxt);

        int total = AppointmentManager.getInstance().getPatients().size();
        int maleCount = 0, femaleCount = 0, totalAge = 0;

        for (Patient p : AppointmentManager.getInstance().getPatients()) {
            if (p.getSex().equalsIgnoreCase("Male")) maleCount++;
            else if (p.getSex().equalsIgnoreCase("Female")) femaleCount++;
            totalAge += p.getAge();
        }

        double avgAge = total > 0 ? (double) totalAge / total : 0;

        totalTxt.setText("Total Appointments: " + total);
        maleTxt.setText("Male Patients: " + maleCount);
        femaleTxt.setText("Female Patients: " + femaleCount);
        avgAgeTxt.setText(String.format("Average Age: %.1f", avgAge));
    }
}