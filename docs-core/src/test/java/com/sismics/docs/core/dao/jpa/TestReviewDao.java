package com.sismics.docs.core.dao.jpa;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.ReviewDao;
import com.sismics.docs.core.model.jpa.Review;
import com.sismics.docs.core.util.TransactionUtil;
import com.sismics.docs.core.dao.dto.ReviewAggDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestReviewDao extends BaseTransactionalTest {
    @Test
    public void testReviewDao() throws Exception {
        // Create 4 new reviews for 3 documents and 2 users
        ReviewDao reviewDao = new ReviewDao();
        reviewDao.create("1", "alice", "DocA", "RevA", 90);
        reviewDao.create("1", "alice", "DocB", "RevB", 91);
        reviewDao.create("2", "chris", "DocC", "RevA", 80);
        reviewDao.create("1", "alice", "DocA", "RevB", 93);

        // Verify that the lookup query contains these three in there
        Boolean found1 = false;
        Boolean found2 = false;
        Boolean found3 = false;
        List<ReviewAggDto> output = reviewDao.getAverageScorePerApplication();
        for (ReviewAggDto res : output) {
            if (res.getUsername() == "alice" && res.getDocId() == "DocA") {
                found1 = true;
                Assert.assertEquals(91.5, res.getAvgRating());
            } else if (res.getUsername() == "alice" && res.getDocId() == "DocB") {
                found2 = true;
                Assert.assertEquals(91, res.getAvgRating());
            } else if (res.getUsername() == "chris" && res.getDocId() == "DocC") {
                found3 = true;
                Assert.assertEquals(80, res.getAvgRating());
            }
        }

        Assert.assertTrue(found1);
        Assert.assertTrue(found2);
        Assert.assertTrue(found3);
    }
}
