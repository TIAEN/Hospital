package com.oracle.service;

import com.oracle.mapper.BooksMapper;
import com.oracle.pojo.Books;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.awt.print.Book;
import java.util.List;

public class BooksService {

    public List<Books> findAll(){

        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        BooksMapper booksMapper=sqlSession.getMapper(BooksMapper.class);
        return booksMapper.selectBooksAll();
    }


}
