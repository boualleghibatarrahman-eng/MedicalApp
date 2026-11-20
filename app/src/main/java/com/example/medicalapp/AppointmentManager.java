package com.example.medicalapp;

import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {
    private static AppointmentManager instance;
    private List<Patient> patients;

    private AppointmentManager() {
        patients = new ArrayList<>();
    }

    public static AppointmentManager getInstance() {
        if (instance == null) {
            instance = new AppointmentManager();
        }
        return instance;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}