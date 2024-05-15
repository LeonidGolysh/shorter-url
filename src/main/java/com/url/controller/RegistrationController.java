package com.url.controller;

import com.url.entity.User;
import com.url.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userEntity", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") User user, Model model) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}
