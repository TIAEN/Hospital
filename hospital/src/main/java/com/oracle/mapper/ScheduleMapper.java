package com.oracle.mapper;

import com.oracle.pojo.Appointment;
import com.oracle.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {

    List<Schedule> findAll();

    void updateScheduleByScheduleId(Schedule schedule);

    Schedule selectOneScheduleByScheduleId(Integer scheduleId);

    void deleteScheduleByScheduleId(Integer scheduleId);

    void addSchedule(Schedule schedule);

    Integer selectDepartmentIdByDoctorId(Integer doctorId);

    String selectDoctorNameByDoctorId(Integer doctorId);

    String selectDepartmentNameByDepartmentId(Integer departmentId);

    Schedule selectScheduleId(Integer scheduleId);

    List<Schedule> selectSomeSchedule(Schedule schedule);


    List<Appointment> selectPatientCountByDoctorId(Integer doctorId);

    List<Integer> selectScheduleIdList();
}
