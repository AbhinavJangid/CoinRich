package com.coinrich.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.coinrich.backend.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findOneByEmailAndPassword(String email, String password);

	User findByEmail(String email);

}
