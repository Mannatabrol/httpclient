package stepdefinitions;

import http.CustomHttpClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

public class StepDefinitions {

    private CustomHttpClient httpClient;
    private HttpResponse response;
    private String responseBody;
    private Properties endpoints;
    private Properties payloads;

    public StepDefinitions() {
        httpClient = new CustomHttpClient();
        endpoints = new Properties();
        payloads = new Properties();
        try (InputStream endpointStream = getClass().getClassLoader().getResourceAsStream("endpoints.properties")) {
            if (endpointStream == null) {
                System.out.println("Sorry, unable to find endpoints.properties");
                return;
            }
            endpoints.load(endpointStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (InputStream payloadStream = getClass().getClassLoader().getResourceAsStream("payloads.properties")) {
            if (payloadStream == null) {
                System.out.println("Sorry, unable to find payloads.properties");
                return;
            }
            payloads.load(payloadStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Given("I send a GET request to the API endpoint {string}")
    public void sendGETRequest(String endpointKey) throws IOException {
        String url = endpoints.getProperty(endpointKey);
        response = httpClient.sendGETRequest(url);
        assertNotNull(response);
    }

    @Then("I print the GET response")
    public void printGETResponse() throws IOException {
        responseBody = httpClient.getResponseBody(response);
        System.out.println("GET Response:");
        System.out.println(responseBody);
    }

    @Given("I send a POST request to the API endpoint {string} with JSON payload from {string}")
    public void sendPOSTRequest(String endpointKey, String payloadKey) throws IOException {
        String url = endpoints.getProperty(endpointKey);
        String payloadFile = payloads.getProperty(payloadKey);
        String payload = httpClient.readPayloadFromFile(payloadFile);
        response = httpClient.sendPOSTRequest(url, payload);
        assertNotNull(response);
    }

    @Then("I print the POST response")
    public void printPOSTResponse() throws IOException {
        responseBody = httpClient.getResponseBody(response);
        System.out.println("POST Response:");
        System.out.println(responseBody);
    }

    @Given("I send a PATCH request to the API endpoint {string} with JSON payload from {string}")
    public void sendPATCHRequest(String endpointKey, String payloadKey) throws IOException {
        String url = endpoints.getProperty(endpointKey);
        String payloadFile = payloads.getProperty(payloadKey);
        String payload = httpClient.readPayloadFromFile(payloadFile);
        response = httpClient.sendPATCHRequest(url, payload);
        assertNotNull(response);
    }

    @Then("I print the PATCH response")
    public void printPATCHResponse() throws IOException {
        responseBody = httpClient.getResponseBody(response);
        System.out.println("PATCH Response:");
        System.out.println(responseBody);
    }

    @Given("I send a DELETE request to the API endpoint {string}")
    public void sendDELETERequest(String endpointKey) throws IOException {
        String url = endpoints.getProperty(endpointKey);
        response = httpClient.sendDELETERequest(url);
        assertNotNull(response);
    }

    @Then("I print the DELETE response")
    public void printDELETEResponse() throws IOException {
        responseBody = httpClient.getResponseBody(response);
        System.out.println("DELETE Response:");
        System.out.println(responseBody);
    }

    @Given("I send a PUT request to the API endpoint {string} with JSON payload from {string}")
    public void sendPUTRequest(String endpointKey, String payloadKey) throws IOException {
        String url = endpoints.getProperty(endpointKey);
        String payloadFile = payloads.getProperty(payloadKey);
        String payload = httpClient.readPayloadFromFile(payloadFile);
        response = httpClient.sendPUTRequest(url, payload);
        assertNotNull(response);
    }

    @Then("I print the PUT response")
    public void printPUTResponse() throws IOException {
        responseBody = httpClient.getResponseBody(response);
        System.out.println("PUT Response:");
        System.out.println(responseBody);
    }
}
