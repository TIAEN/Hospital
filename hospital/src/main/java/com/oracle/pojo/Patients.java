package com.oracle.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

//+----------------+---------------+------+-----+---------+----------------+
//| Field          | Type          | Null | Key | Default | Extra          |
//+----------------+---------------+------+-----+---------+----------------+
//| patient_id     | int(11)       | NO   | PRI | NULL    | auto_increment |
//| id_card_number | varchar(255)  | YES  |     | NULL    |                |
//| password       | varchar(255)  | YES  |     | NULL    |                |
//| name           | varchar(255)  | YES  |     | NULL    |                |
//| avatar         | varchar(255)  | YES  |     | NULL    |                |
//| phone          | varchar(255)  | YES  |     | NULL    |                |
//| email          | varchar(255)  | YES  |     | NULL    |                |
//| balance        | decimal(10,2) | YES  |     | NULL    |                |
//+----------------+---------------+------+-----+---------+----------------+

public class Patients implements Serializable {
    private Integer patientId;
    private String patientName;
    private String patientIdCardNumber;
    private String patientPhone;
    private String patientEmail;
    private String patientPassword;
    private BigDecimal patientBalance;
    private String patientAvatar;

    public Patients() {
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdCardNumber() {
        return patientIdCardNumber;
    }

    public void setPatientIdCardNumber(String patientIdCardNumber) {
        this.patientIdCardNumber = patientIdCardNumber;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public BigDecimal getPatientBalance() {
        return patientBalance;
    }

    public void setPatientBalance(BigDecimal patientBalance) {
        this.patientBalance = patientBalance;
    }

    public String getPatientAvatar() {
        return patientAvatar;
    }

    public void setPatientAvatar(String patientAvatar) {
        this.patientAvatar = patientAvatar;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientIdCardNumber='" + patientIdCardNumber + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientPassword='" + patientPassword + '\'' +
                ", patientBalance=" + patientBalance +
                ", patientAvatar='" + patientAvatar + '\'' +
                '}';
    }
}
