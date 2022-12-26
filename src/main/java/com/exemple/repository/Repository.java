package com.exemple.repository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

public interface Repository<T> {
    T find(Long id);
    List<T> findAll();
    Long countAll();
    T save(T t);
    void delete(Long id);
}
