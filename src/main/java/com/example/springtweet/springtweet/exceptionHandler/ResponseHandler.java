package com.example.springtweet.springtweet.exceptionHandler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ResponseHandler {

    @ExceptionHandler(value = SuccessMessage.class)
    @ResponseBody
    public ResponseMessage successMessage(SuccessMessage e) {
        ResponseMessage ex = new ResponseMessage();
        ex.setUrl(e.getUrl());
        ex.setStatus(e.getStatus());
        ex.setMessage(e.getMessage());
        return ex;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ResponseMessage failureMessage(CustomException e) {
        ResponseMessage ex = new ResponseMessage();
        ex.setStatus(e.getStatus());
        ex.setMessage(e.getMessage());
        return ex;
    }

}