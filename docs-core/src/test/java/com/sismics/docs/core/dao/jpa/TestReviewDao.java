package com.sismics.docs.core.dao.jpa;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.ReviewDao;
import com.sismics.docs.core.dao.dto.ReviewAggDto;
import org.junit.Assert;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class TestReviewDao extends BaseTransactionalTest {
    /** Logger. */
    private static final Logger log = LoggerFactory.getLogger(TestReviewDao.class);

    @Test
    public void testReviewDao() throws Exception {
        // Create 4 new reviews for 3 documents and 2 users
        ReviewDao reviewDao = new ReviewDao();
        reviewDao.create("1", "alice", "DocA", "RevA", 90);
        reviewDao.create("1", "alice", "DocB", "RevB", 91);
        reviewDao.create("2", "chris", "DocC", "RevA", 80);
        reviewDao.create("1", "alice", "DocA", "RevB", 93);

        // Verify that the lookup query contains the correct averages for these
        // three distinct entries
        Boolean found1 = false;
        Boolean found2 = false;
        Boolean found3 = false;
        List<ReviewAggDto> userAppAverageScores = reviewDao.getAverageScorePerApplication();
        for (ReviewAggDto userAppAverageScore : userAppAverageScores) {
            if (userAppAverageScore.getUsername() == "alice" && userAppAverageScore.getDocId() == "DocA") {
                found1 = true;
                Assert.assertEquals(91.5, userAppAverageScore.getAvgRating(), 0.1);
            } else if (userAppAverageScore.getUsername() == "alice" && userAppAverageScore.getDocId() == "DocB") {
                found2 = true;
                Assert.assertEquals(91, userAppAverageScore.getAvgRating(), 0.1);
            } else if (userAppAverageScore.getUsername() == "chris" && userAppAverageScore.getDocId() == "DocC") {
                found3 = true;
                Assert.assertEquals(80, userAppAverageScore.getAvgRating(), 0.1);
            }
        }
        Assert.assertTrue(found1);
        Assert.assertTrue(found2);
        Assert.assertTrue(found3);
    }
}
