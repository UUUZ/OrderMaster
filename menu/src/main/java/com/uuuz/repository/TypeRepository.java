package com.uuuz.repository;

import com.uuuz.entity.Type;

import java.util.List;

public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAll();
}
