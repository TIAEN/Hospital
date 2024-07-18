package com.oracle.mapper;

import com.oracle.pojo.BookAppointment;

import java.util.Date;
import java.util.List;

public interface BookAppointmentMapper {

   boolean isExistAppointmentDate(Date appointmentDate);

   List<BookAppointment> selectAll();

   void insertBookAppointment(BookAppointment bookAppointment);

   void updateBookAppointment(BookAppointment bookAppointment);

   void updateBookAppointmentAdd(Date appointmentDate);

   BookAppointment selectBookAppointmentByDate(Date date);

}
