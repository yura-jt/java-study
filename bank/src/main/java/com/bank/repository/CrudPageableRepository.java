package com.bank.repository;

import com.bank.repository.impl.Pageable;

import java.util.Collections;
import java.util.List;

public interface CrudPageableRepository<E> extends CrudRepository<E> {

    List<E> findAll();

    Pageable<E> findAll(Page page);

    long count();
}