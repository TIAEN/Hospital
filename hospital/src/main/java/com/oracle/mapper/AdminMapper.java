package com.oracle.mapper;

import com.oracle.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    Admin selectAdminByUsername(String username);

    Admin selectAdminById(Integer id);

    void updateAdminPassword(@Param("password") String password, @Param("id") Integer id);

    Integer selectCountByUsername(String username);

}
