package com.oracle.mapper;

import com.oracle.pojo.Admin;
import com.oracle.pojo.ProfessionalTitle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProfessionalTitleMapper {

    List<ProfessionalTitle> selectProfessionalTitleAll();


}
