package com.celk.crud_paciente.application.core.domain;

import com.celk.crud_paciente.adapter.out.repository.entity.Role;

import java.util.Set;
import java.util.UUID;

public class User {

    private UUID id;

    private String username;

    private String password;

    private Set<Role> roles;

    public User() {
    }

    public User(UUID id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
