package com.github.pajones96.forums.service;

import com.github.pajones96.forums.dto.RegisterRequest;
import com.github.pajones96.forums.model.User;
import com.github.pajones96.forums.model.VerificationToken;
import com.github.pajones96.forums.repository.UserRepository;
import com.github.pajones96.forums.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    //Apparently Autowired is not recommended, Constructor injection is preferred instead
    //Will probably research that later 'cause I'm pretty fuzzy on the details
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    //Pretty much Exactly What It Says On The Tin. Takes a registerRequest, makes a new user in the DB.
    //Transactional annotation basically means it's working with the database(?)
    @Transactional
    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        //This bit encrypts the password in the DB so it doesn't get yoinked if someone gets in
        //Or at least makes it harder, idk how good this algorithm is
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerificationToken(user);
    }

    private String generateVerificationToken(User user){
        //Generates a unique, random 128 bit value
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return (token);
    }
}
