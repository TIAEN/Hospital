package com.oracle.servlet.backend;

import com.oracle.pojo.Appointment;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/backend/rootAddConsultationServlet")

public class RootAddConsultationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobNumber= req.getParameter("jobNumber");
        req.getSession().setAttribute("jobNumber", jobNumber);

        AppointmentService appointmentService=new AppointmentServiceimpl();
        DoctorService doctorService=new DoctorServiceImpl();

        List<Appointment> appointmentList=appointmentService.getAllOrderByDoctorId(doctorService.getDoctorByJobNumber(jobNumber).getDoctorId());

        req.setAttribute("appointmentList", appointmentList);

        ConsultationService consultationService=new ConsultationServiceImpl();
        //req.setAttribute("rootConsultationList",consultationService.findAllConsultation());
        req.getRequestDispatcher("/admin/doctor/root_consultation.jsp").forward(req, resp);
    }
}
