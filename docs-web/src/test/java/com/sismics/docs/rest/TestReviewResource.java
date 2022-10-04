package com.sismics.docs.rest;

import com.sismics.docs.core.dao.ReviewDao;
import com.sismics.util.filter.TokenBasedSecurityFilter;
import org.junit.Assert;
import org.junit.Test;

import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests the ReviewResource.java file
 *
 * @author aruiz2
 */

public class TestReviewResource extends BaseJerseyTest {
    private static final Logger log = LoggerFactory.getLogger(TestReviewResource.class);

    /**
     * Tests ReviewResource.java
     */
    @Test
    public void testReviewResource() {
        // Login admin
        String adminToken = clientUtil.login("admin", "admin", false);
        String username = "username";
        String docId = "docId";
        String averageRating = "avgRating";

        // Call user_rating API
        JsonObject json = target().path("/user_rating").request()
                .cookie(TokenBasedSecurityFilter.COOKIE_NAME, adminToken)
                .get(JsonObject.class);

        // Assert correct entries from 'dbupdate-028-0.sql
        log.info(json.getJsonArray("ratings").toString());
        JsonObject entry0 = json.getJsonArray("ratings").getJsonObject(0);
        Assert.assertEquals("Florentino Perez", entry0.getString(username));
        Assert.assertEquals("doc15", entry0.getString(docId));
        Assert.assertEquals(200, entry0.getInt(averageRating));

        JsonObject entry1 = json.getJsonArray("ratings").getJsonObject(1);
        Assert.assertEquals("Leo Messi", entry1.getString(username));
        Assert.assertEquals("doc10", entry1.getString(docId));
        Assert.assertEquals(150, entry1.getInt(averageRating));

        JsonObject entry2 = json.getJsonArray("ratings").getJsonObject(2);
        Assert.assertEquals("Cristiano Ronaldo", entry2.getString(username));
        Assert.assertEquals("doc7", entry2.getString(docId));
        Assert.assertEquals(125, entry2.getInt(averageRating));
    }
}