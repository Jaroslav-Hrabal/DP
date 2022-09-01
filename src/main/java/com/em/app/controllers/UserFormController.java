package com.em.app.controllers;

import com.em.app.models.TabUser;
import com.em.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserFormController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create-tab")
    public String showCreateForm(TabUser tabUser){
        return "add-tab-user";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TabUser tabUser = userRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("User id: " + id + " not found"));
    
        model.addAttribute("tab", tabUser);
        return "update-tab-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteTabUser(@PathVariable("id") long id, Model model) {
        TabUser tabUser = userRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("User id: " + id + " not found"));
    
        userRepository.delete(tabUser);
        return "redirect:/";
    }

    
}
