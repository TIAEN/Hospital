package com.oracle.pojo;

import java.util.Date;

public class Consultation {
    private Integer consultationId;
    private Integer patientId;
    private Integer doctorId;
    private Date consultationTime;
    private Integer isHospitalRegistered;
    private Integer isHospitalized;
    private String medicalAdviceCase;

    private Integer departmentId;

    public Consultation() {
    }

    public Consultation(Integer consultationId, Integer patientId, Integer doctorId, Date consultationTime, Integer isHospitalRegistered, Integer isHospitalized, String medicalAdviceCase, Integer departmentId) {
        this.consultationId = consultationId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.consultationTime = consultationTime;
        this.isHospitalRegistered = isHospitalRegistered;
        this.isHospitalized = isHospitalized;
        this.medicalAdviceCase = medicalAdviceCase;
        this.departmentId = departmentId;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Date consultationTime) {
        this.consultationTime = consultationTime;
    }

    public Integer getIsHospitalRegistered() {
        return isHospitalRegistered;
    }

    public void setIsHospitalRegistered(Integer isHospitalRegistered) {
        this.isHospitalRegistered = isHospitalRegistered;
    }

    public Integer getIsHospitalized() {
        return isHospitalized;
    }

    public void setIsHospitalized(Integer isHospitalized) {
        this.isHospitalized = isHospitalized;
    }

    public String getMedicalAdviceCase() {
        return medicalAdviceCase;
    }

    public void setMedicalAdviceCase(String medicalAdviceCase) {
        this.medicalAdviceCase = medicalAdviceCase;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationId=" + consultationId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", consultationTime=" + consultationTime +
                ", isHospitalRegistered=" + isHospitalRegistered +
                ", isHospitalized=" + isHospitalized +
                ", medicalAdviceCase='" + medicalAdviceCase + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
