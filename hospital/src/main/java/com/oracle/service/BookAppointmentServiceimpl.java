package com.oracle.service;

import com.oracle.mapper.BookAppointmentMapper;
import com.oracle.pojo.BookAppointment;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
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

    @Override
    public void insertBookAppointment(BookAppointment bookAppointment) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        BookAppointmentMapper bookAppointmentMapper = sqlSession.getMapper(BookAppointmentMapper.class);
        bookAppointmentMapper.insertBookAppointment(bookAppointment);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public boolean isExistBookAppointmentByDate(Date date) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        BookAppointmentMapper bookAppointmentMapper = sqlSession.getMapper(BookAppointmentMapper.class);
        boolean i=bookAppointmentMapper.isExistAppointmentDate(date);
        sqlSession.close();
        return i;
    }

    @Override
    public void updateBookAppointment(BookAppointment bookAppointment) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        BookAppointmentMapper bookAppointmentMapper = sqlSession.getMapper(BookAppointmentMapper.class);
        bookAppointmentMapper.updateBookAppointment(bookAppointment);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateBookAppointmentAdd(Date appointmentDate) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        BookAppointmentMapper bookAppointmentMapper = sqlSession.getMapper(BookAppointmentMapper.class);
        bookAppointmentMapper.updateBookAppointmentAdd(appointmentDate);
        sqlSession.commit();
        sqlSession.close();
    }
}
