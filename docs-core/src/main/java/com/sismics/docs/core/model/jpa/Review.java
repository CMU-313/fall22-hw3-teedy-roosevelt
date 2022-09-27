package com.sismics.docs.core.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Link between an user and a group.
 * 
 * @author jessedin
 */
@Entity
@Table(name = "T_REVIEW")
public class Review {

    /**
     * User ID.
     */
    @Id
    @Column(name = "REV_IDUSER_C", length = 36)
    private String userId;
    
    /**
     * Document ID.
     */
    @Column(name = "REV_IDDOC_C", length = 36)
    private String docId;

    /**
     * Rating.
     */
    @Column(name = "REV_RATING_C", length = 36)
    private Integer rating;

    /**
     * Reviewer ID.
     */
    @Column(name = "REV_IDREVIEWER_C", nullable = false, length = 36)
    private String reviewerId;

    /**
     * Creation date.
     */
    @Column(name = "REV_CREATEDATE_D", nullable = false)
    private Date createDate;
    
    public String getDocId() {
        return docId;
    }

    public void setDocId(String id) {
        this.docId = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String id) {
        this.reviewerId = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setReviewerId(Integer rat) {
        this.rating = rat;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userId", userId)
                .add("docId", docId)
                .add("reviewerId", reviewerId)
                .add("rating", rating)
                .add("createDate", createDate)
                .toString();
    }
}
