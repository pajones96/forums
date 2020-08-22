package com.github.pajones96.forums.repository;


import com.github.pajones96.forums.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This is an interface that the application uses for storing users (and their data, presumably) in the DB
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
