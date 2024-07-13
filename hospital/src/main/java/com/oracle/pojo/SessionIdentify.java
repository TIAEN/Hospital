package com.oracle.pojo;


//存放登录后的信息
public class SessionIdentify<T> {

    private Integer tag;        //0表示管理员，1表示医生

    private T t;

    public SessionIdentify() {
    }

    public SessionIdentify(Integer tag, T t) {
        this.tag = tag;
        this.t = t;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "SessionIdentify{" +
                "tag=" + tag +
                ", t=" + t +
                '}';
    }
}
