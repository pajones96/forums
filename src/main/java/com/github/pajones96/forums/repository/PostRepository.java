package com.github.pajones96.forums.repository;


import com.github.pajones96.forums.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This is an interface that the application uses for storing posts in the DB
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
