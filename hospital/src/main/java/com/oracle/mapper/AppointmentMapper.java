package com.oracle.mapper;

import com.oracle.pojo.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapper {


    List<Appointment> selectAppointmentByPatientId(Integer id);//ceshi
}
