package com.github.pajones96.forums.repository;

import com.github.pajones96.forums.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This is an interface that the application uses for storing comments in the DB
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
