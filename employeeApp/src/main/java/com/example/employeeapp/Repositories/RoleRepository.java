package com.example.employeeapp.Repositories;

import com.example.employeeapp.Models.ERole;
import com.example.employeeapp.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
        Optional<Role> findByName(ERole name);
        }
