package com.oracle.service;

import com.oracle.pojo.BookAppointment;

import java.util.List;

public interface BookAppointmentService {
    List<BookAppointment> getBookAppointmentAll();

    //void insertBookAppointment(BookAppointment bookAppointment);
}
