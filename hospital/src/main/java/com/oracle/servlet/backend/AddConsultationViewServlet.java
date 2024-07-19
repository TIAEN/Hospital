package com.oracle.servlet.backend;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Announcement;
import com.oracle.pojo.Appointment;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/backend/addConsultationViewServlet")
public class AddConsultationViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppointmentService appointmentService=new AppointmentServiceimpl();

        String appointmentId=req.getParameter("appointmentId");

        Integer ID=Integer.parseInt(appointmentId);

        Appointment appointment=appointmentService.getAppointmentById(ID);

        ConsultationService consultationService=new ConsultationServiceImpl();
        Integer currentMaxConsultationId=consultationService.getCurrentMaxConsultationId();
        currentMaxConsultationId+=1;
        req.setAttribute("consultationId",currentMaxConsultationId);

        req.setAttribute("appointment",appointment);


        /*PatientService patientService = new PatientServiceimpl();
        Integer currentMaxPatientId=patientService.getCurrentMaxPatientId();
        currentMaxPatientId+=1;
        req.setAttribute("patientId",currentMaxPatientId);*/


        req.getRequestDispatcher("/admin/doctor/addConsultation.jsp").forward(req,resp);

    }
}
