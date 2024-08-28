package com.pstgln.usuario;

import com.pstgln.usuario.model.User;
import com.pstgln.usuario.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UsuarioApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public UsuarioApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

	@Override
	public void run(String... args) {
		userRepository.saveAll(
				List.of(
						new User(
								null,
								"Gabriel",
								"gabriel@pstgln.com",
								"123456",
								20.0)
				)
		);
	}
}
