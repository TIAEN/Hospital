package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.PatientMapper;
import com.oracle.pojo.Patient;
import com.oracle.utils.DBUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Override
    public PageInfo<Patient> pageList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        List<Patient> patientList=patientMapper.selectPatientAll();
        sqlSession.close();
        return new PageInfo<Patient>(patientList);
    }

    @Override
    public Patient selectPatientByPhone(String phone) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        Patient patient=patientMapper.selectPatientByPhone(phone);
        sqlSession.close();
        return patient;
    }

    @Override
    public void setArranged1(Patient patient) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        patientMapper.setArranged1(patient);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public void setArranged0(Patient patient) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        patientMapper.setArranged0(patient);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public void pay(String phone,Float pay) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        patientMapper.pay(phone,pay);
        sqlSession.commit(true);
        sqlSession.close();
    }



    @Override
    public List<Patient> findPatientBySome(Patient patient,Integer pageSize,Integer pageOffset) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        List<Patient> patientpo=patientMapper.selectListBySome(patient,pageSize,pageOffset);
        sqlSession.close();
        return patientpo;
    }

    @Override
    public PageInfo<Patient> findPageList(Patient patient,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        List<Patient> patientList=patientMapper.selectBySome(patient);
        sqlSession.close();
        return new PageInfo<Patient>(patientList);
    }

    @Override
    public boolean login(Patient patient) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        Patient patientpo=patientMapper.selectPatientByIdCardNumber(patient.getIdCardNumber());
        String passwordpo=patientpo.getPassword();
        String password=patient.getPassword();
        if(!passwordpo.equals(DigestUtils.md5Hex(password))){
            return false;
        }
        return true;
    }

    @Override
    public void encryption(Integer patientId) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        Patient patient=patientMapper.selectPatientByPatientId(patientId);
        String newPassword= DigestUtils.md5Hex(patient.getPassword());
        patientMapper.updatePatientPasswordByPatientId(newPassword,patientId);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public Integer findCountByIdCardNumber(String idCardNumber) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        Integer count=patientMapper.selectCountByIdCardNumber(idCardNumber);
        sqlSession.close();
        return count;
    }

    @Override
    public Patient findPatientByIdCardNumber(String idCardNumber) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        Patient patient=patientMapper.selectPatientByIdCardNumber(idCardNumber);
        sqlSession.close();
        return patient;
    }

    @Override
    public void addPatient(Patient patient) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        patientMapper.insertIntoPatient(patient);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public Patient findPatientByPatientId(Integer patientId) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        Patient patient=patientMapper.selectPatientByPatientId(patientId);
        sqlSession.close();
        return patient;
    }

    @Override
    public void changePatientEmailByPatientId(String email, Integer patientId) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        patientMapper.updatePatientEmailByPatientId(email,patientId);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public void changePatientPhoneByPatientId(String phone, Integer patientId) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        patientMapper.updatePatientPhoneByPatientId(phone,patientId);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public void changePatientPasswordByPatientId(String password, Integer patientId) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        patientMapper.updatePatientPasswordByPatientId(password,patientId);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public Patient selectPatientByName(String name) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        Patient patient =patientMapper.selectPatientsByName(name);
        sqlSession.close();
        return patient;
    }

    @Override
    public Integer getCurrentMaxPatientId() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper=sqlSession.getMapper(PatientMapper.class);
        String strMaxPatientId=patientMapper.selectMaxPatientId();
        Integer iMaxPatientId=Integer.parseInt(strMaxPatientId);
        sqlSession.close();
        return iMaxPatientId;
    }

    @Override
    public String selectPatientNameById(Integer id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
        String name=patientMapper.returnNameById(id);
        sqlSession.close();
        return name;
    }
}
