package com.sismics.docs.core.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Review entity
 * Includes the
 * - User Name
 * - Rating
 * - Review ID
 * - User ID
 * - Document ID
 * - Reviewer ID
 * - Creation Date
 * - Deletion Date
 * 
 * @author jessedin
 */
@Entity
@Table(name = "T_REVIEW")
public class Review implements Loggable{

    /**
     * User Name.
     */
    @Column(name = "REV_USERNAME_C", length = 36)
    private String userName;

    /**
     * Rating.
     */
    @Column(name = "REV_RATING_C")
    private Integer rating;

    /**
     * Review ID.
     */
    @Id
    @Column(name = "REV_REVIEWID_C", length = 36, nullable = false)
    private String reviewId;

    /**
     * User ID.
     */
    @Column(name = "REV_USERID_C", length = 36)
    private String userId;

    /**
     * Document ID.
     */
    @Column(name = "REV_DOCID_C", length = 36)
    private String docId;

    /**
     * Reviewer ID.
     */
    @Column(name = "REV_REVIEWERID_C", length = 36)
    private String reviewerId;

    /**
     * Creation date
     */
    @Column(name = "REV_CREATEDATE_D", nullable = false)
    private Date createDate;
   
    /**
     * Deletion date
     */
    @Column(name = "REV_DELETEDATE_D", nullable = false)
    private Date deleteDate;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerid) {
        this.reviewerId = reviewerid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toMessage() {
        return reviewId;
    }
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userName", userName)
                .add("rating", rating)
                .add("userId", userId)
                .add("reviewId", reviewId)
                .add("docId", docId)
                .add("reviewerId", reviewerId)
                .add("createDate", createDate)
                .add("deleteDate", deleteDate)
                .toString();
    }
}
