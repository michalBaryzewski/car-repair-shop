package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    Role findByName(String name);

    @Query("select r.name from Role r where r.name = ?1")
    Role findByName(String name);

    Set<Role> findAllByName(String name);

}
