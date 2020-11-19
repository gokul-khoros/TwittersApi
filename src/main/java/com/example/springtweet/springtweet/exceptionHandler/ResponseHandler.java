package com.example.springtweet.springtweet.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
class HandlerMsg {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResponseMessage successMessage(MyException e) {
        ResponseMessage ex = new ResponseMessage();
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