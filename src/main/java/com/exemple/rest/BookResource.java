package com.exemple.rest;

import com.exemple.model.Book;
import com.exemple.services.BookService;
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
        if(bookList.size()==0) return Response.noContent().build();
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/count")
    public Response countAllBooks(){
        long count =service.countAll();
        if (count==0) return Response.noContent().build();
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
        URI createdURI = uriInfo.getBaseUriBuilder().path(book.getId().toString()).build();
        return Response.created(createdURI).build();
    }


    /*
    * Si vous avez besoin d’obtenir des informations sur le contexte d’exécution de la requête, vous pouvez utilisez l’annotation
    * @Context pour obtenir une instance d’une classe particulière. Les classes supportées sont :

            javax.ws.rs.core.UriInfo : Cette interface donne accès à l’URI de la requête.
            javax.ws.rs.core.Request : Cette interface fournit des méthodes utilitaires pour le traitement conditionnel de la requête.
            javax.ws.rs.core.HttpHeaders : Cette interface permet d’accéder à l’ensemble des en-têtes HTTP de la requête.
            javax.ws.rs.core.SecurityContext : Cette interface permet d’accéder aux informations de sécurité et d’authentification.
            javax.servlet.http.HttpServletRequest : La représentation de la requête avec l’API Servlet.
            javax.servlet.http.HttpServletResponse : La représentation de la réponse avec l’API Servlet.
            javax.servlet.ServletContext : Le contexte d’exécution des servlets.
            javax.servlet.ServletConfig : La configuration de la servlet traitant la requête.
    *
    *
    *
    * */

}