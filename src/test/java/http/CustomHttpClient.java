package http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomHttpClient {

    private HttpClient httpClient;

    public CustomHttpClient() {
        this.httpClient = HttpClients.createDefault();
    }

    public HttpResponse sendGETRequest(String url) throws IOException {
        HttpGet getRequest = new HttpGet(url);
        return httpClient.execute(getRequest);
    }

    public HttpResponse sendPOSTRequest(String url, String payload) throws IOException {
        HttpPost postRequest = new HttpPost(url);
        StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);
        postRequest.setEntity(entity);
        return httpClient.execute(postRequest);
    }

    public HttpResponse sendPATCHRequest(String url, String payload) throws IOException {
        HttpPatch patchRequest = new HttpPatch(url);
        StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);
        patchRequest.setEntity(entity);
        return httpClient.execute(patchRequest);
    }

    public HttpResponse sendDELETERequest(String url) throws IOException {
        HttpDelete deleteRequest = new HttpDelete(url);
        return httpClient.execute(deleteRequest);
    }

    public HttpResponse sendPUTRequest(String url, String payload) throws IOException {
        HttpPut putRequest = new HttpPut(url);
        StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);
        putRequest.setEntity(entity);
        return httpClient.execute(putRequest);
    }

    public String getResponseBody(HttpResponse response) throws IOException {
        HttpEntity responseEntity = response.getEntity();
        return EntityUtils.toString(responseEntity);
    }

    public String readPayloadFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
    }
}
