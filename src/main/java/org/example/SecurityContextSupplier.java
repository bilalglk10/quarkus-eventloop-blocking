package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.Set;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;

/**
 * Security context provider service
 */
@ApplicationScoped
public class SecurityContextSupplier implements Supplier<SecurityContext> {

    @Override
    public SecurityContext get() {

        String fakeUserId = "fake-user-id";
        Set<String> roles = Set.of("admin");

        return new CustomSecurityContext(fakeUserId, roles);
    }

    @RequiredArgsConstructor
    private static final class CustomSecurityContext implements SecurityContext {

        private final String id;

        private final Set<String> roles;

        @Override
        public Principal getUserPrincipal() {
            return () -> id;
        }

        @Override
        public boolean isUserInRole(final String role) {
            return roles.contains(role);
        }

        @Override
        public boolean isSecure() {
            return true;
        }

        @Override
        public String getAuthenticationScheme() {
            return "Bearer";
        }
    }
}
