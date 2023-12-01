package org.example.repository;

import java.util.List;

public interface IBaseRepository<T> {
    public void create(T t);

    //public List<T> getAll(T t);


    public void delete(T t);

    public void update(T t);

    public T getByName(String name);
}

