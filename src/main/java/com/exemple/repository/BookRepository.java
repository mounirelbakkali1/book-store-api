package com.exemple.repository;

import com.exemple.model.Book;
import com.exemple.utils.Generator;
import com.exemple.utils.TextUtils;
import com.exemple.utils.beans.EIGHTGENERATOR;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;


@Transactional(SUPPORTS)
public class BookRepository implements Repository<Book> {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book-Store-Persistence-Unit");
    EntityManager em = emf.createEntityManager();


    @Inject @EIGHTGENERATOR
    Generator generator;

    @Inject
    TextUtils utils;

    @Override
    public Book find(Long id){
        return em.find(Book.class,id);
    }
    @Override

    public List<Book> findAll(){
        return em.createQuery("select b from Book b order by b.id").getResultList();
    }


    @Override
    public Long countAll(){
        return (Long) em.createQuery("SELECT COUNT(b) from Book b").getSingleResult();
    }


    @Override
    public Book save(Book book){
        book.setIsbn(generator.generateISBN());
        book.setDescription(utils.sanitize(book.getDescription()));
        em.persist(book);
        return book;
    }

    @Override
    public void delete(Long id){
        em.remove(em.getReference(Book.class,id));
    }
}
