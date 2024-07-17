package com.oracle.servlet.backend;

import javax.servlet.annotation.WebServlet;

import com.oracle.pojo.Patient;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addPatientServlet")
public class AddPatientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String idCardNumber=req.getParameter("idCardNumber");
        String password=req.getParameter("password");

        Patient patient=new Patient(null,idCardNumber,password,name,null,phone,email,null,null);

        req.setAttribute("patientInfo",patient);

        if(name==null || "".equals(name)){
            req.setAttribute("addError","请输入姓名");
            req.getRequestDispatcher("/admin/patient/add.jsp").forward(req,resp);
        }

        if(password==null || "".equals(password)){
            req.setAttribute("addError","请输入密码");
            req.getRequestDispatcher("/admin/patient/add.jsp").forward(req,resp);
        }

        if(idCardNumber==null || "".equals(idCardNumber)){
            req.setAttribute("addError","请输入身份证号");
            req.getRequestDispatcher("/admin/patient/add.jsp").forward(req,resp);
        }

        patient.setPassword(DigestUtils.md5Hex(patient.getPassword()));

        PatientService patientService=new PatientServiceImpl();
        patientService.addPatient(patient);

        resp.sendRedirect(req.getContextPath()+"/backend/rootDepartmentServlet");

    }
}
