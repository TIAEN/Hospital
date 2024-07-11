package com.oracle.service;

import com.oracle.mapper.PatientsMapper;
import com.oracle.pojo.Patients;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

public class PatientServiceimpl implements PatientService {

    @Override
    public Patients selectPatientByName(String name) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientsMapper patientsMapper = sqlSession.getMapper(PatientsMapper.class);
        Patients patients=patientsMapper.selectPatientsByName(name);
        sqlSession.close();
        return patients;
    }
}
