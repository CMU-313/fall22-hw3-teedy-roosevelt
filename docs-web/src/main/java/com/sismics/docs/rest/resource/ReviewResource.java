package com.sismics.docs.rest.resource;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import com.sismics.docs.core.dao.ReviewDao;
import com.sismics.docs.core.dao.dto.ReviewAggDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Reviews the ratings data for users and documents.
 *
 * @author aruiz2
 */
@Path("/user_rating")
public class ReviewResource extends BaseResource {

    /*
    getUserDocScoreEntries() gets the userID, docID, score for every application and returns it in a json format.
     */
    @GET
    public Response getUserDocScoreEntries() {
        ReviewDao reviewDao = new ReviewDao();
        JsonArrayBuilder ratings = Json.createArrayBuilder();
        List<ReviewAggDto> userDocAverageRating = reviewDao.getAverageScorePerApplication();
        for (ReviewAggDto data : userDocAverageRating) {
            ratings.add(Json.createObjectBuilder()
                    .add("username", data.getUsername())
                    .add("docId", data.getDocId())
                    .add(   "avgRating", data.getAvgRating()));
        }
        JsonObjectBuilder response = Json.createObjectBuilder()
                .add("ratings", ratings);
        return Response.ok().entity(response.build()).build();
    }
}