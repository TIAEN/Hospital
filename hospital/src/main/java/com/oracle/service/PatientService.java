package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Patient;

import java.util.List;

public interface PatientService {

    PageInfo<Patient> pageList(Integer pageNum, Integer pageSize);       //对分页进行包装

    List<Patient> findPatientBySome(Patient patient, Integer pageSize, Integer pageOffset);

    PageInfo<Patient> findPageList(Patient patient,Integer pageNum,Integer pageSize);

    boolean login(Patient patient);

    void encryption(Integer patientId);

    Integer findCountByIdCardNumber(String idCardNumber);

    void addPatient(Patient patient);

    Patient selectPatientByName(String name);

    Integer getCurrentMaxPatientId();

    //添加处

    Patient selectPatientByPhone(String phone);

    void setArranged1(Patient patient);

    void setArranged0(Patient patient);

    void pay(String phone,Float pay);

    Patient findPatientByIdCardNumber(String idCardNumber);
}
