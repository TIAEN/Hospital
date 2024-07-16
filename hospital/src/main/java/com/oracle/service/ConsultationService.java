package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.*;

import java.util.List;

public interface ConsultationService {

         //根据患者编号获取该患者的所有就诊记录
        List<Consultation> getConsultationsByPatientId(Integer patientId);

        //插入新的就诊记录
        void addConsultation(Consultation consultation);

        //删除新的就诊记录
        void deleteConsultation(Integer consultationId);

        //通过id来找到这个医生，并且返回它
        Doctor findDoctorByJobNumber(String jobNumber);

        //分页展示科室数据
        //返回的List是不包含分页的信息的
        //做返回类型的封装，PageInfo<T> 里面有分页后的数据信息和页码信息
        //封装一个分页对象返回，尽量不要把后台的mybatis对象进行返回

        List<Consultation> findAllConsultation();

        Integer getCurrentMaxConsultationId();

        PageInfo<Consultation> list(Integer pageNum, Integer pageSize);
}
