package com.selvaragavan.propertyportal.RegisterFunctionalities;

import com.selvaragavan.propertyportal.Exceptions.UserNotFoundException;
import com.selvaragavan.propertyportal.ResponseParser.StringMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class RegisterRepository {
    public final JdbcTemplate jdbcTemplate;
    public RegisterRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public StringMessage registerAUser(Map<String,String> userDetails){
        String name = userDetails.get("name");
        String email = userDetails.get("email");
        String phoneNumber = userDetails.get("phoneNumber");
        String password = userDetails.get("password");
        String address = userDetails.get("address");
        String sql = "INSERT INTO registeredUsers (name,email,phoneNumber,password,address) values(?,?,?,?,?)";
        if(alreadyRegistered(email)) throw new UserNotFoundException("You are already registered, please login");
        int affectedRows = jdbcTemplate.update(sql,name,email,phoneNumber,password,address);
        return new StringMessage("You are registered succesffully, Login and continue");
    }

    public boolean alreadyRegistered(String email){
        String sql = "select name from registeredUsers where email = ?";
        try{
            String usr = jdbcTemplate.queryForObject(sql,new Object[]{email},String.class);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }

}
