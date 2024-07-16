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
import java.util.List;

@WebServlet("/backend/patientSearchServlet")
public class PatientSearchServlet extends HttpServlet {



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pageNum=1;
        Integer pageSize=4;

        Patient patient=new Patient();
        patient.setAvatar(null);
        patient.setPatientId(null);
        patient.setIdCardNumber(null);
        patient.setName(null);
        patient.setPhone(null);
        patient.setPassword(null);
        patient.setBalance(null);
        patient.setEmail(null);

        String searchStrPatientId=req.getParameter("searchPatientId");
        String searchName=req.getParameter("searchName");
        String searchIdCardNumber=req.getParameter("searchIdCardNumber");
        String searchPhone=req.getParameter("searchPhone");
        String strPageNum=req.getParameter("searchPageNum");

        if(searchName!=null && !"".equals(searchName)){
            patient.setName(searchName);
        }

        if(searchStrPatientId!=null && !"".equals(searchStrPatientId)){
            Integer searchPatientId=Integer.parseInt(searchStrPatientId);
            patient.setPatientId(searchPatientId);
        }

        if(searchIdCardNumber!=null && !"".equals(searchIdCardNumber)){
            patient.setIdCardNumber(searchIdCardNumber);
        }

        if(searchPhone!=null && !"".equals(searchPhone)){
            patient.setPhone(searchPhone);
        }

        if(strPageNum!=null && !"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }

        System.out.println("这是一个不精致的测试点");
        System.out.println(patient);

        PatientService patientService=new PatientServiceImpl();
        PageInfo<Patient> patientPageInfo=patientService.findPageList(patient,pageNum,pageSize);

        System.out.println("这是一个精致的测试点");
        System.out.println(patient);
        System.out.println(patientPageInfo);
        System.out.println(patientPageInfo.getList());

        req.setAttribute("searchContent",patient);
        req.setAttribute("searchPatientInfo",patientPageInfo);
        req.setAttribute("searchPatientList",patientPageInfo.getList());
        req.getRequestDispatcher("/admin/patient/search.jsp").forward(req,resp);
    }
}
