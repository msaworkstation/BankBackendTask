package com.jat.MSamir.dao;

import com.jat.MSamir.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String username);
    List<User> findAll();
}
