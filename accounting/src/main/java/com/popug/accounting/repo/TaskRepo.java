package com.popug.accounting.repo;

import com.popug.accounting.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    Optional<Task> findByPublicId(String publicId);
}
