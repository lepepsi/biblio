package com.database.databasedemo;

import com.database.databasedemo.Repositories.BookJpaRepository;
import com.database.databasedemo.Repositories.MemberJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
class DatabaseDemoApplicationTests {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Test
    void contextLoads() {
    }


}
