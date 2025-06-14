package com.loginapp.auth.controller;

import com.loginapp.auth.model.User;
import com.loginapp.auth.repo.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user) {
        repo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
    	List<User> users = repo.findAllByUsername(user.getUsername());

    	if (users.isEmpty()) {
    	    model.addAttribute("error", "User not found");
    	    return "login";
    	}

    	User existing = users.get(0); // pick first user with that username

    	if (existing.getPassword().equals(user.getPassword())) {
    	    model.addAttribute("name", existing.getUsername());
    	    return "dashboard";
    	} else {
    	    model.addAttribute("error", "Incorrect password");
    	    return "login";
    	}

    }
}
