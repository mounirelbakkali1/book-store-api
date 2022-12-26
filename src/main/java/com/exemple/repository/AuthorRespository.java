package com.exemple.repository;

import com.exemple.model.Author;
import com.exemple.model.User;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class AuthorRespository implements Repository<Author>{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book-Store-Persistence-Unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public Author find(Long id) {
        return em.find(Author.class,id);
    }

    @Override
    public List<Author> findAll() {
        return em.createQuery("select au from Author au order by au.id").getResultList();
    }

    @Override
    public Long countAll() {
        return (Long) em.createQuery("SELECT COUNT(au) from Author au").getSingleResult();
    }

    @Override
    public Author save(Author author) {
        em.persist(author);
        return author;
    }

    @Override
    public void delete(Long id) {
        em.remove(em.getReference(User.class,id));
    }
}
