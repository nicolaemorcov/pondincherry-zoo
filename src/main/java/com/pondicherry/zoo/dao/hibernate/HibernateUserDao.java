package com.pondicherry.zoo.dao.hibernate;

import com.pondicherry.zoo.dao.UserDao;
import com.pondicherry.zoo.domain.User;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

@Repository("userDao")
public class HibernateUserDao implements UserDao {

	@SuppressWarnings("restriction")
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

//	@Transactional
    public void save(User user) {
    	sessionFactory.getCurrentSession().save(user);
    }

    public User find(String username, String password) {
        List<User> user =  sessionFactory.getCurrentSession()
        								.createQuery("FROM User WHERE username = ? AND password = ?")
        								.list();
        if (user.size() == 1) {
            return user.get(0);
        }
        return null;
    }

    public boolean exists(String username) {
        return sessionFactory.getCurrentSession()
        		.createQuery("FROM User WHERE username = ?")
        		.list()
        		.size() == 1;
    }
}
