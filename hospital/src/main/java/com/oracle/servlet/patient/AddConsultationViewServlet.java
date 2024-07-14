package com.oracle.servlet.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/addConsultationViewServlet")
public class AddConsultationViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer patientId = Integer.valueOf(req.getParameter("patientId"));
        Integer doctorId = Integer.valueOf(req.getParameter("doctorId"));
        req.setAttribute("patientId",patientId);
        req.setAttribute("doctorId",doctorId);
        req.getRequestDispatcher("/public/patient/addConsultationList.jsp").forward(req,resp);

    }
}
