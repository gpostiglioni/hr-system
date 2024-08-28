package com.pstgln.usuario.services;

import com.pstgln.usuario.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();

}
