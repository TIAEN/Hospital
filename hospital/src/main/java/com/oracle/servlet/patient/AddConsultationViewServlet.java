package com.oracle.servlet.patient;

import com.oracle.service.ConsultationService;
import com.oracle.service.ConsultationServiceImpl;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/patient/addConsultationViewServlet")
public class AddConsultationViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultationService consultationService=new ConsultationServiceImpl();
        Integer currentMaxConsultationId=consultationService.getCurrentMaxJobNumber();
        currentMaxConsultationId+=1;
        req.setAttribute("jobNumber",currentMaxConsultationId);
        req.getRequestDispatcher("/public/patient/addConsultationList.jsp").forward(req,resp);

    }
}
