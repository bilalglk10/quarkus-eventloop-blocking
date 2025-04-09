package org.example.resource;

import io.smallrye.mutiny.Uni;
import org.example.Mapper;

public abstract class BaseResource<E, C>  {

    public Uni<E> create(C input) {
        return Uni.createFrom().item(() -> creationMapper().map(input));
    }

    protected abstract Mapper<C, E> creationMapper();
}