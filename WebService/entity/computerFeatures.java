package com.team14.WebService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "ComputerFeatures")
public class computerFeatures {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int compfeatureID;
    private String compFeatureName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="computerID")
    @JsonBackReference
    private Computer computerFeature;

    /***
     * getter for compfeatureID
     * @return compfeatureID
     */
    public int getCompfeatureID() {
        return compfeatureID;
    }

    /***
     * setter for compfeatureID
     * @param compfeatureID
     */
    public void setCompfeatureID(int compfeatureID) {
        this.compfeatureID = compfeatureID;
    }

    /***
     * getter for compFeatureName
     * @return compFeatureName
     */
    public String getCompFeatureName() {
        return compFeatureName;
    }

    /***
     * setter for compFeatureName
     * @param compFeatureName
     */
    public void setCompFeatureName(String compFeatureName) {
        this.compFeatureName = compFeatureName;
    }

    /***
     * getter for computerFeature
     * @return computerFeature
     */
    public Computer getComputerFeature() {
        return computerFeature;
    }

    /***
     * setter for computerFeature
     * @param computerFeature
     */
    public void setComputerFeature(Computer computerFeature) {
        this.computerFeature = computerFeature;
    }
}
