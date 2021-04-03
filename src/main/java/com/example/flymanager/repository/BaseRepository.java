package com.example.flymanager.repository;

import com.example.flymanager.model.Ticket;

import java.util.List;

public interface BaseRepository<T, K> {
    List<T> getAll();

    T getById(K id);
}
