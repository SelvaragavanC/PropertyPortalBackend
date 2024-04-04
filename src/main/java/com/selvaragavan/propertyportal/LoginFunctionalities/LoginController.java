package com.selvaragavan.propertyportal.LoginFunctionalities;

import com.selvaragavan.propertyportal.Exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    public final LoginRepository loginRepo;
    public LoginController(LoginRepository loginRepo){
        this.loginRepo = loginRepo;
    }
    @PostMapping({"/login"})
    public Map<String,Object> login(@RequestBody Map<String,String> usrDetails){
        String email = usrDetails.get("email");
        String password = usrDetails.get("password");
        return loginRepo.getUser(email,password);
    }
}
