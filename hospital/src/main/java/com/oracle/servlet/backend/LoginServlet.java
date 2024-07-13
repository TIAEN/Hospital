package com.oracle.servlet.backend;

import com.oracle.pojo.Admin;
import com.oracle.pojo.Doctor;
import com.oracle.pojo.SessionIdentify;
import com.oracle.service.AdminService;
import com.oracle.service.AdminServiceImpl;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

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

        }else{
            req.setAttribute("capError","");
        }

        if(roleId.equals("0")){
            //登录身份是管理员
            Admin admin=new Admin();
            admin.setUserName(loginName);
            admin.setPassword(pwd);
            AdminService adminService=new AdminServiceImpl();
            if(!adminService.login(admin)){
                req.setAttribute("loginError","用户名不存在或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

            //这里实际上已经用AdminInfo实现了身份的判断，这里只是为了测试sessionIdentify的方式
            SessionIdentify sessionIdentify=new SessionIdentify ();
            sessionIdentify.setTag(0);
            sessionIdentify.setT(admin);

            session.setAttribute("managerInfo",sessionIdentify);
            session.setAttribute("AdminInfo",admin);
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }
        else if(roleId.equals("1")){
            //登录身份是医生
            Doctor doctor=new Doctor();
            doctor.setJobNumber(loginName);
            doctor.setPassword(pwd);
            DoctorService doctorService=new DoctorServiceImpl();
            if(!doctorService.login(doctor)){
                req.setAttribute("loginError","工号不存在或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

            ////这里实际上已经用DoctorInfo实现了身份的判断，这里只是为了测试sessionIdentify的方式
            SessionIdentify sessionIdentify=new SessionIdentify();
            sessionIdentify.setTag(1);
            sessionIdentify.setT(doctor);

            session.setAttribute("manager",sessionIdentify);
            session.setAttribute("DoctorInfo",doctor);
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }

        //判断角色身份
        //医生接口登录
        //管理员身份等分
        //管理员和医生登录后看到的界面是不一样的

    }
}
