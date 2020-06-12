package com.database.databasedemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {


    @Id
   @NonNull
    private Integer id;

    @Column
    private String titel;

    @Column
    private String isbn;

    @Column
    private Integer numberInStock;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<LendingBook> lendingBooks = new ArrayList<>();

    public void addLendingBooks(LendingBook lendingBook){
        this.lendingBooks.add(lendingBook);
    }

    public void removeLendingBooks(LendingBook lendingBook){
        this.lendingBooks.remove(lendingBook);
    }


}
