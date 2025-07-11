package com.example.demo.repo;

import com.example.demo.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<Home,Long> {

}
