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
        Assert.assertEquals(4, json.getJsonArray("ratings").size());

        // Assert correct entries from 'dbupdate-028-0.sql
        JsonObject entry0 = json.getJsonArray("ratings").getJsonObject(0);
        Assert.assertEquals("Florentino Perez", entry0.getString(username));
        Assert.assertEquals("doc15", entry0.getString(docId));
        Assert.assertEquals(15, entry0.getInt(averageRating));

        JsonObject entry1 = json.getJsonArray("ratings").getJsonObject(1);
        Assert.assertEquals("Leo Messi", entry1.getString(username));
        Assert.assertEquals("doc10", entry1.getString(docId));
        Assert.assertEquals(10, entry1.getInt(averageRating));

        JsonObject entry2 = json.getJsonArray("ratings").getJsonObject(2);
        Assert.assertEquals("Cristiano Ronaldo", entry2.getString(username));
        Assert.assertEquals("doc7", entry2.getString(docId));
        Assert.assertEquals(7, entry2.getInt(averageRating));

        JsonObject entry3 = json.getJsonArray("ratings").getJsonObject(3);
        Assert.assertEquals("John Doe", entry3.getString(username));
        Assert.assertEquals("doc5", entry3.getString(docId));
        Assert.assertEquals(5, entry3.getInt(averageRating));
    }
}