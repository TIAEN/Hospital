package com.oracle.mapper;

import com.oracle.pojo.Patients;

public interface PatientsMapper {

    Patients selectPatientsByName(String name);

    Patients selectPatientsById(Integer id);
}
