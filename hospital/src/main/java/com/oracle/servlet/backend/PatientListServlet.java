package com.oracle.servlet.backend;


import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Patient;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/patientListServlet")
public class PatientListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strPgeNum=req.getParameter("pageNum");

        Integer pageNum=1;
        Integer pageSize=4;

        if(strPgeNum!=null && !"".equals(strPgeNum)){
            pageNum=Integer.parseInt(strPgeNum);
        }

        PatientService patientService=new PatientServiceImpl();
        PageInfo<Patient> patientPageInfo=patientService.pageList(pageNum,pageSize);

        req.setAttribute("patientList",patientPageInfo.getList());
        req.setAttribute("patientPageInfo",patientPageInfo);
        req.getRequestDispatcher("/doctor/patient/list.jsp").forward(req,resp);
    }
}
