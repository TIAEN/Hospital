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

@WebServlet("/doLoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);

        MemberService memberService = new MemberService();
        if(memberService.login(member)){
            HttpSession session = req.getSession();
            session.setAttribute("memberInfo", member);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        req.setAttribute("loginError","用户名不存在或密码错误");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        return;
    }
}
