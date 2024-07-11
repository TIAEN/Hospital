package com.oracle.service;


import com.oracle.mapper.AppointmentMapper;
import com.oracle.pojo.Appointment;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AppointmentServiceimpl implements AppointmentService {

    @Override
    public List<Appointment> appointmentList(Integer id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AppointmentMapper appointmentMapper= sqlSession.getMapper(AppointmentMapper.class);
        List<Appointment> appointmentList=appointmentMapper.selectAppointmentByPatientId(id);
        sqlSession.close();
        return appointmentList;
    }
}
