package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.Mapper;

@ApplicationScoped
public class MyMapper implements Mapper<String, String> {
    @Override
    public String map(String s) {
        return s.toUpperCase();
    }

    @Override
    public String unmap(String s) {
        return s.toLowerCase();
    }

}