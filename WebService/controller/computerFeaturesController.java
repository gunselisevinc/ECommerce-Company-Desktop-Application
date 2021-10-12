package com.team14.WebService.controller;

import com.team14.WebService.entity.computerFeatures;
import com.team14.WebService.service.computerFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class computerFeaturesController {

    @Autowired
    computerFeaturesService computerFeaturesServiceObj;

    /**
     * Gets and responds to user request for saving computer feature
     * @param cf belongs to computer feature
     * @return respond to user request
     */
    @PostMapping("/addComputerFeatures")
    public computerFeatures saveComputerFeatures(@RequestBody computerFeatures cf) { return computerFeaturesServiceObj.saveComputerFeature(cf);}

    /**
     * Gets and responds to user request for getting computer feature by given id
     * @param id belongs to computer feature id
     * @return respond to user request
     */
    @GetMapping("/getComputerFeatures/{id}")
    public computerFeatures getComputerFeatures(@PathVariable int id) { return computerFeaturesServiceObj.getComputerFeature(id); }

    /**
     *  Gets and responds to user request for getting all computer features
     * @return respond to user request
     */
    @GetMapping("/getAllComputerFeatures")
    public List<computerFeatures> getAllComputerFeatures() { return computerFeaturesServiceObj.getAllComputerFeatures();}

    /**
     * Gets and responds to user request for getting all computer features by given id
     * @param id belongs to computer id
     * @return respond to user request
     */
    @GetMapping("/getAllComputerFeaturesByComputerID/{id}")
    public List<computerFeatures> getAllComputerFeaturesByComputerID(@PathVariable int id) { return computerFeaturesServiceObj.getAllComputerFeaturesByComputerID(id);}

}
