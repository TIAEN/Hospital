package com.oracle.servlet;

import com.oracle.pojo.Member;
import com.oracle.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doRegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        MemberService memberService = new MemberService();
        Member member=new Member();
        member.setUsername(username);
        member.setPassword(password);
        Integer i=memberService.registry(member);
        if(i==0)
        {
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }

        req.setAttribute("regError", "注册的登录名已存在");
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
        return;

    }
}
