package com.team14.WebService.controller;

import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.phoneComments;
import com.team14.WebService.service.phoneCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class phoneCommentsController {
    @Autowired
    phoneCommentsService phoneCommentsServiceObj;

    /***
     * gets the request from client to save Phone comments into database
     * @param pc Phone Comment
     * @return response to the user request
     */
    @PostMapping("/addPhoneComments")
    public phoneComments savePhoneComments(@RequestBody phoneComments pc) { return phoneCommentsServiceObj.savePhoneComments(pc);}

    /***
     * gets the request from client to get Phone Comment by its comment ID from database
     * @param id an integer to specify its Phone Comment ID
     * @return response to the user request
     */
    @GetMapping("/getPhoneComments/{id}")
    public phoneComments getPhoneComments(@PathVariable int id) { return phoneCommentsServiceObj.getPhoneComments(id); }

    /***
     * gets the request from client to get all Phone Comments  from database
     * @return response to the user request
     */
    @GetMapping("/getAllPhoneComments")
    public List<phoneComments> getAllPhoneComments() { return phoneCommentsServiceObj.getAllPhoneComments();}

    /***
     * gets the request from client to get Phone Comments by its Phone ID from database
     * @param id integer to specify its Phone ID
     * @return response to the user request
     */
    @GetMapping("/getPhoneCommentsByPhoneID{id}")
    public List<phoneComments> getPhoneCommentsByPhoneID(@PathVariable int id) { return phoneCommentsServiceObj.getPhoneCommentsByPhoneID(id); }




}
