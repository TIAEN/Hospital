package com.oracle.servlet.patient;

import com.oracle.pojo.Consultation;
import com.oracle.service.ConsultationService;
import com.oracle.service.ConsultationServiceImpl;
import com.oracle.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet("/patient/addConsultationServlet")
public class AddConsultationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AddConsultationServlet测试点");
        // 获取请求参数
        Integer consultationId = Integer.parseInt(req.getParameter("consultationId"));
        String strConsultationTime = req.getParameter("consultationTime");
        Integer isHospitalRegistered = Integer.parseInt(req.getParameter("isHospitalRegistered"));
        Integer isHospitalized = Integer.parseInt(req.getParameter("isHospitalized"));
        String medicalAdviceCase = req.getParameter("medicalAdviceCase");

        // 将字符串日期转换为Date对象
        Date consultationTime = null;
        try {
            consultationTime = DateUtils.convertToDate(strConsultationTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Integer dId=Integer.parseInt(req.getParameter("departmentId"));


        // 创建Consultation对象并设置属性值
        Consultation consultation = new Consultation();
        consultation.setPatientId(consultationId);
        consultation.setConsultationTime(consultationTime);
        consultation.setIsHospitalRegistered(isHospitalRegistered);
        consultation.setIsHospitalized(isHospitalized);
        consultation.setMedicalAdviceCase(medicalAdviceCase);
        consultation.setDepartmentId(dId);


        // 调用ConsultationService的addConsultation方法添加就诊记录
        ConsultationService consultationService =new ConsultationServiceImpl();
        consultationService.insertConsultation(consultation);


        resp.sendRedirect(req.getContextPath()+"/patient/rootAddConsultationServlet");
        //test
    }
}
