package com.oracle.pojo;

import java.io.Serializable;
import java.util.Date;

//+-----------------+--------------+------+-----+---------+----------------+
//| Field           | Type         | Null | Key | Default | Extra          |
//+-----------------+--------------+------+-----+---------+----------------+
//| announcement_id | int(11)      | NO   | PRI | NULL    | auto_increment |
//| title           | varchar(255) | YES  |     | NULL    |                |
//| content         | text         | YES  |     | NULL    |                |
//| creation_time   | datetime     | YES  |     | NULL    |                |
//| creator         | varchar(255) | YES  |     | NULL    |                |
//+-----------------+--------------+------+-----+---------+----------------+
public class Announcement implements Serializable {

    private Integer announcementId;
    private String announcementTitle;
    private String announcementContent;
    private Date announcementCreateTime;
    private String announcementCreator;

    public Announcement() {
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public Date getAnnouncementCreateTime() {
        return announcementCreateTime;
    }

    public void setAnnouncementCreateTime(Date announcementCreateTime) {
        this.announcementCreateTime = announcementCreateTime;
    }

    public String getAnnouncementCreator() {
        return announcementCreator;
    }

    public void setAnnouncementCreator(String announcementCreator) {
        this.announcementCreator = announcementCreator;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", announcementTitle='" + announcementTitle + '\'' +
                ", announcementContent='" + announcementContent + '\'' +
                ", announcementCreateTime=" + announcementCreateTime +
                ", announcementCreator='" + announcementCreator + '\'' +
                '}';
    }
}
