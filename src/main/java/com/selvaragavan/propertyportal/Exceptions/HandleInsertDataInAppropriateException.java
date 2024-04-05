package com.selvaragavan.propertyportal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class HandleInsertDataInAppropriateException {
    @ExceptionHandler(value = InsertDataInAppropriateException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Message handler(InsertDataInAppropriateException e){
        return new Message(e.getMessage());
    }

    record Message(String message){}
}
