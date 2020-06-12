package com.database.databasedemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {


    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private Instant birthdate;

    @Column
    private String email;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<LendingBook> lendingBooks = new ArrayList<>();

    public void addLendingBooks(LendingBook lendingBook){
        this.lendingBooks.add(lendingBook);
    }

    public void removeLendingBooks(LendingBook lendingBook){
        this.lendingBooks.remove(lendingBook);
    }


}
