package com.pondicherry.zoo.dao.hibernate;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import com.pondicherry.zoo.dao.AnimalDao;
import com.pondicherry.zoo.domain.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("animalDao")
public class HibernateAnimalDao  implements AnimalDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Animal> findAll() {
        return  sessionFactory.getCurrentSession().createQuery("from Animal").list();
		
    }
}