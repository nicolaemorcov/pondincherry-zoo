package com.pondicherry.zoo.service.support;

import com.pondicherry.zoo.dao.AnimalDao;
import com.pondicherry.zoo.domain.Animal;
import com.pondicherry.zoo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private AnimalDao animalDao;
    
    @Autowired
    public AnimalServiceImpl(AnimalDao ad) {
    	this.animalDao =ad;
    }

    public List<Animal> getAllAnimals() {
        return animalDao.findAll();
    }

    @Autowired
    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }
}
