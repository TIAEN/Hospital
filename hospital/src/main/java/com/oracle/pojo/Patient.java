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

public class Patient implements Serializable {
    private Integer patientId;          //患者编号
    private String idCardNumber;        //身份证号
    private String password;            //密码
    private String name;                //姓名
    private String avatar;              //头像
    private String phone;               //电话
    private String email;               //邮箱
    private BigDecimal balance;         //余额
    private Integer arranged;

    public Patient() {
    }

    public Patient(Integer patientId, String idCardNumber, String password, String name, String avatar, String phone, String email, BigDecimal balance, Integer arranged) {
        this.patientId = patientId;
        this.idCardNumber = idCardNumber;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.balance = balance;
        this.arranged = arranged;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getArranged() {
        return arranged;
    }

    public void setArranged(Integer arranged) {
        this.arranged = arranged;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", arranged=" + arranged +
                '}';
    }
}
