package com.github.pajones96.forums.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //Disabled csrf protection because we're using a REST API and JWT, so csrf attacks aren't really a concern
        //"csrf attacks mainly occur when there are sessions and cookies to authenticate session information"
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    //This is the password encoder used to hash passwords in the DB so they're harder to yoink
    //Apparently it's a "pretty good" algorithm but I intend to look into it more
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
