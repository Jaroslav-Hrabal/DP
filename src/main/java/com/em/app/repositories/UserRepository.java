package com.em.app.repositories;


import com.em.app.models.TabUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TabUser, Long> {
}
