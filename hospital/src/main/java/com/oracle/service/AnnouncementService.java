package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> findAllAnnouncement();
    void addAnnouncement(Announcement announcement);
    PageInfo<Announcement> list(int pageNum, int pageSize);
    void deleteAnnouncement(int id);

    List<Announcement> selectFiveByDate();
}
