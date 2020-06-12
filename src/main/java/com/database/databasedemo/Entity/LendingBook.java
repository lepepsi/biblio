package com.database.databasedemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class LendingBook {


    @Id
    @GeneratedValue
    @NonNull
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Book book;

    @ManyToOne
    private Member member;

    @Column
    private Instant loanStart;

    @Column
    private Instant loanEnd;


}
