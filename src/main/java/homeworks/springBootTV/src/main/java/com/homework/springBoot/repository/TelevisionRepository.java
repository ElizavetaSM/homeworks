package com.homework.springBoot.repository;

import com.homework.springBoot.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelevisionRepository extends JpaRepository <Television, Long> {
}
