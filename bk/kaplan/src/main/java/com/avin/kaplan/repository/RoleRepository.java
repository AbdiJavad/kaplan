package com.avin.kaplan.repository;

import com.avin.kaplan.model.oauth.ERole;
import com.avin.kaplan.model.oauth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);

}
