package com.oracle.servlet.patient;

import com.oracle.pojo.Patient;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/appointmentListServlet")
public class AppointmentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientName=req.getParameter("patientName");
        Integer id=null;
        AppointmentService appointmentService=new AppointmentServiceimpl();
        DepartmentService departmentService=new DepartmentServiceImpl();
        PatientService patientService=new PatientServiceImpl();

        Patient patient =patientService.selectPatientByName(patientName);
        Integer patientId= patient.getPatientId();
        req.setAttribute("appointmentList",appointmentService.appointmentList(patientId));

        req.getRequestDispatcher("/public/patient/root_appointment.jsp").forward(req, resp);
    }




}
