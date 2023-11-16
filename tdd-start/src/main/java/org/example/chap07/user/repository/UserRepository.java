package org.example.chap07.user.repository;

import org.example.chap07.user.User;

public interface UserRepository {

    void save(User user);
    User findById(String id);
}
