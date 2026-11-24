package com.pairline.user.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.pairline.user.model.User;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void existsByEmailReturnsTrueAfterSave() {
		User user = new User();
		user.setEmail("anil@test.com");
		user.setPasswordHash("hashedValue");
		user.setDisplayName("Anil");

		userRepository.save(user);
		assertTrue(userRepository.existsByEmail("anil@test.com"));

	}
}
