package com.pstgln.usuario.services.impl;

import com.pstgln.usuario.model.User;
import com.pstgln.usuario.repositories.UserRepository;
import com.pstgln.usuario.services.UserService;
import com.pstgln.usuario.services.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Environment env;
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(Environment env, UserRepository userRepository) {
        this.env = env;
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        LOG.info("USER_SERVICE ::: Obteve requisição na porta: " + env.getProperty("local.server.port"));
        return userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
