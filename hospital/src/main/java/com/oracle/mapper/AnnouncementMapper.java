package com.oracle.mapper;

import com.oracle.pojo.Announcement;

import java.util.List;

public interface AnnouncementMapper {

    List<Announcement> selectAnnouncementAll();
    void insertAnnouncement(Announcement announcement);

    void deleteAnnouncementById(Integer id);

    List<Announcement> selectFiveByDate();
}