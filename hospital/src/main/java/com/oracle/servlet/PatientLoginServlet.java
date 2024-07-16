package com.oracle.servlet;

import com.oracle.pojo.Patient;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/patientLoginServlet")
public class PatientLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCardNumber=req.getParameter("idCardNumber");
        String password=req.getParameter("password");
        String requestCode=req.getParameter("code");

        //校验验证码
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

        Patient patient=new Patient();
        patient.setEmail(null);
        patient.setBalance(null);
        patient.setPhone(null);
        patient.setPatientId(null);
        patient.setPassword(password);
        patient.setIdCardNumber(idCardNumber);
        patient.setAvatar(null);
        patient.setName(null);

        PatientService patientService=new PatientServiceImpl();
        if(patientService.login(patient)){
            resp.sendRedirect(req.getContextPath()+"/patientMain.jsp");
        }
        else{
            req.setAttribute("loginError","用户名不存在或密码错误");
            req.getRequestDispatcher("/patientLogin.jsp").forward(req,resp);
        }
    }
}
