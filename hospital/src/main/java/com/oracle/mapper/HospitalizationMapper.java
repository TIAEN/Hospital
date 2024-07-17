package com.oracle.mapper;

import com.oracle.pojo.Hospitalization;

import java.util.List;

public interface HospitalizationMapper {
    void insertHospitalization(Hospitalization hospitalization);
    List<Hospitalization> selectHospitalizationAll();
    List<Hospitalization> selectHospitalizationByPhone(String phone);
    void pay(Hospitalization hospitalization);
    void enter(Hospitalization hospitalization);
    void discharge(Hospitalization hospitalization);
}
