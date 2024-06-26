package com.TheDigitalKey.app.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TheDigitalKey.app.bd.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
	
	Optional<User> findByUsername(String username);


}
