package com.oracle.service;

import com.oracle.mapper.AdminMapper;
import com.oracle.pojo.Admin;
import com.oracle.utils.DBUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService{


    @Override
    public boolean login(Admin admin) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
        Integer countOfName=adminMapper.selectCountByUsername(admin.getUserName());
        if(countOfName==0){
            //用户不存在
            sqlSession.close();
            return false;
        }
        Admin adminpo=adminMapper.selectAdminByUsername(admin.getUserName());
        String passwordpo=adminpo.getPassword();
        String password=DigestUtils.md5Hex(admin.getPassword());
        if(!password.equals(passwordpo)){
            //密码错误
            sqlSession.close();
            return false;
        }
        admin.setAdminId(adminpo.getAdminId());
        admin.setAvatar(adminpo.getAvatar());
        admin.setName(adminpo.getName());
        admin.setEmail(adminpo.getEmail());
        admin.setPhone(adminpo.getPhone());
        sqlSession.close();
        return true;
    }





    @Override
    public void encryption(Integer id) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
        Admin admin=adminMapper.selectAdminById(id);
        String password=DigestUtils.md5Hex(admin.getPassword());
        adminMapper.updateAdminPassword(password,id);
        sqlSession.commit(true);
        sqlSession.close();
    }


}
