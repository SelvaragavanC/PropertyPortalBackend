package com.selvaragavan.propertyportal.PropertyForSaleFunctionalities;

import com.selvaragavan.propertyportal.Exceptions.InsertDataInAppropriateException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PropertyForSaleRepository {
    public final JdbcTemplate jdbcTemplate;
    public PropertyForSaleRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addPropertyForSale(Map<String,String> details){
        String byUserId = details.get("byUserId");
        String type = details.get("type");
        String address = details.get("address");
        String area = details.get("area");
        String price = details.get("price");
        String description = details.get("description");
        String sql = "INSERT INTO propertiesForSale(byUserId,type,address,area,price,description) values(?,?,?,?,?,?)";

        try{
            jdbcTemplate.update(sql,byUserId,type,address,area,price,description);
        }catch(Exception e){
            throw new InsertDataInAppropriateException(e.getMessage());
        }
        return "Successfully added";
    }

    public List<Map<String,Object>> getPropertiesByFilter(String addressSubstring){
        String sql = "SELECT * FROM propertiesForSale WHERE address LIKE '%"+addressSubstring +"%'";
        return jdbcTemplate.query(sql,new ColumnMapRowMapper());
    }

    public List<Map<String,Object>> getPropertiesByFilter(int userId){
        String sql = "SELECT * FROM propertiesForSale WHERE byUserId = "+userId;
        return jdbcTemplate.query(sql,new ColumnMapRowMapper());
    }

    public String updateProperty(Map<String,String> details){
        String id = details.get("id");
        String type = details.get("type");
        String address = details.get("address");
        String area = details.get("area");
        String price = details.get("price");
        String description = details.get("description");
        String sql = "UPDATE propertiesForSale SET type = ?,address = ?,area = ?,price = ?,description = ? WHERE id = ?";
        try{
            jdbcTemplate.update(sql,type,address,area,price,description,id);
        }catch(Exception e){
            throw new InsertDataInAppropriateException(e.getMessage());
        }
        return "Successfully modified your property";
    }
}
