package com.oracle.pojo;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {

    private Integer scheduleId;
    private Integer doctorId;
    private Date date;
    private Integer departmentId;
    private Integer isAvailable;
    private Integer visitCount;
    private String remarks;

    public Schedule() {
    }

    public Schedule(Integer scheduleId, Integer doctorId, Date date, Integer departmentId, Integer isAvailable, Integer visitCount, String remarks) {
        this.scheduleId = scheduleId;
        this.doctorId = doctorId;
        this.date = date;
        this.departmentId = departmentId;
        this.isAvailable = isAvailable;
        this.visitCount = visitCount;
        this.remarks = remarks;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", departmentId=" + departmentId +
                ", isAvailable=" + isAvailable +
                ", visitCount=" + visitCount +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
