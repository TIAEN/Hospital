package com.oracle.servlet;

import com.oracle.pojo.Patient;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patientPayServlet")
public class PatientPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone=req.getParameter("phone");
        String name=req.getParameter("name");
        String cost=req.getParameter("cost");
        req.setAttribute("cost",cost);
        req.setAttribute("phone",phone);
        req.setAttribute("name",name);
        Patient patient=new Patient();
        PatientService patientService=new PatientServiceImpl();
        patient=patientService.selectPatientByPhone(phone);
        req.setAttribute("balance",patient.getBalance());
        req.getRequestDispatcher("/patient_pay.jsp").forward(req,resp);
    }
}
