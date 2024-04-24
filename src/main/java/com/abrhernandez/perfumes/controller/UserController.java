package com.abrhernandez.perfumes.controller;

import com.abrhernandez.perfumes.entities.User;
import com.abrhernandez.perfumes.entities.UserRequest;
import com.abrhernandez.perfumes.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> loggin(HttpServletRequest request, @RequestBody UserRequest user){

        User userResponse = userService.validateCredentials(user.getUsername(), user.getPassword());
        if(userResponse == null){
            return ResponseEntity.notFound().build();
        }else{
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,null,null);
            SecurityContext securityContext =  SecurityContextHolder.getContext();
            securityContext.setAuthentication(authenticationToken);

            // Create a new session and add the security context.
            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            logger.info("Session started for : {}", user.getUsername());
            return ResponseEntity.ok(userResponse);
        }
    }


}
