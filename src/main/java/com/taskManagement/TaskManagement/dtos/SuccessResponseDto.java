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
public class SuccessResponseDto<T> implements ResponseDto<T> {

    String message = "Request processed successfully.";
    Integer status = 200;
    T data;

    public SuccessResponseDto(T data) {
        this.data = data;
    }

    public SuccessResponseDto(String message,T data) {
        this.message = message;
        this.data = data;
    }
}