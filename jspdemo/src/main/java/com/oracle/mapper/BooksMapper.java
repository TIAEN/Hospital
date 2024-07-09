package com.oracle.mapper;

import com.oracle.pojo.Books;

import java.util.List;

public interface BooksMapper {

    List<Books> selectBooksAll();
}
