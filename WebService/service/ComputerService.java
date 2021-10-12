package com.team14.WebService.service;

import com.team14.WebService.entity.Computer;
import com.team14.WebService.entity.Phone;
import com.team14.WebService.entity.computerComments;
import com.team14.WebService.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;
    Lock lock = new ReentrantLock();

    /**
     * Saves the entered computer to database
     * @param c used for computer object to be stored
     * @return saves the given computer
     * @throws InterruptedException because lock mechanism is used for synchronization
     */
    public Computer saveComputer(Computer c) throws InterruptedException{
        lock.lock();
        //Thread.sleep(10000);
        Computer temp = computerRepository.save(c);
        lock.unlock();
        return temp;
    }

    /**
     * Returns the specific desired computer
     * @param id belongs to a computer
     * @return the computer with given id
     * @throws InterruptedException because lock mechanism is used for synchronization
     */
    public Computer getComputer(int id) throws InterruptedException{
        lock.lock();
        Computer temp = computerRepository.findById(id).orElse(null);
        lock.unlock();
        return temp;
    }

    /**
     * Returns all computer stored
     * @return all the computers stored int he database
     */
    public List<Computer> getAllComputer(){
        lock.lock();
        List<Computer> tempComputerList = computerRepository.findAll();
        lock.unlock();
        return tempComputerList;
    }

    /**
     *
     * @param id of computer
     * @return all coments of specific computer
     */

    public List<computerComments> getAllComputerCommentsById(int id){
        computerComments compcomments = new computerComments();
        List<Computer> computers = new ArrayList<>();
        List<computerComments> retrievedComments = new ArrayList<>();
        computers = getAllComputer();
        int flag=0;

        for (int i =0;i<computers.size();i++){
            if(id == computers.get(i).getComputerID())
                flag=i;

        }
        retrievedComments=computers.get(flag).getComputerComments();
        return retrievedComments;
    }


    /**
     * Returns all the computers with the given brand
     * @param s represents a brand name
     * @return the computers in database with the given brand
     */
    public List<Computer> getComputerByBrand(String s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getComputerBrand().equals(s)) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the given price
     * @param s represents price
     * @return the computers in database with the given price
     */
    public List<Computer> getComputerByBPrice(Float s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getComputerPrice()==s) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the given screen size
     * @param s represents screen size
     * @return the computers in database with the given screen size
     */
    public List<Computer> getComputerByScreenSize(String s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getComputerScreenSize().equals(s)) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the given model
     * @param s represents model name
     * @return the computers in database with the given model name
     */
    public List<Computer> getComputerByModel(String s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getComputerModel().equals(s)) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the given processor
     * @param s represents processor size
     * @return the computers in database with the given processor size
     */
    public List<Computer> getComputerByProcessor(String s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getProcessor().equals(s)) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the given memory
     * @param s represents memory size
     * @return the computers in database with the given memory size
     */
    public List<Computer> getComputerByMemory(String s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getMemory().equals(s)) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the storage
     * @param s represents storage capacity
     * @return the computers in database with the given storage capacity
     */
    public List<Computer> getComputerByStorageCapacity(String s){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();
        for (Computer computer : computers) {
            if (computer.getStorageCapacity().equals(s)) {
                temp = computer;
                computers2.add(temp);
            }
        }
        return computers2;
    }

    /**
     * Returns all the computers with the brand name and with maximum price entered
     * @param price represents maximum computer price
     * @param brand represents brand name
     * @return the computers with given brand name with price which is at most the given price
     */
    public List<Computer> SearchComputerByMaximumPriceAndBrand(float price,String brand){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();


        for (Computer computer : computers) {
            if(price<=computer.getComputerPrice() && brand.equals(computer.getComputerBrand())) {
                temp = computer;
                computers2.add(temp);
            }

        }
        return computers2;
    }

    /**
     * Returns all the computers with the processor size, memory size and capacity entered
     * @param proces represents processor size
     * @param memory represents memory size
     * @param capacity represents computer capacity
     * @return the computers with given processor, memory and capacity
     */
    public List<Computer> SearchComputerByPorcessor_Memory_Capacity(String  proces,String memory, String capacity){
        Computer temp = new Computer();
        List<Computer> computers = new ArrayList<>();
        List<Computer> computers2 = new ArrayList<>();
        computers=getAllComputer();


        for (Computer computer : computers) {
            if(memory.equals(computer.getMemory()) && proces.equals(computer.getProcessor()) && capacity.equals(computer.getStorageCapacity())) {
                temp = computer;
                computers2.add(temp);
            }

        }
        return computers2;
    }




}
