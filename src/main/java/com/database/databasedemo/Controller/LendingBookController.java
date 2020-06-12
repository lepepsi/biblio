package com.database.databasedemo.Controller;


import com.database.databasedemo.Entity.Book;
import com.database.databasedemo.Entity.LendingBook;
import com.database.databasedemo.Entity.Member;
import com.database.databasedemo.Repositories.LendingBookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/api")
public class LendingBookController {

    private LendingBookJpaRepository lendingBookJpaRepository;

    Book book1 = new Book();
    Member member1 = new Member();

    @Autowired
    public void lendingBookJpaRepository(LendingBookJpaRepository lendingBookJpaRepository) {
        this.lendingBookJpaRepository = lendingBookJpaRepository;
    }

    @RequestMapping(value = "/listLendingBooks", method = GET, produces = "application/json")
    @ResponseBody
    public List<LendingBook> getAllLendingBook() {
        return lendingBookJpaRepository.findAll();
    }

    @RequestMapping(value = "/listLendingBooks/{id}", method = GET)
    @ResponseBody
    public Map<Member, List<LendingBook>> getLendingBookByMemberId(
            @PathVariable Integer id) {

        LendingBook lendingbook = new LendingBook();

        List<LendingBook> lendingBook = lendingBookJpaRepository.findLendingBookByMemberId(id)
                .stream().map(result -> convertObject(result))
                .collect(Collectors.toList());

        Map<Member, List<LendingBook>> lendingsWithMap = lendingBook
                .stream()
                .collect(Collectors.groupingBy(LendingBook::getMember));


        return lendingsWithMap;
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
