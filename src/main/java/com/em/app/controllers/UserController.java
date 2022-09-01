package com.em.app.controllers;

import java.time.Instant;
import java.time.ZoneId;

import javax.validation.Valid;

;

import com.em.app.models.TabUser;
import com.em.app.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("tabUsers", userRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }

    @PostMapping("/tab")
    public String createTabUser(@Valid TabUser tabUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-tab-user";
        }

        tabUser.setCreatedDate(Instant.now());
        tabUser.setModifiedDate(Instant.now());
        userRepository.save(tabUser);
        return "redirect:/";
    }

    @PostMapping("/tab/{id}")
    public String updateTabUser(@PathVariable("id") long id, @Valid TabUser tabUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            tabUser.setId(id);
            return "update-tab-user";
        }

        tabUser.setModifiedDate(Instant.now());
        userRepository.save(tabUser);
        return "redirect:/";
    }

}
