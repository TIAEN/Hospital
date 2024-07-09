package com.oracle.pojo;

import java.math.BigDecimal;

public class Books implements java.io.Serializable {
    private int bookId;
    private String bookName;
    private BigDecimal Price;
    private String bookInfo;
    private int bookNum;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", Price=" + Price +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }
}
