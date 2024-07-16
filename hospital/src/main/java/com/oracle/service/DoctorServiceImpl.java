package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.DoctorMapper;
import com.oracle.pojo.Doctor;
import com.oracle.utils.DBUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DoctorServiceImpl implements DoctorService{

    @Override
    public boolean login(Doctor doctor) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DoctorMapper doctorMapper=sqlSession.getMapper(DoctorMapper.class);
        Integer countOfDoctor=doctorMapper.selectCountByJobNumber(doctor.getJobNumber());
        if(countOfDoctor==0){
            //用户不存在
            sqlSession.close();
            return false;
        }
        Doctor doctorpo=doctorMapper.selectDoctorByJobNumber(doctor.getJobNumber());
        String passwordpo=doctorpo.getPassword();
        String password=DigestUtils.md5Hex(doctor.getPassword());
        if(!password.equals(passwordpo)){
            //密码错误
            sqlSession.close();
            return false;
        }
        doctor.setDoctorId(doctorpo.getDoctorId());
        doctor.setEmail(doctorpo.getEmail());
        doctor.setAvatar(doctorpo.getAvatar());
        doctor.setName(doctorpo.getName());
        doctor.setPhone(doctorpo.getPhone());
        doctor.setIntroduction(doctorpo.getIntroduction());
        doctor.setDepartmentId(doctorpo.getDepartmentId());
        doctor.setEntryDate(doctorpo.getEntryDate());
        doctor.setProfessionalTitleId(doctorpo.getProfessionalTitleId());
        doctor.setRegistrationFee(doctorpo.getRegistrationFee());
        sqlSession.close();
        return true;
    }

    @Override
    public void encryption(Integer id) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DoctorMapper doctorMapper=sqlSession.getMapper(DoctorMapper.class);
        Doctor doctor=doctorMapper.selectDoctorById(id);
        String password=DigestUtils.md5Hex(doctor.getPassword());
        doctorMapper.updateDoctorPassword(password,id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Integer getCurrentMaxJobNumber() {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DoctorMapper doctorMapper=sqlSession.getMapper(DoctorMapper.class);
        String strMaxJobNumber=doctorMapper.selectMaxJobNumber();
        Integer iMaxJobNumber=Integer.parseInt(strMaxJobNumber);
        sqlSession.close();
        return iMaxJobNumber;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DoctorMapper doctorMapper=sqlSession.getMapper(DoctorMapper.class);
        doctorMapper.insertIntoDoctor(doctor);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageInfo<Doctor> findDoctorListByDepartmentId(Integer pageNum, Integer pageSize, Integer pId) {
        PageHelper.startPage(pageNum, pageSize);
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DoctorMapper doctorMapper=sqlSession.getMapper(DoctorMapper.class);
        List<Doctor> doctorList=doctorMapper.selectDoctorByDepartmentId(pId);
        sqlSession.close();
        return new PageInfo<Doctor>(doctorList);
    }

    @Override
    public Doctor findDoctorById(Integer id) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DoctorMapper doctorMapper=sqlSession.getMapper(DoctorMapper.class);
        Doctor doctor=doctorMapper.selectDoctorById(id);
        sqlSession.close();
        return doctor;
    }
}
