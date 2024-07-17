package com.oracle.servlet;

import com.oracle.pojo.Hospitalization;
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

@WebServlet("/updatePayServlet")
public class UpdatePayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String phone=req.getParameter("phone");
        Float cost=Float.parseFloat(req.getParameter("cost"));
        Float pay=Float.parseFloat(req.getParameter("pay"));
        Integer is_insured=Integer.parseInt(req.getParameter("is_insured"));
        Hospitalization hospitalization=new Hospitalization();
        HospitalizationService hospitalizationService=new HospitalizationServiceImpl();
        hospitalization.setPatientPhone(phone);
        hospitalization.setCost(cost-pay);
        hospitalization.setIsInsured(is_insured);
        System.out.println("----------");
        System.out.println(cost-pay);
        System.out.println(hospitalization.getCost());
        System.out.println(phone);
        System.out.println(pay);
        System.out.println("----------");
        if (cost-pay<=0){
            hospitalization.setPaymentStatus("paid");
        }
        else if (pay<=0){
            hospitalization.setPaymentStatus("unpaid");
        }
        else {
            hospitalization.setPaymentStatus("partially_paid");
        }
        PatientService patientService=new PatientServiceImpl();

        patientService.pay(phone,pay);
        hospitalizationService.pay(hospitalization);

        List<Hospitalization> hospitalizations = new ArrayList<>();
        hospitalizations=hospitalizationService.selectHospitalizationByPhone(phone);
        req.setAttribute("hospitalizations",hospitalizations);
        req.getRequestDispatcher("/patient_pay_view.jsp").forward(req,resp);
    }
}
