package com.arhafer.backend.controller;

/* 
 * Provides an endpoint to confirm if the backend server is operational.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String displayStatus() {
        return "Operational!";
    }

}
