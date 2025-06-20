package org.example;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

@ApplicationScoped
public class ContextFilter {

    @Inject
    protected SecurityIdentity securityIdentity;

    @Inject
    protected SecurityContextSupplier securityContextSupplier;

    @ServerRequestFilter(priority = Priorities.AUTHORIZATION + 1, preMatching = true)
    public Uni<RestResponse<?>> filter(final ContainerRequestContext reqContext) {
        if (securityIdentity.isAnonymous()) {
            return Uni.createFrom().item(RestResponse.status(Response.Status.UNAUTHORIZED));
        }
        reqContext.setSecurityContext(securityContextSupplier.get());
        return Uni.createFrom().nullItem();
    }
}
