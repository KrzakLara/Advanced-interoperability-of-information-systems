package com.example.workflow.jobs;

import com.example.workflow.models.Destination;
import com.example.workflow.models.DestinationType;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
public class AddDestinationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // Retrieve necessary process variables
        String name = (String) delegateExecution.getVariable("name");
        String type = (String) delegateExecution.getVariable("type");
        String code = (String) delegateExecution.getVariable("code");
        String priceString = (String) delegateExecution.getVariable("price");

        // Convert price to double
        double price = Double.parseDouble(priceString);

        // Create the URL to call
        String apiUrl = "http://localhost:5150/destinations/";

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Create the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the Destination object with new information
        Destination newDestination = new Destination();
        newDestination.setName(name);
        newDestination.setType(DestinationType.valueOf(type.trim().toUpperCase()));
        newDestination.setCode(code);
        newDestination.setPrice(price);

        // Create a DestinationWithoutId object for logging
        DestinationWithoutId destinationWithoutId = new DestinationWithoutId(newDestination.getName(), newDestination.getType(), newDestination.getCode(), newDestination.getPrice());

        // Wrap the destination in a map with the "destinations" field
        Map<String, Object> payload = new HashMap<>();
        payload.put("destinations", Collections.singletonList(newDestination));

        // Convert the payload to JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonPayload;

        try {
            jsonPayload = mapper.writeValueAsString(payload);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert destination to JSON", e);
        }

        // Log the JSON payload being sent
        String logPayload;
        try {
            logPayload = mapper.writeValueAsString(Collections.singletonMap("destinations", Collections.singletonList(destinationWithoutId)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert log payload to JSON", e);
        }
        System.out.println("New destination JSON payload: " + logPayload);

        // Create the HttpEntity
        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        // Send the POST request to add the destination
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        // Set process variable with response data if needed
        delegateExecution.setVariable("newDestinationResponse", response.getBody());
    }
}

// Helper class
class DestinationWithoutId {
    private String name;
    private DestinationType type;
    private String code;
    private double price;

    public DestinationWithoutId(String name, DestinationType type, String code, double price) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.price = price;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DestinationType getType() {
        return type;
    }

    public void setType(DestinationType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
