package com.example.digitalassistantservice.service;

import com.example.digitalassistantservice.model.DigitalAssistant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DigitalAssistantServiceImpl implements DigitalAssistantService {

    // In-memory storage for assistants
    private final Map<String, DigitalAssistant> assistants = new HashMap<>();

    @Override
    public boolean assistantExists(String name) {
        return assistants.containsKey(name);
    }

    @Override
    public void addAssistant(DigitalAssistant assistant) {
        assistants.put(assistant.getName(), assistant);
    }

    @Override
    public Optional<DigitalAssistant> getAssistantByName(String name) {
        return Optional.ofNullable(assistants.get(name));
    }
}
