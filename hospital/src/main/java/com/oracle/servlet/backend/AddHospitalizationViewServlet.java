package com.oracle.servlet.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addHospitalizationViewServlet")
public class AddHospitalizationViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientPhone=req.getParameter("patientPhone");
        req.setAttribute("patientPhone",patientPhone);
        System.out.println("----");
        System.out.println("AddHospitalizationViewServlet"+patientPhone);
        System.out.println("----");
        String patientName=req.getParameter("patientName");
        req.setAttribute("patientName",patientName);
        req.getRequestDispatcher("/doctor/patient/add.jsp").forward(req,resp);

    }
}
