package com.team14.WebService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int phone_id;
    private String phone_model;
    private String phone_brand;
    private String phone_screenSize;
    private String phone_internalMemory;
    private float price;


    @OneToMany(mappedBy="phoneComments")
    //@JsonIgnore
    @JsonManagedReference
    private List<phoneComments> phoneComments ;


    @OneToMany(mappedBy="phoneFeatures")
    //@JsonIgnore
    @JsonManagedReference
    private List<phoneFeatures> phoneFeatures;

    /***
     * getter for phone_id
     * @return phone_id
     */
    public int getPhone_id() {
        return phone_id;
    }

    /***
     * setter for phone_id
     * @param phone_id
     */
    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    /***
     * getter for phone_model
     * @return phone_model
     */
    public String getPhone_model() {
        return phone_model;
    }

    /***
     * setter for phone_model
     * @param phone_model
     */
    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    /***
     * getter for phone_brand
     * @return phone_brand
     */
    public String getPhone_brand() {
        return phone_brand;
    }

    /***
     * setter for phone_brand
     * @param phone_brand
     */
    public void setPhone_brand(String phone_brand) {
        this.phone_brand = phone_brand;
    }

    /***
     * getter for phone_screenSize
     * @return phone_screenSize
     */
    public String getPhone_screenSize() {
        return phone_screenSize;
    }

    /***
     * setter for phone_screenSize
     * @param phone_screenSize
     */
    public void setPhone_screenSize(String phone_screenSize) {
        this.phone_screenSize = phone_screenSize;
    }

    /***
     * getter for phone_internalMemory
     * @return phone_internalMemory
     */
    public String getPhone_internalMemory() {
        return phone_internalMemory;
    }

    /***
     * setter for phone_internalMemory
     * @param phone_internalMemory
     */
    public void setPhone_internalMemory(String phone_internalMemory) {
        this.phone_internalMemory = phone_internalMemory;
    }

    /***
     * getter for price
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /***
     * setter for price
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /***
     * getter for phoneComments
     * @return phoneComments
     */
    public List<com.team14.WebService.entity.phoneComments> getPhoneComments() {
        return phoneComments;
    }

    /***
     * setter for phoneComments
     * @param phoneComments
     */
    public void setPhoneComments(List<com.team14.WebService.entity.phoneComments> phoneComments) {
        this.phoneComments = phoneComments;
    }

    /***
     * getter for phoneFeatures
     * @return phoneFeatures
     */
    public List<com.team14.WebService.entity.phoneFeatures> getPhoneFeatures() {
        return phoneFeatures;
    }

    /***
     * setter for phoneFeatures
     * @param phoneFeatures
     */
    public void setPhoneFeatures(List<com.team14.WebService.entity.phoneFeatures> phoneFeatures) {
        this.phoneFeatures = phoneFeatures;
    }
}
