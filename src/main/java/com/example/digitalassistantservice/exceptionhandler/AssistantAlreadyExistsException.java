package com.example.digitalassistantservice.exceptionhandler;

public class AssistantAlreadyExistsException extends RuntimeException {
    public AssistantAlreadyExistsException(String name) {
        super("Assistant with name '" + name + "' already exists.");
    }
}
