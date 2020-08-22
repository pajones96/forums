package com.github.pajones96.forums.repository;

import com.github.pajones96.forums.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This is an interface that the application uses for storing votes in the DB
//(Not 100% clear why it's structured this way though)
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
