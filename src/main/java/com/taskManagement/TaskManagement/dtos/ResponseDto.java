package com.taskManagement.TaskManagement.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseDto<T> {

    String message = "Request processed successfully.";
    Integer status = 200;
    T data;

    public ResponseDto(T data) {
        this.data = data;
    }

    public ResponseDto(String message, T data) {
        this.message = message;
        this.data = data;
    }
}