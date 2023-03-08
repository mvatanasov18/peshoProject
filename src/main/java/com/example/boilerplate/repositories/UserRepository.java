package com.example.boilerplate.repositories;

import com.example.boilerplate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,String>  {
    public User findByUsername(String username);
    public Boolean existsByUsername(String username);

}
