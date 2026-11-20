package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private List<String> patientStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView patientsListView = findViewById(R.id.patientsListView);
        Button addNewBtn = findViewById(R.id.addNewBtn);
        Button viewStatsBtn = findViewById(R.id.viewStatsBtn);

        patientStrings = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, patientStrings);
        patientsListView.setAdapter(adapter);

        addNewBtn.setOnClickListener(v -> startActivity(new Intent(ListActivity.this, AddAppointmentActivity.class)));
        viewStatsBtn.setOnClickListener(v -> startActivity(new Intent(ListActivity.this, StatisticsActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        patientStrings.clear();
        for (Patient p : AppointmentManager.getInstance().getPatients()) {
            patientStrings.add(p.getLastName() + " " + p.getFirstName() + " (" + p.getAge() + " years)");
        }
        adapter.notifyDataSetChanged();
    }
}