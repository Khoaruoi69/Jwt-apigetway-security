package com.javatechie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/register", "/auth/token", "/auth/validate").permitAll()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
/*
* - tourism
--> Many people benefit greatly from the tourism industry.
*
- tourist
--> Tourists bring a lot of knowledge from their countries to places they visit.
*
- tourist trap
--> I think tourist traps are more expensive than normal and the quality may not be very good.
*
- Nowadays
--> Nowadays, the youth often read books online.
*
- foreign
--> i am learning English because i  want to work in a foreign country.
*
- foreign to sb/sth
--> Dishonesty is foreign to his nature
- foreigner
--> i have never worked with a foreigner //// i haven't had the chance to work with  anyone from another country yet.
*
- positive
*--> It's always nice to get positive feedback.
*
- negative
* --> The crisis had a negative effect on  trade
*
- negative
* --> His response was negative
- international
* --> The international economic crisis
*
- arrival
* --> The airport was busy with arrivals and departures.
*
- experience
* --> I have had more than 6 months of experience in development.
- experiences
* --> i had a wonderful experience on a trip
- globe
* --> Tourists from every corner of the globe
- globally
* --> We need to start thinking globally.
*
- gap year
* --> I have had a plan for a gap year.
- overseas
* --> The firm is expanding into overseas markets.
- to expand
* ----> i want to expand my knowledge of languages. // i have been working on expending a technical project.
- expansion
* --> The expansion of higher education will continue.
- firm
* -->  The firm is expanding into overseas market.
- to find it difficult/challenging/hard/enjoyable to V1
* --> i find it difficult to learn English
- market
* --> The firm is expanding into overseas market. // The market is famous in the place where i live is Ba Hoa market.
- street vendor
* --> Street vendors often come around my neighborhood.
- street vending
* ---> Street vending is popular in my country
- stressed-out
* --> I think he is stre
- essential ( to/for sth /Ving)
- essential
- to get away
- get away
- to retire (from sth)
- retiree
- retirement
- to relax
- relaxation
- to come up with
- to bring more advantages than disadvantages
- algorithm
- obvious
- obviously
- to expand sb's knowledge of the world

* */