package com.oracle.service;

import com.oracle.mapper.BookAppointmentMapper;
import com.oracle.pojo.BookAppointment;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookAppointmentServiceimpl implements BookAppointmentService {
    @Override
    public List<BookAppointment> getBookAppointmentAll() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        BookAppointmentMapper bookAppointmentMapper = sqlSession.getMapper(BookAppointmentMapper.class);
        List<BookAppointment> bookAppointmentList=bookAppointmentMapper.selectAll();
        sqlSession.close();
        return bookAppointmentList;
    }



}
