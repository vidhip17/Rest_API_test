package com.silvertouch.java.repo;

import com.silvertouch.java.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllByDepartmentId(Long deptId);

    boolean existsByEmail(String email);
}
