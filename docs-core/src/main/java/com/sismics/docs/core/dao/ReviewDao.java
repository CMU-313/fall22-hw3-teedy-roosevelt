package com.sismics.docs.core.dao;

import com.sismics.docs.core.constant.AuditLogType;
import com.sismics.docs.core.dao.dto.ReviewAggDto;
import com.sismics.docs.core.model.jpa.Review;
import com.sismics.docs.core.util.AuditLogUtil;
import com.sismics.util.context.ThreadLocalContext;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class ReviewDao {
    /** Logger. */
    private static final Logger log = LoggerFactory.getLogger(ReviewDao.class);

    /**
     * Logs a new review
     *
     * @param userId ID of the user being reviewed
     * @param username Name of the user being reviewed
     * @param documentId ID of the user being reviewed
     * @param reviewerId ID of the user reviewing the document
     * @param rating Score that the document received
     */
    public void create(
        String userId, String username, String documentId, String reviewerId, Integer rating)
        {
        // Make a new review object and give it a random ID
        Review review = new Review();
        String reviewId = UUID.randomUUID().toString();
        review.setReviewId(reviewId);

        // Populate hte other fields
        review.setUserId(userId);
        review.setUserName(username);
        review.setDocId(documentId);
        review.setReviewerId(reviewerId);
        review.setRating(rating);
        review.setCreateDate(new java.util.Date());

        // Add the review to the database
        EntityManager em = ThreadLocalContext.get().getEntityManager();
        em.persist(review);

        // Create audit log
        AuditLogUtil.create(review, AuditLogType.CREATE, reviewId);
    }

    /**
     * Outputs a list of triplets in the form (Name, DocumentId, Avg Score)
     * which contains the average review score for all user/document combinations.
     */
    public List<ReviewAggDto> getAverageScorePerApplication() {
        List<ReviewAggDto> result = new ArrayList<ReviewAggDto>();
        EntityManager em = ThreadLocalContext.get().getEntityManager();
        Query q = em.createQuery("select r.userName, r.docId, AVG(CAST(r.rating as double)) from Review r group by r.userName, r.docId");
        List<Object[]> l = q.getResultList();
        for (Object[] o : l) {
            int i = 0;
            ReviewAggDto data = new ReviewAggDto();
            String username = (String) o[i++];
            String docId = (String) o[i++];
            double avgRating = ((double) o[i++]);
            data.setUsername(username);
            data.setDocId(docId);
            data.setAvgRating(avgRating);
            result.add(data);
        }
        return result;
    }
}