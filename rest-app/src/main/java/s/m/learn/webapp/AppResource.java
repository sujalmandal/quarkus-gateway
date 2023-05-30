package s.m.learn.webapp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1")
public class AppResource {
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String serve() {
        return "hello from rest-app";
    }
}
