package com.team14.WebService.controller;

import com.team14.WebService.entity.Computer;
import com.team14.WebService.entity.Phone;
import com.team14.WebService.entity.phoneComments;
import com.team14.WebService.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    /***
     * gets the request from client to save Phone into database
     * @param r Phone
     * @return response to the user request
     * @throws InterruptedException
     */
    @PostMapping("/addPhone")
    public Phone savePhone(@RequestBody Phone r) throws InterruptedException {
        return phoneService.savePhone(r);
    }

    /***
     * gets the request from client to get Phone by its ID from database
     * @param id integer to specify its Phone ID
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getPhone/{id}")
    public Phone getPhone(@PathVariable int id) throws InterruptedException {
        return phoneService.getPhone(id);
    }

    /***
     * gets the request from client to get all Phones from database
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getAllPhone")
    public List<Phone> getAllPhone() throws InterruptedException {
        return phoneService.getAllPhone();
    }

    /**
     *
     * @param id for phone
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getAllPhoneCommentsById/{id}")
    public List<phoneComments> getAllPhoneCommentsById(@PathVariable int id) throws InterruptedException {return phoneService.getAllPhoneCommentsById(id);};



    /***
     * gets the request from client to get all Phones from database
     * @param brand a string to specify its Brand
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getPhoneByBrand/{brand}")
    public List<Phone> getPhoneByBrand(@PathVariable String brand) throws InterruptedException {
        return phoneService.getPhoneByBrand(brand);
    }

    /***
     * gets the request from client to get Phone by its model from database
     * @param model a string to specify its Model
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getPhoneByModel/{model}")
    public List<Phone> getPhoneByModel(@PathVariable String model) throws InterruptedException {
        return phoneService.getPhoneByBrand(model);
    }

    /***
     * gets the request from client to get Phone by its screen size from database
     * @param screenSize is a string to specify its screen size
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getPhoneByScreenSize/{screenSize}")
    public List<Phone> getPhoneByScreenSize(@PathVariable String screenSize) throws InterruptedException {
        return phoneService.getPhoneByScreenSize(screenSize);
    }

    /***
     * gets the request from client to get Phone by its internal memory from database
     * @param internalMemory is a string to specify its internal memory
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getPhoneByInternalMemory/{internalMemory}")
    public List<Phone> getPhoneByInternalMemory(@PathVariable String internalMemory) throws InterruptedException {
        return phoneService.getPhoneByInternalMemory(internalMemory);
    }

    /***
     * gets the request from client to get Phone by its price from database
     * @param price is a float to specify its price
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/getPhoneByPrice/{price}")
    public List<Phone> getPhoneByPrice(@PathVariable float price) throws InterruptedException {
        return phoneService.getPhoneByPrice(price);
    }

    /***
     * gets the request from client to get Phone by its model and brand from database
     * @param model is a string to specify its model
     * @param brand is a string to specify its brand
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/SearchPhoneByModelAndBrand/{model}/{brand}")
    public List<Phone> SearchPhoneByModelAndBrand(@PathVariable String  model,@PathVariable String brand) throws InterruptedException {
        return phoneService.SearchPhoneByModelAndBrand(model,brand);
    }

    /***
     * gets the request from client to get Phone by its screen ,memory and brand from database
     * @param screen is a string to specify its screen
     * @param memory is a string to specify its memory
     * @param brand is a string to specify its brand
     * @return response to the user request
     * @throws InterruptedException
     */
    @GetMapping("/SearchPhoneByScreenSize_MemoryAndBrand/{screen}/{memory}/{brand}")
    public List<Phone> SearchPhoneByScreenSize_MemoryAndBrand(@PathVariable String  screen,@PathVariable String  memory,@PathVariable String brand) throws InterruptedException {
        return phoneService.SearchPhoneByScreenSize_MemoryAndBrand(screen,memory,brand);
    }
}
