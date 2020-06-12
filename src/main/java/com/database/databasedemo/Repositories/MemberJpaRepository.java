package com.database.databasedemo.Repositories;

import com.database.databasedemo.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Integer> {

    List<Member> findAll();

    Member saveAndFlush(Member person);
}
