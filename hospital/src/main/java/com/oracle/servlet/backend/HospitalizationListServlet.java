package com.oracle.servlet.backend;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Hospitalization;
import com.oracle.service.HospitalizationService;
import com.oracle.service.HospitalizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/hospitalizationListServlet")
public class HospitalizationListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strPageNum=req.getParameter("pageNum");
        Integer pageNum=1;
        Integer pageSize=5;
        if(strPageNum!=null && !"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }
        HospitalizationService hospitalizationService=new HospitalizationServiceImpl();
        PageInfo<Hospitalization> pageInfo = hospitalizationService.list(pageNum,pageSize);


        req.setAttribute("hospitalizationList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/doctor/patient/hospitalization_list.jsp").forward(req,resp);
    }
}
