package com.oracle.servlet.patient;

import com.oracle.pojo.Appointment;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patient/rootAppointmentServlet")

public class RootAppointmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String patientID = req.getParameter("patientID");
        String patientID="1";
        Integer patientId=null;
        if (patientID != null&&!patientID.equals("")) {
            patientId = Integer.parseInt(patientID);
        }

        AppointmentService appointmentService = new AppointmentServiceimpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceImpl();


        List<Appointment> appointmentList=appointmentService.appointmentList(patientId);

        for (Appointment appointment:appointmentList) {
            appointment.setDoctorName(doctorService.findDoctorNameById(appointment.getDoctorId()));
            appointment.setPatientName(patientService.selectPatientNameById(appointment.getPatientId()));
            System.out.println(appointment);
        }

        req.setAttribute("appointmentList", appointmentList);

        req.getRequestDispatcher("/public/patient/root_appointment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String patientID = req.getParameter("patientID");
        String patientID="1";
        Integer patientId=null;
        if (patientID != null&&!patientID.equals("")) {
            patientId = Integer.parseInt(patientID);
        }

        AppointmentService appointmentService = new AppointmentServiceimpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceImpl();


        List<Appointment> appointmentList=appointmentService.appointmentList(patientId);

        for (Appointment appointment:appointmentList) {
            appointment.setDoctorName(doctorService.findDoctorNameById(appointment.getDoctorId()));
            appointment.setPatientName(patientService.selectPatientNameById(appointment.getPatientId()));
            System.out.println(appointment);
        }

        req.setAttribute("appointmentList", appointmentList);
        req.getRequestDispatcher("/public/patient/root_appointment.jsp").forward(req, resp);
    }
}
