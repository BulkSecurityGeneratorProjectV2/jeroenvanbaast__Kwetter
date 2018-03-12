/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.ProfileService;

/**
 *
 * @author Jeroen
 */
@Path("profiles")
@Stateless
public class ProfileResource {

    @Inject
    private ProfileService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAll() {
        return service.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getStudent(@PathParam("id") long id) {
        Profile profile = service.getById(id);
        return profile;
    }
}