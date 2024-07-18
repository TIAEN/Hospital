package com.oracle.servlet.patient;

import com.oracle.pojo.Appointment;
import com.oracle.pojo.BookAppointment;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//后台添加
@WebServlet("/patient/addAppointmentServlet")
public class AddAppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pPatientId=req.getParameter("patientId");
        String pDoctorId=req.getParameter("doctorId");
        String pDate=req.getParameter("Date");
        String pTime=req.getParameter("Time");

        Integer PatientId=null;
        Integer DoctorId=null;

        if(pPatientId!=null&&!pPatientId.equals("")){
            PatientId=Integer.parseInt(pPatientId);
        }

        if(pDoctorId!=null&&!pDoctorId.equals("")){
            DoctorId=Integer.parseInt(pDoctorId);
        }

        String dateString=pDate+" "+pTime;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=null;
        try {
            date = inputFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(date+"-----------");

        DepartmentService departmentService=new DepartmentServiceImpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceImpl();
        AppointmentService appointmentService=new AppointmentServiceimpl();
        BookAppointmentService bookAppointmentService=new BookAppointmentServiceimpl();

        Appointment appointment=new Appointment();
        appointment.setDoctorId(DoctorId);
        System.out.println("AddAppointmentServlet测试点"+appointment.getDoctorId());
        appointment.setPatientId(PatientId);
        System.out.println("AddAppointmentServlet测试点"+appointment.getPatientId());
        appointment.setAppointmentDate(date);
        appointment.setAppointmentId(null);
        appointment.setCurrentStatus("booked");


        BookAppointment bookAppointment=new BookAppointment();
        bookAppointment.setAppointmentDate(date);
        bookAppointment.setBookNumber(5);

        if(!bookAppointmentService.isExistBookAppointmentByDate(date)){
            bookAppointmentService.insertBookAppointment(bookAppointment);
        }

        bookAppointmentService.updateBookAppointment(bookAppointment);

        List<Appointment> appointmentList=appointmentService.appointmentList(PatientId);
        System.out.println("222222222222222222222222222222222");
        req.setAttribute("patientId",PatientId);
        req.setAttribute("appointmentList",appointmentList);
        System.out.println("AddAppointmentServlet测试点"+appointment);
        req.getRequestDispatcher("/public/patient/root_appointment.jsp").forward(req, resp);

    }
}

