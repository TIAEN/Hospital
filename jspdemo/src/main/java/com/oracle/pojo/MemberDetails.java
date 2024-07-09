package com.oracle.pojo;


//+----------+--------------+------+-----+---------+----------------+
//| Field    | Type         | Null | Key | Default | Extra          |
//+----------+--------------+------+-----+---------+----------------+
//| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
//| username | varchar(255) | YES  |     | NULL    |                |
//| phone    | varchar(255) | YES  |     | NULL    |                |
//| birthday | datetime     | YES  |     | NULL    |                |
//| gendar   | varchar(255) | YES  |     | NULL    |                |
//| city     | varchar(255) | YES  |     | NULL    |                |
//| hobbies  | varchar(255) | YES  |     | NULL    |                |
//| photo     | varchar(255) | YES  |     | NULL    |                |
//| notes    | varchar(255) | YES  |     |         |                |
//| members  | int(11)      | YES  |     | NULL    |                |
//+----------+--------------+------+-----+---------+----------------+
//10 rows in set (0.03 sec)


import java.io.Serializable;
import java.util.Date;

public class MemberDetails implements Serializable {
    private Integer id;
    private String username;
    private String phone;
    private Date birthday;
    private String gendar;
    private String hobbies;
    private String notes;
    private Integer members;
    private String photo;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getGendar() {
        return gendar;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberDetails{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", gendar='" + gendar + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", notes='" + notes + '\'' +
                ", members=" + members +
                ", photo='" + photo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
