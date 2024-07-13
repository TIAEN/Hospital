package com.oracle.pojo;


/*
*
* +----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| admin_id | int(11)      | NO   | PRI | NULL    |       |
| username | varchar(255) | YES  |     | NULL    |       |
| password | varchar(255) | YES  |     | NULL    |       |
| name     | varchar(255) | YES  |     | NULL    |       |
| avatar   | varchar(255) | YES  |     | NULL    |       |
| phone    | varchar(255) | YES  |     | NULL    |       |
| email    | varchar(255) | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
* */
public class Admin {
    private Integer adminId;

    private String userName;
    private String password;
    private String name;        //实名
    private String avatar;
    private String phone;
    private String email;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Admin() {
    }

    public Admin(Integer adminId, String userName, String password, String name, String avatar, String phone, String email) {
        this.adminId = adminId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
