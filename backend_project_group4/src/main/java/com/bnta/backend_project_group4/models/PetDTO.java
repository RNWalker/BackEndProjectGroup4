package com.bnta.backend_project_group4.models;

import java.util.List;

public class PetDTO {

    private String name;
    private Species species;
    private int happinessLevel;
    private int energyLevel;
    private Long userId;
    private List<Long> toyIds;
    private List<Long> foodIds;
}
