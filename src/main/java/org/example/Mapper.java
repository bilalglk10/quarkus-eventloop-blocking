package org.example;

public interface Mapper<T, U> {
    U map(T input);
    T unmap(U input);
}