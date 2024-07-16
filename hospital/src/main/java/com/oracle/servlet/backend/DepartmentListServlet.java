package com.oracle.servlet.backend;


//小组的git仓库初始化上传人员
//公共的配置文件不要上传

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//处理科室管理-科室列表
@WebServlet("/backend/departmentListServlet")
public class DepartmentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务代码
        //设置一下默认页的数据
        String strPageNum=req.getParameter("pageNum");
        //初始页面默认为1
        Integer pageNum=1;
        //初始条数默认为5
        Integer pageSize=5;

        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }



        DepartmentService departmentService=new DepartmentServiceImpl();
        PageInfo<Department> pageInfo=departmentService.list(pageNum,pageSize);
        req.setAttribute("departmentList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/admin/department/list.jsp").forward(req,resp);
    }
}
