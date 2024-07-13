package com.oracle.servlet.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//转发科室增加
@WebServlet("/backend/addDepartmentViewServlet")
public class AddDepartmentViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //尝试获取请求的参数
        String plevel=req.getParameter("plevel");
        String pid=req.getParameter("pid");

        req.setAttribute("plevel",plevel);
        req.setAttribute("pid",pid);
        req.getRequestDispatcher("/admin/department/add.jsp").forward(req,resp);
    }
}
