package com.oracle.mapper;

import com.oracle.pojo.Appointment;

import java.util.List;

public interface AppointmentMapper {

    List<Appointment> selectAppointmentByPatientId(Integer id);

}