package com.github.pajones96.forums.repository;

import com.github.pajones96.forums.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This is an interface that the application uses for storing subreddits in the DB
/////////REFACTOR LATER IF POSSIBLE////////
@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
}
