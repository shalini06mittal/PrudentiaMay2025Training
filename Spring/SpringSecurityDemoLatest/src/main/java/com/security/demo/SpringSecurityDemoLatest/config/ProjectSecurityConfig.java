package com.security.demo.SpringSecurityDemoLatest.config;

import com.security.demo.SpringSecurityDemoLatest.filter.JWTTokenGeneratorFilter;
import com.security.demo.SpringSecurityDemoLatest.filter.JWTTokenValidatorFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class ProjectSecurityConfig {

    @Autowired
    private JWTTokenGeneratorFilter jwtTokenGeneratorFilter;


    // @Bean
    public UserDetailsService userDetailsService() {
      //  UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build();

        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("12345"))
                .authorities("read").build();

//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}54321")
//                .authorities("admin").build();

        UserDetails admin = User.withUsername("admin")

                .password("{bcrypt}$2a$12$28hTdBcrUf7xzTwpPKvnLOlOcNqXaVsIu/A76pjE.//p7arHpRL1m")
                .authorities("admin").build();


        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

       // http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(sessionConfig->
                sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterAfter(jwtTokenGeneratorFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class);

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount", "/myBalance").hasAuthority("user")
                .requestMatchers( "/myLoans", "/myCards").hasAuthority("admin")
                .requestMatchers("/notices", "/contact", "/error","/welcome","/register","/apilogin").permitAll()
                .anyRequest().authenticated());

//        http.formLogin(withDefaults());
//        http.formLogin(AbstractHttpConfigurer::disable);
//        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}

