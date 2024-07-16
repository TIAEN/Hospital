package com.oracle.service;

import com.oracle.mapper.ProfessionalTitleMapper;
import com.oracle.pojo.ProfessionalTitle;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProfessionalTitleServiceImpl implements ProfessionalTitleService{
    @Override
    public List<ProfessionalTitle> AllProfessionalTitleList() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        ProfessionalTitleMapper professionalTitleMapper=sqlSession.getMapper(ProfessionalTitleMapper.class);
        List<ProfessionalTitle> professionalTitleList=professionalTitleMapper.selectProfessionalTitleAll();
        sqlSession.close();
        return professionalTitleList;
    }
}
