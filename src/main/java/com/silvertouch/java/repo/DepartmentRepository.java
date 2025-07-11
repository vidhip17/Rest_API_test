package com.silvertouch.java.repo;

import com.silvertouch.java.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByName(String name);

    @Query("SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees ORDER BY d.name")
    List<Department> findAllDepartmentsWithEmployees();

}
