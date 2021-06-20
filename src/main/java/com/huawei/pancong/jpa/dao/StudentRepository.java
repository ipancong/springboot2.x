package com.huawei.pancong.jpa.dao;

import com.huawei.pancong.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
