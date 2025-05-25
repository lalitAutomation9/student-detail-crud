package com.student.student_data.exception;

public class DuplicateRecordException extends RuntimeException{
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public DuplicateRecordException(String msg){
        super(msg);
        this.msg = msg;
    }
}
