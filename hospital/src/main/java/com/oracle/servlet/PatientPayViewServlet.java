package com.oracle.servlet;

import com.oracle.pojo.Hospitalization;
import com.oracle.pojo.Patient;
import com.oracle.service.HospitalizationService;
import com.oracle.service.HospitalizationServiceImpl;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/patientPayViewServlet")
public class PatientPayViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone=req.getParameter("phone");
        PatientService patientService = new PatientServiceImpl();
        Patient patient=patientService.selectPatientByPhone(phone);
        String name=patient.getName();
        System.out.println("PatientPayViewServlet测试点"+phone+name);
        HospitalizationService hospitalizationService=new HospitalizationServiceImpl();
        List<Hospitalization> hospitalizations=new ArrayList<>();
        hospitalizations=hospitalizationService.selectHospitalizationByPhone(phone);
        req.setAttribute("hospitalizations",hospitalizations);
        req.getRequestDispatcher("/patient_pay_view.jsp").forward(req,resp);
    }
}
