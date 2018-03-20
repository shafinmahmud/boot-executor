package com.shafin.bootexec.service;

import com.shafin.bootexec.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author shafin
 * @since 3/20/2018
 */
@Repository
public class BookService {

    @PersistenceContext
    private EntityManager em;

    public List<Book> getBooks() {
        return em.createQuery("From Book", Book.class).getResultList();
    }

    @Transactional
    public Book save(Book book) {
        if(book.getId() == 0) {
            em.persist(book);
        } else {
            book = em.merge(book);
        }

        return book;
    }
}
