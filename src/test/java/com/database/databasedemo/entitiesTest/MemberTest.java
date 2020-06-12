package com.database.databasedemo.entitiesTest;

import com.database.databasedemo.Repositories.MemberJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@Transactional
public class MemberTest {


    @Autowired
    MemberJpaRepository memberJpaRepository;

    /**
     * This test is written to verify the number of members saved in our database
     */
    @Test
    void anzahlMember() {

        assertEquals(2, memberJpaRepository.findAll().size());
    }
}
