package com.tts.ecomspring.repository;

import org.apache.catalina.User;

public interface UserRepository {
    User findByUsername(String username);
}
