package com.oracle.pojo;

/*+-----------------------+---------------+------+-----+---------+----------------+
| Field                 | Type          | Null | Key | Default | Extra          |
+-----------------------+---------------+------+-----+---------+----------------+
| doctor_id             | int(11)       | NO   | PRI | NULL    | auto_increment |
| job_number            | varchar(255)  | YES  |     | NULL    |                |
| password              | varchar(255)  | YES  |     | NULL    |                |
| name                  | varchar(255)  | YES  |     | NULL    |                |
| avatar                | varchar(255)  | YES  |     | NULL    |                |
| phone                 | varchar(255)  | YES  |     | NULL    |                |
| email                 | varchar(255)  | YES  |     | NULL    |                |
| introduction          | text          | YES  |     | NULL    |                |
| registration_fee      | decimal(10,2) | YES  |     | NULL    |                |
| entry_date            | date          | YES  |     | NULL    |                |
| department_id         | int(11)       | YES  | MUL | NULL    |                |
| professional_title_id | int(11)       | YES  | MUL | NULL    |                |
+-----------------------+---------------+------+-----+---------+----------------+
*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Doctor implements Serializable {
    private Integer doctorId;

    private String jobNumber;

    private String password;

    private String name;

    private String avatar;

    private String phone;

    private String email;

    private String introduction;

    private BigDecimal registrationFee;

    private Date entryDate;

    private Integer departmentId;

    private Integer professionalTitleId;

    private String departmentName; // 新增 departmentName 属性

    private String professionalTitleName;   // 新增 professionalTitleName 属性

    public Doctor() {
    }

    public Doctor(Integer doctorId, String jobNumber, String password, String name, String avatar, String phone, String email, String introduction, BigDecimal registrationFee, Date entryDate, Integer departmentId, Integer professionalTitleId, String departmentName, String professionalTitleName) {
        this.doctorId = doctorId;
        this.jobNumber = jobNumber;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.introduction = introduction;
        this.registrationFee = registrationFee;
        this.entryDate = entryDate;
        this.departmentId = departmentId;
        this.professionalTitleId = professionalTitleId;
        this.departmentName = departmentName;
        this.professionalTitleName = professionalTitleName;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public BigDecimal getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(BigDecimal registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getProfessionalTitleId() {
        return professionalTitleId;
    }

    public void setProfessionalTitleId(Integer professionalTitleId) {
        this.professionalTitleId = professionalTitleId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getProfessionalTitleName() {
        return professionalTitleName;
    }

    public void setProfessionalTitleName(String professionalTitleName) {
        this.professionalTitleName = professionalTitleName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", jobNumber='" + jobNumber + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                ", registrationFee=" + registrationFee +
                ", entryDate=" + entryDate +
                ", departmentId=" + departmentId +
                ", professionalTitleId=" + professionalTitleId +
                ", departmentName='" + departmentName + '\'' +
                ", professionalTitleName='" + professionalTitleName + '\'' +
                '}';
    }
}
