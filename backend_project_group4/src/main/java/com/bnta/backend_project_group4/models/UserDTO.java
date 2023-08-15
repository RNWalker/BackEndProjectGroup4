package com.bnta.backend_project_group4.models;

import java.util.List;

public class UserDTO {

    private String name;
    private String email;
    private List<Long> petIds;

    public UserDTO(String name, String email, List<Long> petIds) {
        this.name = name;
        this.email = email;
        this.petIds = petIds;
    }

    // default constructor

    public UserDTO() {
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
