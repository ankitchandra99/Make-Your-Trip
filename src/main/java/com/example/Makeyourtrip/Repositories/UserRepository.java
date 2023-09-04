package com.example.Makeyourtrip.Repositories;

import com.example.Makeyourtrip.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
