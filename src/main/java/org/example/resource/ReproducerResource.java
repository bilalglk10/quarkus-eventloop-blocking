package org.example.resource;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.example.Mapper;
import org.example.service.MyMapper;

@Path("/reproducer")
@RolesAllowed("admin")
public class ReproducerResource extends BaseResource<String, String> {

    @Inject
    protected MyMapper mapper;

    @POST
    @Path("/")
    @Override
    public Uni<String> create(String input) {
        return super.create(input);
    }

    @Override
    protected Mapper<String, String> creationMapper() {
        return mapper;
    }
}