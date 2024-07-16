package com.oracle.pojo;

import java.io.Serializable;
import java.util.Date;

//+------------------+----------------------------------------+------+-----+---------+----------------+
//| Field            | Type                                   | Null | Key | Default | Extra          |
//+------------------+----------------------------------------+------+-----+---------+----------------+
//| appointment_id   | int(11)                                | NO   | PRI | NULL    | auto_increment |
//| patient_id       | int(11)                                | YES  | MUL | NULL    |                |
//| doctor_id        | int(11)                                | YES  | MUL | NULL    |                |
//| appointment_date | datetime                               | YES  |     | NULL    |                |
//| status           | enum('booked','completed','cancelled') | YES  |     | NULL    |                |
//+------------------+----------------------------------------+------+-----+---------+----------------+

public class Appointment implements Serializable {



    private String doctorName;
    private String patientName;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    private Integer appointmentId;
    private Integer patientId;
    private Integer doctorId;
    private Date appointmentDate;
    private enum status{
        booked,completed,cancelled;
    }

    public Appointment() {
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }


    private status currentStatus;

    public void setStatus(status status) {
        this.currentStatus = status;
    }

    public status getStatus() {
        return currentStatus;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDate=" + appointmentDate +
                ", currentStatus=" + currentStatus +
                '}';
    }
}
