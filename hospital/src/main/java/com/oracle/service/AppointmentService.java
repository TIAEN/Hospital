package com.oracle.service;

import com.oracle.pojo.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> appointmentListByPatientId(Integer id);

    void insertAppointment(Appointment appointment);

    void cancelAppointment(Integer id);

    Appointment getAppointmentById(Integer id);

    List<Appointment> getAppointmentOrderBy();
}
