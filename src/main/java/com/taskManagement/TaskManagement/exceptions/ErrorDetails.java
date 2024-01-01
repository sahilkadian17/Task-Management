package com.taskManagement.TaskManagement.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {

    private Integer statusCode;
    private String message;
    private Date timeStamp;
}
