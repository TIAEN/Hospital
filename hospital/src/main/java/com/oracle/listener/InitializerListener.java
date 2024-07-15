package com.oracle.listener;

import com.oracle.pojo.Consultation;
import com.oracle.pojo.Department;
import com.oracle.pojo.ProfessionalTitle;
import com.oracle.service.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class InitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext=servletContextEvent.getServletContext();      //获取对象实例

        DepartmentService departmentService=new DepartmentServiceimpl();            //调用科室和职称的业务层获取数据
        List<Department> rootDepartmentList=departmentService.findRootDepartmentList();
        servletContext.setAttribute("rootDepartmentList",rootDepartmentList);
        ProfessionalTitleService professionalTitleService=new ProfessionalTitleServiceImpl();
        List<ProfessionalTitle> professionalTitleList=professionalTitleService.AllProfessionalTitleList();
        servletContext.setAttribute("professionalTitleList",professionalTitleList);
        ConsultationService consultationService =new ConsultationServiceImpl();
        List<Consultation> rootConsultationList = consultationService.findAllConsultation();
        servletContext.setAttribute("rootConsultationList",rootConsultationList);

        servletContext.setAttribute("root",servletContext.getContextPath());
        servletContext.setAttribute("js",servletContext.getContextPath()+"/js");
        servletContext.setAttribute("css",servletContext.getContextPath()+"/css");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
