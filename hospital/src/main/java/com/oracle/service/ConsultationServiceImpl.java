package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.AnnouncementMapper;
import com.oracle.mapper.ConsultationMapper;
import com.oracle.mapper.DoctorMapper;
import com.oracle.pojo.Announcement;
import com.oracle.pojo.Consultation;
import com.oracle.pojo.Doctor;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ConsultationServiceImpl implements ConsultationService{


        @Override
        public List<Consultation> getConsultationsByPatientId(Integer patientId) {
            SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
            ConsultationMapper consultationMapper = sqlSession.getMapper(ConsultationMapper.class);
            List<Consultation> consultationList = consultationMapper.getConsultationsByPatientId(patientId);
            sqlSession.commit(true);
            sqlSession.close();
            return consultationList;
        }

        @Override
        public void insertConsultation(Consultation consultation) {
            SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
            ConsultationMapper consultationMapper = sqlSession.getMapper(ConsultationMapper.class);
            consultationMapper.insertConsultation(consultation);
            sqlSession.commit(true);
            sqlSession.close();
        }
        @Override
        public void deleteConsultation(Integer consultationId) {
            SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
            ConsultationMapper consultationMapper = sqlSession.getMapper(ConsultationMapper.class);
            consultationMapper.deleteConsultation(consultationId);
            sqlSession.commit(true);
            sqlSession.close();
        }

        @Override
        public Doctor findDoctorByJobNumber(String jobNumber) {
            SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
            DoctorMapper doctorMapper = sqlSession.getMapper(DoctorMapper.class);
            Doctor doctor = doctorMapper.selectDoctorByJobNumber(jobNumber);
            sqlSession.commit(true);
            sqlSession.close();
            return doctor;
        }

        @Override
        public PageInfo<Doctor> list(Integer pageNum, Integer pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
            DoctorMapper doctorMapper = sqlSession.getMapper(DoctorMapper.class);
            List<Doctor> doctorList=doctorMapper.selectDoctorAll();
            sqlSession.close();
            return new PageInfo<Doctor>(doctorList);
        }

        @Override
        public List<Consultation> findAllConsultation() {
            SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
            ConsultationMapper consultationMapper= sqlSession.getMapper(ConsultationMapper.class);
            List<Consultation> consultationList=consultationMapper.selectConsultationAll();
            sqlSession.close();
            return consultationList;
        }

        @Override
        public Integer getCurrentMaxJobNumber() {
            SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
            ConsultationMapper consultationMapper=sqlSession.getMapper(ConsultationMapper.class);
            String strMaxJobNumber=consultationMapper.selectMaxJobNumber();
            Integer iMaxJobNumber=Integer.parseInt(strMaxJobNumber);
            sqlSession.close();
            return iMaxJobNumber;
        }


}
