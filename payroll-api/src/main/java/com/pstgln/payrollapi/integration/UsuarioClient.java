package com.pstgln.payrollapi.integration;

import com.pstgln.payrollapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-usuarios", url = "http://localhost:8000")
public interface UsuarioClient {

    @GetMapping(value = "/api/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping(value = "/api/users")
    public ResponseEntity<List<User>> findAll();

}
