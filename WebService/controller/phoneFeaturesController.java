package com.team14.WebService.controller;

import com.team14.WebService.entity.computerFeatures;
import com.team14.WebService.entity.phoneFeatures;
import com.team14.WebService.service.phoneFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class phoneFeaturesController {
    @Autowired
    phoneFeaturesService phoneFeaturesServiceObj;

    /***
     * gets the request from client to save Phone Feature into database
     * @param pf Phone Feature
     * @return response to the user request
     */
    @PostMapping("/addPhoneFeatures")
    public phoneFeatures savePhoneFeatures(@RequestBody phoneFeatures pf) { return phoneFeaturesServiceObj.savePhoneFeature(pf);}

    /***
     * gets the request from client to get a Phone Feature by its ID from database
     * @param id an integer to specify Phone Feature ID
     * @return response to the user request
     */
    @GetMapping("/getPhoneFeatures/{id}")
    public phoneFeatures getPhoneFeatures(@PathVariable int id) { return phoneFeaturesServiceObj.getPhoneFeature(id); }

    /***
     * gets the request from client to get all Phone Features from database
     * @return response to the user request
     */
    @GetMapping("/getAllPhoneFeatures")
    public List<phoneFeatures> getAllPhoneFeatures() { return phoneFeaturesServiceObj.getAllPhoneFeatures();}

    /***
     * gets the request from client to get all Phone Features by its ID from database
     * @param id an integer to specify its Phone ID
     * @return response to the user request
     */
    @GetMapping("/getPhoneFeaturesByID/{id}")
    public List<phoneFeatures> getAllPhoneFeaturesByID(@PathVariable int id) {return phoneFeaturesServiceObj.getAllPhoneFeaturesByPhoneID(id);}

}
