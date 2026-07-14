package com.niiran.engineering.repository;

import com.niiran.engineering.domain.StudentFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<StudentFee, Long> {
}
