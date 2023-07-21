package com.popug.demo.repo;

import com.popug.demo.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo extends JpaRepository<Data, Integer> {
}
