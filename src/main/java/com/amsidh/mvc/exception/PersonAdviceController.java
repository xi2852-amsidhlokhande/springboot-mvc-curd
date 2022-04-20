package com.amsidh.mvc.exception;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;

@RequiredArgsConstructor
@ControllerAdvice
public class PersonAdviceController {

    @ExceptionHandler(value = {PersonNotFoundException.class})
    public ResponseEntity<ErrorDetail> handlePersonNotFoundException(PersonNotFoundException personNotFoundException, WebRequest webRequest) {
        return ResponseEntity.ok(ErrorDetail.builder()
                .errorCode("0001")
                .errorMessage(personNotFoundException.getMessage())
                .build());
    }
}

@Data
@Builder
class ErrorDetail implements Serializable {
    private String errorCode;
    private String errorMessage;
    private String data;
}