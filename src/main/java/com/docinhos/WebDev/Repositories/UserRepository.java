package com.docinhos.webdev.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.docinhos.webdev.models.UserModel;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
    
    Optional<UserModel>findByUsername(String username);
}
