package com.oracle.mapper;

import com.oracle.pojo.Appointment;

import java.util.List;

public interface AppointmentMapper {

    List<Appointment> selectAppointmentByPatientId(Integer id);

    void insertAppointment(Appointment appointment);

    void cancelAppointment(Integer id);

    List<Appointment> selectAllOrderBy();

    Appointment selectAppointmentById(Integer id);
}