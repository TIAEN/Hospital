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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/backend/patientRegisterServlet")
public class PatientRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String idCardNumber=req.getParameter("idCardNumber");
        String password=req.getParameter("password");
        String passwordAgain=req.getParameter("passwordAgain");
        String requestCode=req.getParameter("code");

        PatientService patientService=new PatientServiceImpl();

        HttpSession session=req.getSession();
        String sessionCode=(String) session.getAttribute("valcode");
        if(requestCode==null||"".equals(requestCode)||!requestCode.equals(sessionCode)){
            req.setAttribute("capError","验证码有误");
            req.getRequestDispatcher("/patientLogin.jsp").forward(req,resp);
            return;
        }
        else{
            req.setAttribute("capError","");
        }

        if(patientService.findCountByIdCardNumber(idCardNumber)!=0){
            req.setAttribute("registerError","身份证号码已存在，请确保您输入的身份证号正确");
            req.getRequestDispatcher("/patientRegister.jsp").forward(req,resp);
            return;
        }

        if(password==null || "".equals(password)){
            req.setAttribute("registerError","请输入密码");
            req.getRequestDispatcher("/patientRegister.jsp").forward(req,resp);
            return;
        }

        if(name==null || "".equals(name)){
            req.setAttribute("registerError","请输入姓名");
            req.getRequestDispatcher("/patientRegister.jsp").forward(req,resp);
            return;
        }

        if(passwordAgain==null || "".equals(passwordAgain)){
            req.setAttribute("registerError","请再次输入密码");
            req.getRequestDispatcher("/patientRegister.jsp").forward(req,resp);
            return;
        }

        if(!passwordAgain.equals(password)){
            req.setAttribute("registerError","请确保两次输入的密码一致");
            req.getRequestDispatcher("/patientRegister.jsp").forward(req,resp);
            return;
        }

        Patient patient=new Patient();
        patient.setName(name);
        patient.setPatientId(null);
        patient.setPassword(DigestUtils.md5Hex(password));
        patient.setAvatar(null);
        patient.setBalance(new BigDecimal(0));
        patient.setPhone(null);
        patient.setIdCardNumber(idCardNumber);
        patient.setEmail(null);
        patientService.addPatient(patient);

        resp.sendRedirect(req.getContextPath()+"/patientLogin.jsp");
    }
}
