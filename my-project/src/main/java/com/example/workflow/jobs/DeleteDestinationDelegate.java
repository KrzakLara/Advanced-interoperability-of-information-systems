package com.example.workflow.jobs;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Named
public class DeleteDestinationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // Retrieve the destinationId from the process variable
        String destinationId = (String) delegateExecution.getVariable("destinationId");

        // Log the destination ID
        System.out.println("Destination ID: " + destinationId);

        // Create the URL to call
        String apiUrl = "http://localhost:5150/destinations/" + destinationId;

        // Create a client
        HttpClient client = HttpClient.newHttpClient();

        // First, check if the resource exists
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        if (getResponse.statusCode() == 200) {
            // If the resource exists, proceed to delete it
            HttpRequest deleteRequest = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .DELETE() // Explicit DELETE request
                    .build();

            // Send the request and receive a response
            HttpResponse<String> deleteResponse = client.send(deleteRequest, HttpResponse.BodyHandlers.ofString());

            // Check if the response status code is 204 (No Content) or 200 (OK)
            if (deleteResponse.statusCode() == 204 || deleteResponse.statusCode() == 200) {
                System.out.println("Deleted destination successfully.");
            } else {
                System.out.println("Failed to delete destination. Status code: " + deleteResponse.statusCode());
                System.out.println("Response body: " + deleteResponse.body());
            }
        } else if (getResponse.statusCode() == 404) {
            System.out.println("Destination not found: " + destinationId);
        } else {
            System.out.println("Failed to check destination. Status code: " + getResponse.statusCode());
            System.out.println("Response body: " + getResponse.body());
        }
    }
}
