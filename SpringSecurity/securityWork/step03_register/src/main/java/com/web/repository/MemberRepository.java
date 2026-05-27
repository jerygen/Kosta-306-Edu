package com.web.repository;

import com.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("select m from Member m where m.id=?1")
    Member dupilicateCheck(String id);

    Boolean existsById(String id);

    Member findById(String id);
}
