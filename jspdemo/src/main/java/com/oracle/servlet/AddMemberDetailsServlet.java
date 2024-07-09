package com.oracle.servlet;

import com.oracle.pojo.Member;
import com.oracle.pojo.MemberDetails;
import com.oracle.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/doAddMemberDetailsServlet")
@MultipartConfig
public class AddMemberDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Part part=req.getPart("photo");
        String fileName=part.getSubmittedFileName();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        String newFileName= UUID.randomUUID().toString() +suffix;
        part.write("D://文档和学习图片//"+fileName);


        String username=req.getParameter("username");
        String phone=req.getParameter("phone");
        String strBirthday=req.getParameter("birthday");
        Date birthday=null;
        try {
            DateUtils.convertToDate(strBirthday);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String gender=req.getParameter("gender");
        String city=req.getParameter("city");
        String[] strHobbies=req.getParameterValues("hobbies");
        String hobbies=null;
        if(strHobbies!=null && strHobbies.length>0){
            hobbies="";
            for(int i=0;i<strHobbies.length;i++){
                hobbies+=strHobbies[i]+"|";
            }
        }

        String notes=req.getParameter("notes");


        HttpSession session=req.getSession();
        Member member=(Member)session.getAttribute("memberInfo");
        MemberDetails memberDetails=new MemberDetails();

        memberDetails.setMembers(member.getId());
        memberDetails.setUsername(username);
        memberDetails.setBirthday(birthday);
        memberDetails.setCity(city);
        memberDetails.setGendar(gender);
        memberDetails.setHobbies(hobbies);
        memberDetails.setNotes(notes);
        memberDetails.setPhoto(newFileName);
        memberDetails.setPhone(phone);
        System.out.println(memberDetails);
    }

}
