package com.taskManagement.TaskManagement.dtos;

public interface ResponseDto<T> {

    void setMessage(String message);
    void setStatus(Integer status);
    void setData(T data);
    String getMessage();
    Integer getStatus();
    T getData();
}
