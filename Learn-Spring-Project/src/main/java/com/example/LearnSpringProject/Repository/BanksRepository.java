package com.example.LearnSpringProject.Repository;

import com.example.LearnSpringProject.Entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanksRepository extends JpaRepository<Banks,Long> {
}
