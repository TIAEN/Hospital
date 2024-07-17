package com.oracle.servlet.patient;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Consultation;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patient/consultationListServlet")
public class ConsultationListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务代码
        //设置一下默认页的数据
        String strPageNum=req.getParameter("pageNum");
        //初始页面默认为1
        Integer pageNum=1;
        //初始条数默认为5
        Integer pageSize=5;

        Integer pid = null;
        String sPid=req.getParameter("pid");
        if(sPid!=null && !"0".equals(sPid)){
            pid=Integer.parseInt(sPid);
        }

        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }
        ConsultationService consultationService=new ConsultationServiceImpl();
        List<Consultation> consultationList=consultationService.getConsultationsByPatientId(pid);
        req.setAttribute("consultationList",consultationList);
        req.setAttribute("pid",pid);
        req.getRequestDispatcher("/public/patient/root_consultation.jsp").forward(req,resp);

    }
}
