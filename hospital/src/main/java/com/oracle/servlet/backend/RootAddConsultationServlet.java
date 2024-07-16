package com.oracle.servlet.backend;

import com.oracle.service.ConsultationService;
import com.oracle.service.ConsultationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/rootAddConsultationServlet")

public class RootAddConsultationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultationService consultationService=new ConsultationServiceImpl();
        req.setAttribute("rootConsultationList",consultationService.findAllConsultation());
        req.getRequestDispatcher("/admin/doctor/root_consultation.jsp").forward(req, resp);
    }
}
