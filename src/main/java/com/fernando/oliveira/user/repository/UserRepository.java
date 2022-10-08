package com.fernando.oliveira.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.oliveira.user.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	

	Optional<User> findByEmail(String email);

}
