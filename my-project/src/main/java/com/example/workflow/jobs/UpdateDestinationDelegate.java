package com.example.workflow.jobs;

import com.example.workflow.models.Destination;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Named
public class UpdateDestinationDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String destinationId = (String) delegateExecution.getVariable("destinationId");
        String newName = (String) delegateExecution.getVariable("update_name");

        // Use the correct API URL
        String apiUrl = "http://localhost:5150/destinations/" + destinationId;

        // Create the destination object with the updated name
        Destination updatedDestination = new Destination();
        updatedDestination.setName(newName);

        // Prepare the request body
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Destination> requestEntity = new HttpEntity<>(updatedDestination, headers);

        // Send the PUT request and get the response
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.PUT, requestEntity, String.class);

        String response = responseEntity.getBody();
        System.out.println("Updated destination name: " + response);

        // Set process variable with response data if needed
        delegateExecution.setVariable("updatedDestinationResponse", response);
    }
}
