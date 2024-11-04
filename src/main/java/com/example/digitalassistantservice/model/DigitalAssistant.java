package com.example.digitalassistantservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DigitalAssistant {
    @NotBlank(message = "Name is mandatory.")
    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    private String name;

    @NotBlank(message = "Response is mandatory.")
    @Size(max = 300, message = "Response cannot exceed 300 characters.")
    private String response;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
