package com.github.pajones96.forums.repository;


import com.github.pajones96.forums.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*I'mma keep it real with you, chief. This one's weird and I'm a little confused.
* I had to look at the final code up on Github to get this one done
* And I have more questions now. I get how verification tokens work, of course but like.
* I'm not sure about the rest of this code
*/
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
