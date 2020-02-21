package com.esvr.retobcp.web;

import com.esvr.retobcp.model.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataSessionController {

    @RequestMapping("/api/users/me")
    public ResponseEntity<UserProfile> dataSession() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        String email = username + "@gmail.com";

        UserProfile profile = new UserProfile();
        profile.setName(username);
        profile.setEmail(email);

        return ResponseEntity.ok(profile);
    }

}
