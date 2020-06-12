package com.database.databasedemo.Repositories;

import com.database.databasedemo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {


    List<Book> findAll();

    Book saveAndFlush(BookJpaRepository buch);
}
