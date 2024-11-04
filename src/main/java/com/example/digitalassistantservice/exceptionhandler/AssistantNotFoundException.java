package com.example.digitalassistantservice.exceptionhandler;

public class AssistantNotFoundException extends RuntimeException {
    public AssistantNotFoundException(String name) {
        super("Assistant with name '" + name + "' not found.");
    }
}
