package com.em.app.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tab_user")
public class TabUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String description;

    @Getter
    @Setter
    private boolean active;

    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;

    public TabUser() {}

    public TabUser(String description) {
        this.description = description;
        this.active = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }
    
    @Override
    public String toString() {
        return String.format("TabUser{id=%d, description='%s', active='%s', createdDate='%s', modifiedDate='%s'}",
        id, description, active, createdDate, modifiedDate);
    }

    
}
