package com.oracle.servlet.patient;

import com.oracle.service.*;

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
        Integer currentMaxConsultationId=consultationService.getCurrentMaxConsultationId();
        currentMaxConsultationId+=1;
        req.setAttribute("consultationId",currentMaxConsultationId);
        req.getRequestDispatcher("/public/patient/addConsultation.jsp").forward(req,resp);

    }
}
