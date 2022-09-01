package com.em.app.config;


import com.em.app.models.TabUser;
import com.em.app.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (userRepository.count() == 0) {
            TabUser user1 = new TabUser("Tom");
            TabUser user2 = new TabUser("Jerry");

            userRepository.save(user1);
            userRepository.save(user2);
        }

        logger.info("Number of tabUsers: {}", userRepository.count());
    }
    
}
