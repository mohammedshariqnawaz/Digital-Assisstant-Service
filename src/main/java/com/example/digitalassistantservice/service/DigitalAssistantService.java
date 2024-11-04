package com.example.digitalassistantservice.service;

import com.example.digitalassistantservice.model.DigitalAssistant;

import java.util.Optional;

public interface DigitalAssistantService {
    boolean assistantExists(String name);
    void addAssistant(DigitalAssistant assistant);
    Optional<DigitalAssistant> getAssistantByName(String name);
}
