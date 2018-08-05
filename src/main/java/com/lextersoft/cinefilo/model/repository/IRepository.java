package com.lextersoft.cinefilo.model.repository;

import java.util.List;

public interface IRepository<T, ID> {
    T findById(ID id);
    List<T> getAll();
    List<T> getByName(String name);
    void save(T data);
    void update( T data);
    void delete (T data);
}
