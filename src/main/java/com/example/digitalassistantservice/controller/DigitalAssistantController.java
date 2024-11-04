package com.example.digitalassistantservice.controller;

import com.example.digitalassistantservice.exceptionhandler.AssistantAlreadyExistsException;
import com.example.digitalassistantservice.exceptionhandler.AssistantNotFoundException;
import com.example.digitalassistantservice.model.DigitalAssistant;
import com.example.digitalassistantservice.service.DigitalAssistantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assistant")
public class DigitalAssistantController {

    private final DigitalAssistantService assistantService;

    @Autowired
    public DigitalAssistantController(DigitalAssistantService assistantService) {
        this.assistantService = assistantService;
    }

    // Endpoint to define a new assistant
    @Operation(summary = "Define a new Digital Assistant",
            description = "Creates a new digital assistant with a unique name and a predefined response.")
    @ApiResponse(responseCode = "201", description = "Assistant defined successfully.")
    @ApiResponse(responseCode = "409", description = "Assistant with this name already exists.")
    @PostMapping("/define")
    public ResponseEntity<String> defineAssistant(@Valid @RequestBody DigitalAssistant assistant) {
        if (assistantService.assistantExists(assistant.getName())) {
            throw new AssistantAlreadyExistsException(assistant.getName());
        }
        assistantService.addAssistant(assistant);
        return new ResponseEntity<>("Assistant defined successfully.", HttpStatus.CREATED);
    }

    // Endpoint to send a message to the assistant
    @Operation(summary = "Send a message to a Digital Assistant",
            description = "Sends a message to the specified assistant and retrieves its predefined response.")
    @ApiResponse(responseCode = "200", description = "Response from the assistant.")
    @ApiResponse(responseCode = "404", description = "Assistant not found.")
    @PostMapping("/{name}/messages")
    public ResponseEntity<String> sendMessage(@PathVariable String name, @RequestBody String message) {
        DigitalAssistant assistant = assistantService.getAssistantByName(name)
                .orElseThrow(() -> new AssistantNotFoundException(name));
        return new ResponseEntity<>(assistant.getResponse(), HttpStatus.OK);
    }
}
