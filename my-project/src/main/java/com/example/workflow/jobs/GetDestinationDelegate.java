package com.example.workflow.jobs;

import com.example.workflow.models.Destination;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

@Named
public class GetDestinationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // Retrieve the destinationId from the process variable
        String destinationId = (String) delegateExecution.getVariable("destinationId");

        // Create the URL to call
        String apiUrl = "http://localhost:5150/destinations/" + destinationId;

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Fetch the destination object
        Destination destination = restTemplate.getForObject(apiUrl, Destination.class);

        // Convert Destination object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String destinationJson = objectMapper.writeValueAsString(destination);

        System.out.println(destinationJson);
        delegateExecution.setVariable("destination", destinationJson);
    }
}
