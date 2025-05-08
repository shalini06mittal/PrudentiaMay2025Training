package com.security.demo.SpringSecurityDemoLatest.controller;

import com.security.demo.SpringSecurityDemoLatest.constants.ApplicationConstants;
import com.security.demo.SpringSecurityDemoLatest.entity.Customer;
import com.security.demo.SpringSecurityDemoLatest.entity.LoginRequestDTO;
import com.security.demo.SpringSecurityDemoLatest.entity.LoginResponseDTO;
import com.security.demo.SpringSecurityDemoLatest.repository.CustomerRepository;
import com.security.demo.SpringSecurityDemoLatest.service.GenerateToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final Environment env;
    private final GenerateToken generateToken;

    @PostMapping("/apilogin")
    public ResponseEntity<LoginResponseDTO> apiLogin (@RequestBody LoginRequestDTO loginRequest) {

        System.out.println("/user request");
        String jwt = "";
        Authentication authenticationResponse =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),loginRequest.password()));
        if(null != authenticationResponse && authenticationResponse.isAuthenticated()) {
            if (null != env) {
                jwt = generateToken.createToken(authenticationResponse);
            }
        }
        System.out.println("generated token "+jwt);
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstants.JWT_HEADER,jwt)
                .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(), jwt));
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            Customer savedCustomer = customerRepository.save(customer);

            if(savedCustomer.getId()>0) {
                return ResponseEntity.status(HttpStatus.CREATED).
                        body("Given user details are successfully registered");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body("User registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("An exception occurred: " + ex.getMessage());
        }

    }

}

