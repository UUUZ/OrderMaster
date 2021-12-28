package com.uuuz.repository;

import com.uuuz.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
