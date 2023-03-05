package com.egor.usersdb.repositories;

import com.egor.usersdb.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUserName(String username);
}
