package com.jadecross.job.repository;

import com.jadecross.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    //JPQL 문법, ORM 만으로 부족할 때 사용하는 엔티티 객체를 대상으로 생성하는 쿼리
    //사용자가 가지고 있는 스킬을 기반으로 채용 공고를 가져오게 한다
    @Query("""
                SELECT DISTINCT j
                FROM Job j
                JOIN j.skills s
                WHERE LOWER(s.skill) IN :skills
            """)
    List<Job> findByAnySkill(List<String> skills);

}
