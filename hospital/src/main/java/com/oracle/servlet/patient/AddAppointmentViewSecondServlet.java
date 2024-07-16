package com.oracle.servlet.patient;

import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patient/addAppointmentViewSecondServlet")
public class AddAppointmentViewSecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sdepartmentFirstId = req.getParameter("departmentFirstId");
        String patientId = req.getParameter("patientId");

        Integer departmentFirstId=null;
        if (sdepartmentFirstId == null || sdepartmentFirstId.equals("")) {

        }
        else{
            departmentFirstId=Integer.parseInt(sdepartmentFirstId);
        }
        DepartmentService departmentService=new DepartmentServiceimpl();

        List<Department> departmentList=departmentService.findDepartmentByPid(departmentFirstId);

        req.setAttribute("departmentFirstId", departmentFirstId);
        req.setAttribute("departmentList", departmentList);
        req.setAttribute("patientId", patientId);
        req.getRequestDispatcher("addAppointmentViewSecond.jsp").forward(req, resp);

    }
}
