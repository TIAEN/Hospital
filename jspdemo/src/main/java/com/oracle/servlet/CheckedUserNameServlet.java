package com.oracle.servlet;

import com.alibaba.fastjson.JSONObject;
import com.oracle.pojo.R;
import com.oracle.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkedUserNameServlet")
public class CheckedUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String requestUserName=req.getParameter("requestUserName");
        MemberService memberService=new MemberService();
        R r=new R();
        if(memberService.existUserName(requestUserName)){

            r.setCode(201);
            r.setMsg("username existed");


        }else{
            r.setCode(200);
            r.setMsg("SUCCESS");

        }
        String json= JSONObject.toJSONString(r);
        resp.getWriter().println(json);
        resp.getWriter().flush();
        resp.getWriter().close();

    }
}
