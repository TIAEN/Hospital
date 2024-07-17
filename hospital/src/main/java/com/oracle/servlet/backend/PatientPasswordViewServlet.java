package com.oracle.servlet.backend;

import com.oracle.pojo.Patient;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/patientPasswordViewServlet")
public class PatientPasswordViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strPatientId=req.getParameter("patientId");
        Integer patientId=null;

        if(strPatientId!=null && !"".equals(strPatientId)){
            patientId=Integer.parseInt(strPatientId);
        }

        PatientService patientService=new PatientServiceImpl();
        Patient patient=patientService.findPatientByPatientId(patientId);

        req.setAttribute("patientId",patient.getPatientId());
        req.setAttribute("patientInfo",patient);
        req.getRequestDispatcher("/patientPassword.jsp").forward(req,resp);
    }
}
