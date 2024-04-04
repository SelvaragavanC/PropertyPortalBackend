package com.selvaragavan.propertyportal.PropertyForSaleFunctionalities;

import com.selvaragavan.propertyportal.ResponseParser.StringMessage;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PropertyForSaleControllers {
    @Autowired
    PropertyForSaleRepository propertyForSaleRepository;
    @GetMapping({"sale/getProperties"})
    public List<Map<String,Object>> getProperties(@RequestParam(value = "q") String addressSubstring){
        return propertyForSaleRepository.getPropertiesByFilter(addressSubstring);
    }

    @PostMapping({"/sale/addProperty"})
    public StringMessage addProperty(@RequestBody Map<String,String> propertyDetails){
        return propertyForSaleRepository.addPropertyForSale(propertyDetails);
    }
}
