package com.oracle.servlet.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backend/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("username");
        String pwd = req.getParameter("password");
        String roleId= req.getParameter("roleId");
        String requestCode= req.getParameter("code");

        //Integer role =Integer.parseInt(roleId);
        HttpSession session = req.getSession();
        String sessionCode=(String)session.getAttribute("valcode");
        if(requestCode==null||"".equals(requestCode)||!requestCode.equals(sessionCode)){

            req.setAttribute("capError","验证码有误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;

        }
        //医生
        if(roleId.equals("1")){

        }else if(roleId.equals("0")){//管理员

        }








    }
}
