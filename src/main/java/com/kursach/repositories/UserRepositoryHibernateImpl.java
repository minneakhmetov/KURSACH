package com.kursach.repositories;

import com.kursach.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;


import javax.persistence.*;
import javax.transaction.Transactional;


@Component
public class UserRepositoryHibernateImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    @Modifying
    public void create(User user) {
        Query query = em.createNativeQuery("insert into user_table(name, surname, vk_id, photo_url ) values (?, ?, ?, ?);");
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurname());
        query.setParameter(3, user.getVkId());
        query.setParameter(4, user.getPhotoURL());
        em.getTransaction().commit();
    }

    @Override
    public User readOne(Integer id) {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id =:id", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

    }
}
