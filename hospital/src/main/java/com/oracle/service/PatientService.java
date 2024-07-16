package com.oracle.service;

import com.oracle.pojo.Patients;

public interface PatientService {

    Patients selectPatientByName(String name);

    Patients selectPatientById(Integer id);

}
