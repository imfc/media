package com.imfc.media.common.result;

import java.io.Serializable;

public class MediaResult implements Serializable {
    private String code;
    private String msg;
    private Object value;
    private Integer num;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MediaResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", value=" + value +
                ", num=" + num +
                '}';
    }
}
