package com.api.shopapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.shopapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

    User findByUsername(String username);
}
