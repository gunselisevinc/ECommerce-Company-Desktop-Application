package com.team14.WebService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class phoneFeatures {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int phonefeatureID;

    private String phoneFeatureName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="phone_id")
    @JsonBackReference
    private Phone phoneFeatures;

    /***
     * getter for phonefeatureID
     * @return phonefeatureID
     */
    public int getPhonefeatureID() {
        return phonefeatureID;
    }

    /***
     * setter for phonefeatureID
     * @param phonefeatureID
     */
    public void setPhonefeatureID(int phonefeatureID) {
        this.phonefeatureID = phonefeatureID;
    }

    /***
     * getter for phoneFeatureName
     * @return phoneFeatureName
     */
    public String getPhoneFeatureName() {
        return phoneFeatureName;
    }

    /***
     * setter for phoneFeatureName
     * @param phoneFeatureName
     */
    public void setPhoneFeatureName(String phoneFeatureName) {
        this.phoneFeatureName = phoneFeatureName;
    }

    /***
     * getter for phoneFeatures
     * @return phoneFeatures
     */
    public Phone getPhoneFeatures() {
        return phoneFeatures;
    }

    /***
     * setter for phoneFeatures
     * @param phoneFeatures
     */
    public void setPhoneFeatures(Phone phoneFeatures) {
        this.phoneFeatures = phoneFeatures;
    }
}
