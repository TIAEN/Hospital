package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.AnnouncementMapper;
import com.oracle.pojo.Announcement;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class AnnouncementServiceimpl implements AnnouncementService{
    @Override
    public List<Announcement> findAllAnnouncement() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AnnouncementMapper announcementMapper= sqlSession.getMapper(AnnouncementMapper.class);
        List<Announcement> announcementList=announcementMapper.selectAnnouncementAll();
        sqlSession.close();
        return announcementList;
    }

    @Override
    public void addAnnouncement(Announcement announcement) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AnnouncementMapper announcementMapper= sqlSession.getMapper(AnnouncementMapper.class);
        announcementMapper.insertAnnouncement(announcement);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public PageInfo<Announcement> list(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AnnouncementMapper announcementMapper=sqlSession.getMapper(AnnouncementMapper.class);
        List<Announcement> announcementList=announcementMapper.selectAnnouncementAll();
        sqlSession.close();
        return new PageInfo<Announcement>(announcementList);


    }

    @Override
    public void deleteAnnouncement(int id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AnnouncementMapper announcementMapper= sqlSession.getMapper(AnnouncementMapper.class);
        announcementMapper.deleteAnnouncementById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Announcement> selectFiveByDate() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AnnouncementMapper announcementMapper= sqlSession.getMapper(AnnouncementMapper.class);
        List<Announcement>announcementList= announcementMapper.selectFiveByDate();
        sqlSession.close();
        return announcementList;
    }
}
