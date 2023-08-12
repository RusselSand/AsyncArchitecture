package com.popug.task.service;

import com.popug.task.model.User;
import com.popug.task.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo repo;
    public void saveUser(User user){
        var taskUser = repo.findByPublicId(user.getPublicId());
        if(taskUser.isPresent()){
            var editUser = taskUser.get();
            editUser.setName(user.getName());
            editUser.setRole(user.getRole());
            editUser.setEmail(user.getEmail());
            repo.save(editUser);
        } else{
            repo.save(user);
        }
    }

    public User getUser(String email){
        return repo.findByEmail(email).orElse(null);
    }
}
