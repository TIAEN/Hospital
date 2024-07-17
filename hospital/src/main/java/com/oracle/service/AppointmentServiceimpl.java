package com.oracle.service;


import com.oracle.mapper.AppointmentMapper;
import com.oracle.pojo.Appointment;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AppointmentServiceimpl implements AppointmentService {

    @Override
    public List<Appointment> appointmentListByPatientId(Integer id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AppointmentMapper appointmentMapper= sqlSession.getMapper(AppointmentMapper.class);
        List<Appointment> appointmentList=appointmentMapper.selectAppointmentByPatientId(id);
        sqlSession.close();
        return appointmentList;
    }

    @Override
    public void insertAppointment(Appointment appointment) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AppointmentMapper appointmentMapper= sqlSession.getMapper(AppointmentMapper.class);
        appointmentMapper.insertAppointment(appointment);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void cancelAppointment(Integer id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AppointmentMapper appointmentMapper= sqlSession.getMapper(AppointmentMapper.class);
        appointmentMapper.cancelAppointment(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Appointment getAppointmentById(Integer id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AppointmentMapper appointmentMapper= sqlSession.getMapper(AppointmentMapper.class);
        Appointment appointment=appointmentMapper.selectAppointmentById(id);
        //System.out.println("::::;;;;;;;;;;;;;;;;;;;"+id);
        sqlSession.close();
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentOrderBy() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AppointmentMapper appointmentMapper= sqlSession.getMapper(AppointmentMapper.class);
        List<Appointment> appointmentList=appointmentMapper.selectAllOrderBy();
        sqlSession.close();
        return appointmentList;
    }
}
