package com.team14.WebService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Computer")
public class Computer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "computerID")
    private int computerID;
    private float computerPrice;
    private String computerScreenSize;
    private String computerModel;
    private String computerBrand;
    private String screenRes;
    private String processor;
    private String memory;
    private String storageCapacity;

    @OneToMany(mappedBy="computerComments")
    private List<computerComments> computerComments;

    @OneToMany(mappedBy="computerFeature")
    private List<computerFeatures> computerFeatures;

    /**
     * Getter for computer id
     * @return the id of computer
     */
    public int getComputerID() {
        return computerID;
    }

    /**
     * Setter for computer id
     * @param computerID belongs to computer id
     */
    public void setComputerID(int computerID) {
        this.computerID = computerID;
    }

    /**
     * Getter for computer price
     * @return price of computer
     */
    public float getComputerPrice() {
        return computerPrice;
    }

    /**
     * Setter for computer price
     * @param computerPrice belongs to computer price
     */
    public void setComputerPrice(float computerPrice) {
        this.computerPrice = computerPrice;
    }

    /**
     * Getter for computer screen size
     * @return screen size of computer
     */
    public String getComputerScreenSize() {
        return computerScreenSize;
    }

    /**
     * Setter for computer screen size
     * @param computerScreenSize belongs to computer screen size
     */
    public void setComputerScreenSize(String computerScreenSize) {
        this.computerScreenSize = computerScreenSize;
    }

    /**
     * Getter for computer model
     * @return model of computer
     */
    public String getComputerModel() {
        return computerModel;
    }

    /**
     * Setter for computer model
     * @param computerModel belongs to computer model
     */
    public void setComputerModel(String computerModel) {
        this.computerModel = computerModel;
    }

    /**
     * Getter for computer brand
     * @return brand of computer
     */
    public String getComputerBrand() {
        return computerBrand;
    }

    /**
     * Setter for computer brand
     * @param computerBrand belongs to computer brand
     */
    public void setComputerBrand(String computerBrand) {
        this.computerBrand = computerBrand;
    }

    /**
     * Getter for computer screen resolution
     * @return  screen resolution of computer
     */
    public String getScreenRes() {
        return screenRes;
    }

    /**
     * Setter for computer screen resolution
     * @param screenRes belongs to computer screen resolution
     */
    public void setScreenRes(String screenRes) {
        this.screenRes = screenRes;
    }

    /**
     * Getter for computer processor
     * @return processor of computer
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Setter for computer processor
     * @param processor belongs to computer processor
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    /**
     * Getter for computer memory
     * @return memory of computer
     */
    public String getMemory() {
        return memory;
    }

    /**
     * Setter for computer memory
     * @param memory belongs to computer memory
     */
    public void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * Getter for computer storage capacity
     * @return processor of computer
     */
    public String getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * Setter for computer storage capacity
     * @param storageCapacity belongs to computer storage capacity
     */
    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * Getter for computer comments
     * @return comments of computer
     */
    public List<com.team14.WebService.entity.computerComments> getComputerComments() {
        return computerComments;
    }

    /**
     * Setter for computer comments
     * @param computerComments belongs to computer comments
     */
    public void setComputerComments(List<com.team14.WebService.entity.computerComments> computerComments) {
        this.computerComments = computerComments;
    }

    /**
     * Getter for computer computer features
     * @return features of computer
     */
    public List<com.team14.WebService.entity.computerFeatures> getComputerFeatures() {
        return computerFeatures;
    }

    /**
     * Setter for computer features
     * @param computerFeatures belongs to computer features
     */
    public void setComputerFeatures(List<com.team14.WebService.entity.computerFeatures> computerFeatures) {
        this.computerFeatures = computerFeatures;
    }
}
