package com.popug.accounting.repo;

import com.popug.accounting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByPublicId(String publicId);
    Optional<User> findByEmail(String email);
}
