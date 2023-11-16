package org.example.chap07.user.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.chap07.user.User;

public class MemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
