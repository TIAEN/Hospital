package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Hospitalization;

import java.util.List;

public interface HospitalizationService {
    void insertHospitalization(Hospitalization hospitalization);
    PageInfo<Hospitalization> list(Integer pageNum, Integer pageSize);
    List<Hospitalization> selectHospitalizationByPhone (String phone);
    void pay(Hospitalization hospitalization);
    void enter(Hospitalization hospitalization);
    void discharge(Hospitalization hospitalization);
}
