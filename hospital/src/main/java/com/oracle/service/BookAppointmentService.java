package com.oracle.service;

import com.oracle.pojo.BookAppointment;

import java.util.Date;
import java.util.List;

public interface BookAppointmentService {
    List<BookAppointment> getBookAppointmentAll();

    void insertBookAppointment(BookAppointment bookAppointment);

    boolean isExistBookAppointmentByDate(Date date);

    void updateBookAppointment(BookAppointment bookAppointment);

    void updateBookAppointmentAdd(Date appointmentDate);

    BookAppointment getBookAppointmentByDate(Date date);
}
