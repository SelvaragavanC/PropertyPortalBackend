package com.selvaragavan.propertyportal.PropertyForSaleFunctionalities;

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
    public Message addProperty(@RequestBody Map<String,String> propertyDetails){
        System.out.println(propertyDetails);
        return new Message(propertyForSaleRepository.addPropertyForSale(propertyDetails));
    }

    @GetMapping({"sale/getProperties/{user}"})
    public List<Map<String,Object>> getPropertiesOfUser(@PathVariable(value = "user") String userId){
        return propertyForSaleRepository.getPropertiesByFilter(Integer.parseInt(userId));
    }


    @PostMapping({"/sale/updateProperty"})
    public Message updateProperty(@RequestBody Map<String,String> propertyDetails){
        return new Message(propertyForSaleRepository.updateProperty(propertyDetails));
    }

    record Message(String message){}
}
