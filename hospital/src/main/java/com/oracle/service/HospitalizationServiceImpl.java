package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.oracle.mapper.HospitalizationMapper;
import com.oracle.pojo.Hospitalization;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HospitalizationServiceImpl implements HospitalizationService{

    @Override
    public void insertHospitalization(Hospitalization hospitalization) {
        SqlSession sqlsession = DBUtils.createDbUtils().getSQLSession();
        HospitalizationMapper hospitalizationMapper = sqlsession.getMapper(HospitalizationMapper.class);
        hospitalizationMapper.insertHospitalization(hospitalization);
        sqlsession.commit(true);
        sqlsession.close();
    }

    @Override
    public PageInfo<Hospitalization>  list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        HospitalizationMapper hospitalizationMapper=sqlSession.getMapper(HospitalizationMapper.class);
        List<Hospitalization> hospitalizationList=hospitalizationMapper.selectHospitalizationAll();
        sqlSession.close();
        return new PageInfo<Hospitalization>(hospitalizationList);
    }

    @Override
    public List<Hospitalization> selectHospitalizationByPhone(String phone) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        HospitalizationMapper hospitalizationMapper=sqlSession.getMapper(HospitalizationMapper.class);
        List<Hospitalization> hospitalization=hospitalizationMapper.selectHospitalizationByPhone(phone);
        sqlSession.close();
        return hospitalization;
    }

    @Override
    public void pay(Hospitalization hospitalization) {
        SqlSession sqlsession = DBUtils.createDbUtils().getSQLSession();
        HospitalizationMapper hospitalizationMapper = sqlsession.getMapper(HospitalizationMapper.class);
        System.out.println("pay测试点"+hospitalization);
        hospitalizationMapper.pay(hospitalization);
        sqlsession.commit(true);
        sqlsession.close();
    }

    @Override
    public void enter(Hospitalization hospitalization) {
        SqlSession sqlsession = DBUtils.createDbUtils().getSQLSession();
        HospitalizationMapper hospitalizationMapper = sqlsession.getMapper(HospitalizationMapper.class);
        hospitalizationMapper.enter(hospitalization);
        sqlsession.commit(true);
        sqlsession.close();
    }

    @Override
    public void discharge(Hospitalization hospitalization) {
        SqlSession sqlsession = DBUtils.createDbUtils().getSQLSession();
        HospitalizationMapper hospitalizationMapper = sqlsession.getMapper(HospitalizationMapper.class);
        hospitalizationMapper.discharge(hospitalization);
        sqlsession.commit(true);
        sqlsession.close();
    }
}
