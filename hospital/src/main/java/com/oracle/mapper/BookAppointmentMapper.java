package com.oracle.mapper;

import com.oracle.pojo.BookAppointment;

import java.util.Date;
import java.util.List;

public interface BookAppointmentMapper {

   BookAppointment selectByAppointmentDate(Date appointmentDate);

   List<BookAppointment> selectAll();
}
