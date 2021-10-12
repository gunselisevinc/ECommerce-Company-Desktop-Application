package com.team14.WebService.controller;

import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.computerFeatures;
import com.team14.WebService.service.computerCommentsService;
import com.team14.WebService.service.computerFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class computerCommentsController {
    @Autowired
    computerCommentsService computerCommentsServiceObj;

    /**
     * Gets and responds to user request for saving computer comments
     * @param cc belongs to computer comments
     * @return respond to user request
     */
    @PostMapping("/addComputerComments")
    public computerComments saveComputerComments(@RequestBody computerComments cc) { return computerCommentsServiceObj.saveComputerComments(cc);}

    /**
     * Gets and responds to user request for getting computer comment by given id
     * @param id belongs to computer comment id
     * @return respond to user request
     */
    @GetMapping("/getComputerComments/{id}")
    public computerComments getComputerComments(@PathVariable int id) { return computerCommentsServiceObj.getComputerComments(id); }

    /**
     * Gets and responds to user request for getting all computer comments
     * @return respond to user request
     */
    @GetMapping("/getAllComputerComments")
    public List<computerComments> getAllComputerComments() { return computerCommentsServiceObj.getAllComputerComments();}

    /**
     * Gets and responds to user request for getting all comments of computer by given id
     * @param id belongs to computer id
     * @return respond to user request
     */
    @GetMapping("/getAllComputerByComputerID/{id}")
    public List<computerComments> getAllComputerByComputerID(@PathVariable int id){return computerCommentsServiceObj.getAllComputerByComputerID(id);}
}
