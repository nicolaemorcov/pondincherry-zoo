package com.pondicherry.zoo.dao;

import com.pondicherry.zoo.domain.Animal;

import java.util.List;

public interface AnimalDao {

    /**
     * Retrieve all the Animals for the database
     *
     * @return all the Animals
     */
    List<Animal> findAll();

}