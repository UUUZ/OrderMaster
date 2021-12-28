package com.uuuz.repository;

import com.uuuz.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
