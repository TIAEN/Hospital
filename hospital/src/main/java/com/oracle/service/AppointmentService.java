package com.oracle.service;

import com.oracle.pojo.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> appointmentList(Integer id);

    void insertintoAppointment(Appointment appointment);

    void cancelAppointment(Integer id);

    Appointment getAppointmentById(Integer id);

    List<Appointment> getAppointmentOrderBy();

    List<Appointment> getAllOrderByDoctorId(Integer id);
}
