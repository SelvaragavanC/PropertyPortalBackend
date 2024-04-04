package com.selvaragavan.propertyportal.RegisterFunctionalities;

import com.selvaragavan.propertyportal.ResponseParser.StringMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    RegisterRepository registerRepo;
    @PostMapping({"/register"})
    public StringMessage register(@RequestBody Map<String,String> userDetails){
        return registerRepo.registerAUser(userDetails);
    }
}
