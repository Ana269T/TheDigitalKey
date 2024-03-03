package com.TheDigitalKey.app.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.Roles;

@Repository
 interface IRoles extends JpaRepository<Roles, Long> {

}
