package com.selvaragavan.propertyportal.LoginFunctionalities;

import com.selvaragavan.propertyportal.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LoginRepository {
    public final JdbcTemplate jdbcTemplate;
    public LoginRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String,Object> getUser(String email,String password){
        String sql = "select * from registeredUsers where email = ?";
        List<Map<String,Object> > usrList = jdbcTemplate.query(sql, new Object[]{email},new ColumnMapRowMapper());
        if(usrList.size()==0) throw new UserNotFoundException("You haven't registered yet");
        if(!usrList.get(0).get("password").equals(password)) throw new UserNotFoundException("Password Wrong");
        return usrList.get(0);
    }
}
