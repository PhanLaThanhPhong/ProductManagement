package org.example.productmanagement.repository;

import org.example.productmanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
