package com.team14.WebService.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ComputerComments")
public class computerComments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int computerCommentId;

    private String computerComment;
    private String computerRating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="computerID")
    @JsonBackReference
    private Computer computerComments;

    /**
     * Getter for computer comment id
     * @return id of computer comment
     */
    public int getComputerCommentId() {
        return computerCommentId;
    }

    public void setComputerCommentId(int computerCommentId) {
        this.computerCommentId = computerCommentId;
    }

    /**
     * Getter for computer comment
     * @return comment of computer comment
     */
    public String getComputerComment() {
        return computerComment;
    }

    public void setComputerComment(String computerComment) {
        this.computerComment = computerComment;
    }

    /**
     * Getter for computer rating
     * @return id of computer rating
     */
    public String getComputerRating() {
        return computerRating;
    }

    public void setComputerRating(String computerRating) {
        this.computerRating = computerRating;
    }

    /**
     * Getter for computer comments
     * @return comments of computer comment
     */
    public Computer getComputerComments() {
        return computerComments;
    }

    public void setComputerComments(Computer computerComments) {
        this.computerComments = computerComments;
    }
}


