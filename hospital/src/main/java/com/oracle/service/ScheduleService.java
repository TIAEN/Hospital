package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findScheduleAll();

    void updateScheduleByScheduleId(Schedule schedule);

    Schedule selectOneScheduleByScheduleId(Integer scheduleId);

    void deleteScheduleByScheduleId(Integer scheduleId);

    PageInfo<Schedule> list(Integer pageNum, Integer pageSize);

    Integer selectDepartmentIdByDoctorId(Integer doctorId);

    String selectDoctorNameByDoctorId(Integer doctorId);

    String selectDepartmentNameByDepartmentId(Integer DepartmentId);

    void addSchedule(Schedule schedule);

    boolean selectScheduleId(Integer scheduleId);

    List<Schedule> selectSomeSchedule(Schedule schedule);

    Integer selectPatientCountByDoctorId(Integer doctorId);

    Integer selectMaxScheduleId();
}
