package com.oracle.service;

import com.oracle.pojo.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> appointmentList(Integer id);

    void insertAppointment(Appointment appointment);
}
