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

@WebServlet("/backend/modifyPatientServlet")
public class ModifyPatientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strPatientId=req.getParameter("patientId");
        Integer patientId=null;
        if(strPatientId!=null && !"".equals(strPatientId)){
            patientId=Integer.parseInt(strPatientId);
        }

        String phone=req.getParameter("phone");
        String email=req.getParameter("email");

        PatientService patientService=new PatientServiceImpl();
        patientService.changePatientEmailByPatientId(email,patientId);
        patientService.changePatientPhoneByPatientId(phone,patientId);

        Patient patient=patientService.findPatientByPatientId(patientId);

        req.setAttribute("patientId",patient.getPatientId());
        req.setAttribute("patientInfo",patient);
        req.getRequestDispatcher("/patientDetails.jsp").forward(req,resp);
    }
}
