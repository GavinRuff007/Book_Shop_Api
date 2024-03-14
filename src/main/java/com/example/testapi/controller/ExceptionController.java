package com.example.testapi.controller;

import com.example.testapi.dto.response.ExceptionResponse;
import com.example.testapi.exception.RuleException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionController {

    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }


    @ExceptionHandler(RuleException.class)
    public ResponseEntity<List<ExceptionResponse>> handlerRuleException(RuleException ruleException){
        return ResponseEntity
                .status(400)
                .body(Collections.singletonList(buildExceptionCreateResponse(ruleException)));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity
                .status(402)
                .body(methodValidation(methodArgumentNotValidException));
    }


    private List<ExceptionResponse> methodValidation(MethodArgumentNotValidException methodArgumentNotValidException){
        return methodArgumentNotValidException.getFieldErrors()
                .stream().map(error ->
                    ExceptionResponse.builder()
                            .message(error.getDefaultMessage())
                            .code(error.getField())
                            .build()
                ).collect(Collectors.toList());

    }


    private ExceptionResponse buildExceptionCreateResponse(RuleException ruleException){
        return ExceptionResponse.builder()
                .message(messageSourceAccessor.getMessage(ruleException.getMessage()))
                .code(ruleException.getMessage())
                .build();
    }
}
