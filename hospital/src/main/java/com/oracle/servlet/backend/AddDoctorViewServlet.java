package com.oracle.servlet.backend;

import com.oracle.pojo.ProfessionalTitle;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;
import com.oracle.service.ProfessionalTitleService;
import com.oracle.service.ProfessionalTitleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/backend/addDoctorViewServlet")
public class AddDoctorViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取医生的添加信息 科室 职称
        //获取到医生的科室的信息 和 职称的信息内容 将两部分内容信息保存至request作用域并添加到页面中

        //出于优化的目的考虑，将2部分字典信息进行缓存，便于频繁使用时不需要查询数据库 从业务角度出发 凡是读多存少的内容都要考虑缓存
        //从本地缓存jvm application 初始化只执行一次
        //获取当前的一生jobnumber最大是多少
        DoctorService doctorService=new DoctorServiceImpl();
        Integer currentMaxJobNumber=doctorService.getCurrentMaxJobNumber();
        currentMaxJobNumber+=1;
        ProfessionalTitleService professionalTitleService=new ProfessionalTitleServiceImpl();
        List<ProfessionalTitle> titleAll=professionalTitleService.AllProfessionalTitleList();
        req.setAttribute("professionalTitleList",titleAll);
        req.setAttribute("jobNumber",currentMaxJobNumber);
        req.getRequestDispatcher("/admin/doctor/add.jsp").forward(req,resp);
    }
}
