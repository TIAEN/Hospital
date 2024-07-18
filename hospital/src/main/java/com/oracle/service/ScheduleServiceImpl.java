package com.oracle.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.ScheduleMapper;
import com.oracle.pojo.Appointment;
import com.oracle.pojo.Schedule;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService{

    @Override
    public List<Schedule> findScheduleAll() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        List<Schedule> scheduleList=scheduleMapper.findAll();
        sqlSession.close();
        return scheduleList;
    }

    @Override
    public void updateScheduleByScheduleId(Schedule schedule) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        scheduleMapper.updateScheduleByScheduleId(schedule);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public Schedule selectOneScheduleByScheduleId(Integer scheduleId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        Schedule schedule = scheduleMapper.selectOneScheduleByScheduleId(scheduleId);
        sqlSession.close();
        return schedule;
    }

    @Override
    public void deleteScheduleByScheduleId(Integer scheduleId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        scheduleMapper.deleteScheduleByScheduleId(scheduleId);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public PageInfo<Schedule> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        List<Schedule> scheduleList = scheduleMapper.findAll();
        PageInfo<Schedule> schedulePageInfo=new PageInfo<Schedule>(scheduleList);
        sqlSession.close();
        return schedulePageInfo;

    }

    @Override
    public Integer selectDepartmentIdByDoctorId(Integer doctorId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        Integer departmentId = scheduleMapper.selectDepartmentIdByDoctorId(doctorId);
        sqlSession.close();
        return departmentId;
    }

    @Override
    public String selectDoctorNameByDoctorId(Integer doctorId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        String doctorName = scheduleMapper.selectDoctorNameByDoctorId(doctorId);
        sqlSession.close();
        return doctorName;
    }

    @Override
    public String selectDepartmentNameByDepartmentId(Integer departmentId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        String departmentName = scheduleMapper.selectDepartmentNameByDepartmentId(departmentId);
        sqlSession.close();
        return departmentName;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        scheduleMapper.addSchedule(schedule);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public boolean selectScheduleId(Integer scheduleId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        Schedule i = scheduleMapper.selectScheduleId(scheduleId);
        sqlSession.close();
        if (i==null){
            return false;
        }
        return true;
    }

    @Override
    public List<Schedule> selectSomeSchedule(Schedule schedule) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        List<Schedule> scheduleList = scheduleMapper.selectSomeSchedule(schedule);
        sqlSession.close();
        return scheduleList;
    }

    @Override
    public Integer selectPatientCountByDoctorId(Integer doctorId) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
        List<Appointment> appointmentList = scheduleMapper.selectPatientCountByDoctorId(doctorId);
        Integer patientCount = appointmentList.size();
        sqlSession.close();
        return patientCount;
    }

}
