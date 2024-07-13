package com.oracle.mapper;

import com.oracle.pojo.Consultation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsultationMapper {

        //根据就诊编号获取就诊记录
        Consultation getConsultationById(Integer consultationId);
        //根据患者编号获取该患者的所有就诊记录
        List<Consultation> getConsultationsByPatientId(Integer patientId);
        //插入新的就诊记录
        void insertConsultation(Consultation consultation);
        //删除新的就诊记录
        void deleteConsultation(Integer consultationId);
}
