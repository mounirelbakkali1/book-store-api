package com.exemple.rest;

import com.exemple.model.Book;
import com.exemple.services.BookService;
import com.exemple.utils.beans.interceptors.Loggeble;
import io.swagger.annotations.*;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/books")
@Api(value = "/Book")
@SwaggerDefinition(
        info = @Info(
                title = "My API",
                version = "1.0.0",
                description = "API for my application"
        )
)
@Loggeble
public class BookResource {

    @Inject
    BookService service;

    @GET
    @Produces(APPLICATION_JSON)
   /* @ApiOperation(value = "returns list of books")
    @ApiResponses({
            @ApiResponse(code=204 , message = "no book found"),
            @ApiResponse(code=200,message = "Book Found")
    })*/
    public Response getBooks(){
        List<Book> bookList = service.findAll();
        //if(bookList.size()==0) return Response.noContent().build();
        return Response.ok(bookList).build();
    }

    @GET
    @Path("/count")
    public Response countAllBooks(){
        long count =service.countAll();
        //if (count==0) return Response.noContent().build();
        return Response.ok(service.countAll()).build();
    }


    @DELETE
    @Path("/{id:\\d+}")
    public Response deleteBook(@PathParam("id") @Min(1) long id){
        service.delete(id);
        return Response.noContent().build();
    }



    @GET
    @Path("/{id:\\d+}")
    @Produces(APPLICATION_JSON)
    @ApiOperation(value = "returns a book by given ID",response = Book.class,produces = APPLICATION_JSON)
    @ApiResponses({
            @ApiResponse(code=204 , message = "no book found by given identifier"),
            @ApiResponse(code=200,message = "Book Found")
    })
    public Response getBook(@PathParam("id") @Min(1) long id){
        Book book = service.find(id);
        if(book==null)return Response.noContent().build();
        return Response.ok(book).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response createBook(Book book, @Context UriInfo uriInfo){
        book = service.save(book);
        //System.out.println(book);
        //URI createdURI = uriInfo.getBaseUriBuilder().path(book.getId().toString()).build();
        //return Response.created(createdURI).build();
        return Response.status(Response.Status.CREATED).build();
    }


    /*
    * Si vous avez besoin d???obtenir des informations sur le contexte d???ex??cution de la requ??te, vous pouvez utilisez l???annotation
    * @Context pour obtenir une instance d???une classe particuli??re. Les classes support??es sont :

            javax.ws.rs.core.UriInfo : Cette interface donne acc??s ?? l???URI de la requ??te.
            javax.ws.rs.core.Request : Cette interface fournit des m??thodes utilitaires pour le traitement conditionnel de la requ??te.
            javax.ws.rs.core.HttpHeaders : Cette interface permet d???acc??der ?? l???ensemble des en-t??tes HTTP de la requ??te.
            javax.ws.rs.core.SecurityContext : Cette interface permet d???acc??der aux informations de s??curit?? et d???authentification.
            javax.servlet.http.HttpServletRequest : La repr??sentation de la requ??te avec l???API Servlet.
            javax.servlet.http.HttpServletResponse : La repr??sentation de la r??ponse avec l???API Servlet.
            javax.servlet.ServletContext : Le contexte d???ex??cution des servlets.
            javax.servlet.ServletConfig : La configuration de la servlet traitant la requ??te.
    *
    *
    *
    * */

}