package com.team14.WebService.controller;

import com.team14.WebService.entity.Computer;
import com.team14.WebService.entity.Phone;
import com.team14.WebService.entity.computerComments;
import com.team14.WebService.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    /**
     * Gets and responds to user request for saving computer
     * @param r belongs to computer
     * @return respond to user request
     * @throws InterruptedException because lock mechanism is used for synchronization
     */
    @PostMapping("/addComputer")
    public Computer saveComputer(@RequestBody Computer r) throws InterruptedException {
        return computerService.saveComputer(r);
    }

    /**
     * Gets and responds to user request for getting computer comments by id
     * @param id belongs to computer
     * @return respond to reqyest
     */
    @GetMapping("/getAllComputerCommentsById/{id}")
    public List<computerComments> getAllComputerCommentsById(@PathVariable int id){return computerService.getAllComputerCommentsById(id);};

    /**
     * Gets and responds to user request for getting computer by given id
     * @param id belongs to computer id
     * @return respond to user request
     * @throws InterruptedException because lock mechanism is used for synchronization
     */
    @GetMapping("/getComputer/{id}")
    public Computer getComputer(@PathVariable int id) throws InterruptedException {
        return computerService.getComputer(id);
    }

    /**
     * Gets and responds to user request for getting all computers
     * @return respond to user request
     */
    @GetMapping("/getAllComputer")
    public List<Computer> getAllComputer(){
        return computerService.getAllComputer();
    }

    /**
     * Gets and responds to user request for getting computer by given brand
     * @param brand belongs to computer brand
     * @return respond to user request
     */
    @GetMapping("/getComputerByBrand/{brand}")
    public List<Computer> getComputerByBrand(@PathVariable String brand){
        return computerService.getComputerByBrand(brand);
    }

    /**
     * Gets and responds to user request for getting computer by given price
     * @param price belongs to computer price
     * @return respond to user request
     */
    @GetMapping("/getComputerByPrice/{price}")
    public List<Computer> getComputerByBrand(@PathVariable Float price){
        return computerService.getComputerByBPrice(price);
    }

    /**
     * Gets and responds to user request for getting computer by given screen size
     * @param screenSize belongs to computer screen size
     * @return respond to user request
     */
    @GetMapping("/getComputerByBrand/{screenSize}")
    public List<Computer> getComputerByScreenSize(@PathVariable String screenSize){
        return computerService.getComputerByScreenSize(screenSize);
    }

    /**
     * Gets and responds to user request for getting computer by given model
     * @param model belongs to computer model
     * @return respond to user request
     */
    @GetMapping("/getComputerByBrand/{model}")
    public List<Computer> getComputerByModel(@PathVariable String model){
        return computerService.getComputerByModel(model);
    }

    /**
     * Gets and responds to user request for getting computer by given processor
     * @param processor belongs to computer processor
     * @return respond to user request
     */
    @GetMapping("/getComputerByProcessor/{processor}")
    public List<Computer> getComputerByProcessor(@PathVariable String processor){
        return computerService.getComputerByProcessor(processor);
    }

    /**
     * Gets and responds to user request for getting computer by given memory
     * @param memory belongs to computer memory
     * @return respond to user request
     */
    @GetMapping("/getComputerByMemory/{memory}")
    public List<Computer> getComputerByMemory(@PathVariable String memory){
        return computerService.getComputerByMemory(memory);
    }

    /**
     * Gets and responds to user request for getting computer by given processor, memory and capacity
     * @param processor belongs to computer processor
     * @param memory belongs to computer memory
     * @param capacity belongs to computer capacity
     * @return respond to user request
     */
    @GetMapping("/SearchComputerByPorcessor_Memory_Capacity/{processor}/{memory}/{capacity}")
    public List<Computer> SearchComputerByPorcessor_Memory_Capacity(@PathVariable String processor,@PathVariable String memory,@PathVariable String capacity){
        return computerService.SearchComputerByPorcessor_Memory_Capacity(processor,memory,capacity);
    }

    /**
     * Gets and responds to user request for getting computer by given storage capacity
     * @param storageCapacity belongs to computer storae capacity
     * @return respond to user request
     */
    @GetMapping("/getComputerByStorageCapacity/{storageCapacity}")
    public List<Computer> getComputerByStorageCapacity(@PathVariable String storageCapacity){
        return computerService.getComputerByStorageCapacity(storageCapacity);
    }

    /**
     * Gets and responds to user request for getting computer by given price and brand
     * @param price belongs to computer price
     * @param brand belongs to computer brand
     * @return respond to user request
     */
    @GetMapping("/SearchComputerByMaximumPriceAndBrand/{price}/{brand}")
    public List<Computer> SearchComputerByMaximumPriceAndBrand(@PathVariable float price,@PathVariable String brand){
        return computerService.SearchComputerByMaximumPriceAndBrand(price,brand);
    }
}