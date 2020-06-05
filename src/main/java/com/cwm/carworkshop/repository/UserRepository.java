package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.Role;
import com.cwm.carworkshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    User findByRoles(Set<Role> roles);
//
//    List<User> findAllByRolesEquals(Set<Role> roles);

    List<User> findAllByRolesIn(Set<Role> roles);
}
