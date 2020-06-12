package com.database.databasedemo.Repositories;

import com.database.databasedemo.Entity.LendingBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LendingBookJpaRepository extends JpaRepository<LendingBook, Integer> {

    @Override
    List<LendingBook> findAll();

    @Override
    Optional<LendingBook> findById(Integer integer);

    @Query(nativeQuery = true, value = "select * from Lending_Book l where l.member_id = ?1")
    List<Object[]> findLendingBookByMemberId(Integer member_id);

    //LocalDate dayAfterTomorrow = LocalDate.now().plusDays(2);

    @Query(nativeQuery = true, value = "select * from Lending_Book l where cast(l.loan_end as date) = ?1")
    List<Object[]>expireLendindBooksInNDays(LocalDate dayAfterTomorrow);



}
