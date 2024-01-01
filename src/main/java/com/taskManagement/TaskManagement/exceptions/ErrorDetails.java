package com.taskManagement.TaskManagement.exceptions;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ErrorDetails {

    private Integer statusCode;
    private String message;
    private Date timeStamp;
}
