package com.oracle.service;

import com.oracle.pojo.Patients;

public interface PatientService {

    Patients selectPatientByName(String name);

    boolean login(Patients patients);


}
