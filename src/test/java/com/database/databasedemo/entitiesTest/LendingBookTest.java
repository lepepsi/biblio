package com.database.databasedemo.entitiesTest;

import com.database.databasedemo.Entity.Book;
import com.database.databasedemo.Entity.LendingBook;
import com.database.databasedemo.Entity.Member;
import com.database.databasedemo.Repositories.LendingBookJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional
public class LendingBookTest {

    @Autowired
    private LendingBookJpaRepository lendingBookJpaRepository;

    Book book1 = new Book();
    Member member1 = new Member();
    LendingBook lendingbook = new LendingBook();

    /**
     * This test is written in order to obtain the list of books lent by giving the MemberId.
     */
    @Test
    void loanByMember() {

        Book book1 = new Book();
        Member member1 = new Member();
        LendingBook lendingbook = new LendingBook();

        List<LendingBook> lendingBook = lendingBookJpaRepository.findLendingBookByMemberId(1001)
                .stream().map(result -> convertObject(result))
                .collect(Collectors.toList());


        assertEquals(1000, lendingBook.get(0).getId());

        assertEquals(1001, lendingBook.get(1).getId());


/**
 * We want to obtain a Map Collection whose key is the MemberId and the value is a list of LendingBook.
 */
        Map<Member, List<LendingBook>> lendingsWithMap = lendingBook
                .stream()
                .collect(Collectors.groupingBy(LendingBook::getMember));

        lendingsWithMap.size();
    }

    /**
     * The list of books that will expire in "n" days.
     */
    @Test
    void listOfExpiredLendingBooksInNDays() {

        LocalDate dayAfterTomorrow = LocalDate.now().plusDays(2);

        List<LendingBook> lendingBooks = lendingBookJpaRepository.expireLendindBooksInNDays(dayAfterTomorrow)
                .stream().map(result -> convertObject(result))
                .collect(Collectors.toList());

        lendingBooks.size();

        assertEquals(1002, lendingBooks.get(0).getMember().getId());
    }

    /**
     * This method allows me to convert an element of type Object coming from the database into a LendingBook type.
     *
     * @param objet
     * @return
     */
    private LendingBook convertObject(Object[] objet) {

        LendingBook lendingbook = new LendingBook();

        int lendingBook_id = (int) objet[0];
        Timestamp loanEnd1 = (Timestamp) objet[1];
        Timestamp loanStart1 = (Timestamp) objet[2];
        book1.setId((int) objet[3]);
        member1.setId((int) objet[4]);


        lendingbook.setId(lendingBook_id);
        lendingbook.setBook(book1);
        lendingbook.setMember(member1);
        lendingbook.setLoanStart(loanStart1.toInstant());
        lendingbook.setLoanEnd(loanEnd1.toInstant());


        return lendingbook;

    }
}
