package com.lextersoft.cinefilo.controller;

import java.util.List;

public interface IBasicController<T, ID> {
    List<T> index(String search);
    T findById(ID id);
    void save(T data);
    void update(T data);
    void delete(T data);

}
