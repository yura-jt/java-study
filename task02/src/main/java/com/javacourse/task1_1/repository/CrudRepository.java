package com.javacourse.task1_1.repository;

import java.util.List;

public interface CrudRepository<E> {
    void save(E entity);

    E findById(Integer id);

    List<E> findAll();

    void update(E entity);

    void deleteById(Integer id);
}