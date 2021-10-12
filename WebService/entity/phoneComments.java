package com.team14.WebService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phoneComments")
public class phoneComments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int phoneCommentId;

    private String phoneCommentName;
    private String phoneRating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="phone_id")
    @JsonBackReference
    private Phone phoneComments;

    /***
     * getter for phoneCommentId
     * @return phoneCommentId
     */
    public int getPhoneCommentId() {
        return phoneCommentId;
    }

    /***
     * setter for phoneCommentId
     * @param phoneCommentId
     */
    public void setPhoneCommentId(int phoneCommentId) {
        this.phoneCommentId = phoneCommentId;
    }

    /***
     * getter for phoneCommentName
     * @return phoneCommentName
     */
    public String getPhoneCommentName() {
        return phoneCommentName;
    }

    /***
     * setter for phoneCommentName
     * @param phoneCommentName
     */
    public void setPhoneCommentName(String phoneCommentName) {
        this.phoneCommentName = phoneCommentName;
    }

    /***
     * getter phoneRating
     * @return phoneRating
     */
    public String getPhoneRating() {
        return phoneRating;
    }

    /***
     * setter for phoneRating
     * @param phoneRating
     */
    public void setPhoneRating(String phoneRating) {
        this.phoneRating = phoneRating;
    }

    /***
     * getter for phoneComments
     * @return phoneComments
     */
    public Phone getPhoneComments() {
        return phoneComments;
    }

    /***
     * setter for phoneComments
     * @param phoneComments
     */
    public void setPhoneComments(Phone phoneComments) {
        this.phoneComments = phoneComments;
    }


}
