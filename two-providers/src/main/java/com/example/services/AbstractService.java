package com.example.services;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public class AbstractService<T> {

    protected CrudRepository mainRepository;

    public AbstractService(CrudRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public T create(T entity){
        return (T) this.mainRepository.save(entity);
    }

    public T update(T entity) {
        throw new UnsupportedOperationException("Method not implemented for the current type");
    }

    public void delete(Long entityId){
        this.mainRepository.deleteById(entityId);
    }

    public T get(Long entityId){
        return (T) (this.mainRepository.findById(entityId).get());
    }

    public ArrayList<T> findAll(){ return (ArrayList<T>) this.mainRepository.findAll(); }
}
