package com.exemple.repository;

import com.exemple.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserRespository implements Repository<User> {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book-Store-Persistence-Unit");
    EntityManager em = emf.createEntityManager();

    public User find(Long id){
        return em.find(User.class,id);
    }
    public List<User> findAll(){
        return em.createQuery("select b from User b order by b.id").getResultList();
    }
    public Long countAll(){
        return (Long) em.createQuery("SELECT COUNT(b) from User b").getSingleResult();
    }

    public User save(User user){
        em.persist(user);
        return user;
    }

    public void delete(Long id){
        em.remove(em.getReference(User.class,id));
    }
}
