package com.oracle.servlet.backend;


import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//接受增加科室的表单
@WebServlet("/backend/addDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spid=req.getParameter("pid");
        String slevel=req.getParameter("plevel");
        String deptName=req.getParameter("departmentName");
        String departmentDescription=req.getParameter("departmentDescription");

        Integer pid=null;

        String deptDesc=req.getParameter("departmentDesc");

        if(spid!=null && !"".equals(spid)){
            pid=Integer.parseInt(spid);
        }
        Integer plevel=null;

        if(slevel!=null&& !"".equals(slevel)){
            plevel=Integer.parseInt(slevel);
            plevel += 1;
            //System.out.println("不为空");
        }else{
            plevel=1;
            //System.out.println("为空");
        }
        Department department=new Department();
        department.setDepartmentName(deptName);
        department.setDepartmentPid(pid);
        department.setDepartmentDescription(deptDesc);
        if(pid==null){
            department.setDepartmentLevel(1);
        }
        else{
            department.setDepartmentLevel(pid);
        }
        DepartmentService departmentService=new DepartmentServiceImpl();
        departmentService.addDepartment(department);

        //这里的代码使用一次后应该立即删除，仅用于第一次加密
        /*
        AdminService adminService=new AdminServiceImpl();
        adminService.encryption(2);
        adminService.encryption(3);
        adminService.encryption(1);


        DoctorService doctorService=new DoctorServiceImpl();
        doctorService.encryption(1);
        doctorService.encryption(2);
        doctorService.encryption(3);
        doctorService.encryption(4);
        doctorService.encryption(5);
        doctorService.encryption(6);
        doctorService.encryption(7);
        doctorService.encryption(8);
        doctorService.encryption(9);
        doctorService.encryption(10);

         */

        //当添加完成后，重定向到root 部门的数据请求， 不能直接到jsp，因为数据是通过该请求存放到request作用于进行转发的
        resp.sendRedirect(req.getContextPath()+"/backend/rootDepartmentServlet");
    }
}
