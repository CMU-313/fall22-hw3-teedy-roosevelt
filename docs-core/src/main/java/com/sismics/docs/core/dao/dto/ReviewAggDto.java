package com.sismics.docs.core.dao.dto;

/*
 * Data Transfer Object to pass around information about the average review
 * score for a certain (username, docId) combination.
 */
public class ReviewAggDto {

    /**
     * User Name.
     */
    private String username;

    /**
     * Document ID.
     */
    private String docId;
    
    /**
     * Average Rating.
     */
    private double avgRating;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
