package com.brijesh.oauth.controller;

import com.brijesh.oauth.response.UserRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status(){
        return "working...";
    }

    @Secured("ROLE_developer")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id){
        return "Deleted user with id "+id;
    }

    @PreAuthorize("hasAuthority('ROLE_developer')")
    @DeleteMapping(path="/preauthorize/{id}")
    public String deleteUserPreAuthorize(@PathVariable String id){
        return "Deleted user with id "+id;
    }

    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    @DeleteMapping(path="/preauthorize1/{id}")
    public String deleteUserPreAuthorizeExpression(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        return "Deleted user with id "+id + " and JWT subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.id== #jwt.subject")
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id,@AuthenticationPrincipal Jwt jwt){
        return new UserRest("Brijesh","Sharma",id);
    }
}
