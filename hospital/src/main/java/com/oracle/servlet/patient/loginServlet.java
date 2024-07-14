package com.oracle.servlet.patient;

import com.oracle.pojo.Patients;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/patient/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("username");
        String pwd = req.getParameter("password");
        String requestCode= req.getParameter("code");

        HttpSession session = req.getSession();
        String sessionCode=(String)session.getAttribute("valcode");
        if(requestCode==null||"".equals(requestCode)||!requestCode.equals(sessionCode)){

            req.setAttribute("capError","验证码有误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;

        }else{
            req.setAttribute("capError","");
        }

        Patients patients = new Patients();
        patients.setPatientName(loginName);
        patients.setPatientPassword(pwd);

        resp.sendRedirect(req.getContextPath()+"/patient_main.jsp");
    }
}
