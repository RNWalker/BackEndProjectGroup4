package com.bnta.backend_project_group4.controllers;

import com.bnta.backend_project_group4.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    PetService petService;

    
}
