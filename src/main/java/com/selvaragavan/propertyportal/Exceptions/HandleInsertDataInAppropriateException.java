package com.selvaragavan.propertyportal.Exceptions;

import com.selvaragavan.propertyportal.ResponseParser.StringMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class HandleInsertDataInAppropriateException {
    @ExceptionHandler(value = InsertDataInAppropriateException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public StringMessage handler(InsertDataInAppropriateException e){
        return new StringMessage(e.getMessage());
    }
}
