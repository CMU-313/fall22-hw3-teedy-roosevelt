package com.sismics.docs.rest;

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
        JsonObject json = target().path("/user_rating").request()
                .cookie(TokenBasedSecurityFilter.COOKIE_NAME, adminToken)
                .get(JsonObject.class);

        // Assert correct data from 'dbupdate-028-0.sql
        Assert.assertEquals(2, json.getJsonArray("ratings").size());
        JsonObject entry1 = json.getJsonArray("ratings").getJsonObject(1);
        Assert.assertEquals("John Doe", entry1.getString(username));
        Assert.assertEquals("doc123", entry1.getString(docId));
        Assert.assertEquals(5, entry1.getInt(averageRating));

        JsonObject entry2 = json.getJsonArray("ratings").getJsonObject(0);
        Assert.assertEquals("Florentino Perez", entry2.getString(username));
        Assert.assertEquals("doc1234", entry2.getString(docId));
        Assert.assertEquals(10, entry2.getInt(averageRating));
    }
}