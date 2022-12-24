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
public class BookRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book-Store-Persistence-Unit");
    EntityManager em = emf.createEntityManager();


    @Inject @EIGHTGENERATOR
    Generator generator;

    @Inject
    TextUtils utils;

    public Book find(@Min(value = 1,message = "ID of book to retreieve shouldn't be less than 1") @NotNull Long id){
        return em.find(Book.class,id);
    }
    public List<Book> findAll(){
        return em.createQuery("select b from Book b order by b.id").getResultList();
    }


    public Long countAll(){
        return (Long) em.createQuery("SELECT COUNT(b) from Book b").getSingleResult();
    }





    @Transactional(REQUIRED)
    public Book save(@NotNull(message = "the instance of the object to persist should't be null") Book book){
        book.setIsbn(generator.generateISBN());
        book.setDescription(utils.sanitize(book.getDescription()));
        em.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull(message = "the id of the book to be deleted could't be null") Long id){
        em.remove(em.getReference(Book.class,id));
    }
}
