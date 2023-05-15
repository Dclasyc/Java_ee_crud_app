package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import model.Footballers;
import repository.FootballersRepository;

import java.util.List;

@Path("footballers")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FotballersController {

    @Inject FootballersRepository footballersRepository;

    @GET
    public List<Footballers> getAll() {
        return footballersRepository.findAll();
    }

    @POST
    public Response create(Footballers footballer) {
        footballersRepository.createFootballers(footballer);
        return Response.status(201).build();
    }

    @PUT
    public Response update(Footballers footballers ) {
        footballersRepository.updateFootballers (null, null, null, null);
        return Response.status(204).build();
    }
    @DELETE
    public Response delete(@QueryParam("id") Long footballerId) {
        footballersRepository.deleteFootballer(footballerId);
        return Response.status(204).build();
    }

}