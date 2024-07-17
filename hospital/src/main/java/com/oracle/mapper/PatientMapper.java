package com.oracle.mapper;

import com.oracle.pojo.Admin;
import com.oracle.pojo.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {

    List<Patient> selectPatientAll();

    Patient selectPatientByPhone(String phone);

    void setArranged1(Patient p);

    void setArranged0(Patient p);

    void pay(@Param("phone")String phone, @Param("pay")Float pay);

    //这是一次对不用分页插件的尝试，由于第3个参数是pageOffset，所以使用起来并不方便
    List<Patient> selectListBySome(@Param("patient") Patient patient,@Param("pageSize") Integer pageSize,@Param("pageOffset") Integer pageOffset);

    List<Patient> selectBySome(Patient patient);

    Patient selectPatientByIdCardNumber(String idCardNumber);

    Patient selectPatientByPatientId(Integer patientId);

    void updatePatientPasswordByPatientId(@Param("password") String password,@Param("patientId")Integer patientId);

    Integer selectCountByIdCardNumber(String idCardNumber);         //患者注册时候需要确保身份证号是唯一的

    void insertIntoPatient(Patient patient);

    Patient selectPatientsByName(String name);

    String selectMaxPatientId();
}
