package com.matveikinner.luncheon.auth.repository;

import com.matveikinner.luncheon.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
