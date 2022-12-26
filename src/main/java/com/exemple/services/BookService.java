package com.exemple.services;

import com.exemple.model.Book;
import com.exemple.repository.BookRepository;
import com.exemple.utils.beans.interceptors.Loggeble;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;


@Transactional(SUPPORTS)
public class BookService {




    @Inject
    BookRepository repository;

/*
    @PostConstruct
    public void initService(){
        Book book = new Book();
        book.setTitle("from init service");
        book.setLanguage(EN);
        book.setDescription("bla bla bla");
        book.setPublicationDate(new Date());
        book.setImageURL("img.png");
        book.setUnitCost(32.22);
        repository.save(book);
    }*/

    public Book find(Long id){
        return repository.find(id);
    }
    public List<Book> findAll(){
        return repository.findAll();
    }


    public Long countAll(){
        return repository.countAll();
    }

    @Transactional(REQUIRED)

    public Book save(Book book){
        book =repository.save(book);
        return book;
    }
    @Transactional(REQUIRED)
    public void delete(Long id){
        repository.delete(id);
    }
}
