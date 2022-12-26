package com.exemple.rest;


import com.exemple.model.Author;
import com.exemple.repository.AuthorRespository;
import com.exemple.repository.UserRespository;
import com.exemple.utils.beans.interceptors.Loggeble;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static jakarta.transaction.Transactional.TxType.REQUIRED;

@Path("/authors")
@Loggeble
public class AthorsRessource {

    @Inject
    AuthorRespository respository;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAthors(){
       return Response.ok(respository.findAll()).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional(REQUIRED)
    public Response persistAuthor(Author author , @Context UriInfo uriInfo){
        author = respository.save(author);
        URI createdURI = uriInfo.getBaseUriBuilder().path(author.getId().toString()).build();
        return Response.created(createdURI).build();
    }
}
