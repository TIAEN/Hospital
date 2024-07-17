package com.oracle.servlet.backend;


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

@WebServlet("/backend/patientPasswordServlet")
public class PatientPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strPatientId=req.getParameter("patientId");
        Integer patientId=null;

        if(strPatientId!=null && !"".equals(strPatientId)){
            patientId=Integer.parseInt(strPatientId);
        }

        PatientService patientService=new PatientServiceImpl();
        Patient patient=patientService.findPatientByPatientId(patientId);
        req.setAttribute("patientInfo",patient);

        String originalPassword=req.getParameter("originalPassword");
        String newPassword=req.getParameter("newPassword");
        String repeatNewPassword=req.getParameter("repeatNewPassword");

        System.out.println("这是一个用于测试密码的精致的测试点");
        System.out.println(newPassword);
        System.out.println(repeatNewPassword);

        if(!DigestUtils.md5Hex(originalPassword).equals(patient.getPassword())){
            req.setAttribute("patientId",patient.getPatientId());
            req.setAttribute("passwordError","原始密码错误，请重新输入");
            req.getRequestDispatcher("/patientPassword.jsp").forward(req,resp);
            return;
        }

        if(!newPassword.equals(repeatNewPassword)){
            req.setAttribute("patientId",patient.getPatientId());
            req.setAttribute("passwordError","两次输入的密码不一致，请重新输入");
            req.getRequestDispatcher("/patientPassword.jsp").forward(req,resp);
            return;
        }

        patientService.changePatientPasswordByPatientId(DigestUtils.md5Hex(newPassword),patientId);
        req.setAttribute("passwordSuccess","修改成功");
        req.getRequestDispatcher("/patientPassword.jsp").forward(req,resp);
    }
}
