package at.technikumwien.tourplanner_frontend.businesslayer.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestBackend {
    private final HttpClient client;

    public HttpRequestBackend() {
        this.client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> sendGetRequest(String endpoint) throws Exception{
        try {
            URI uri = new URI("http://localhost:8080/api/" + endpoint);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }

    public HttpResponse<String> sendDeleteRequest(String endpoint) throws Exception{
        try {
            URI uri = new URI("http://localhost:8080/api/" + endpoint);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .DELETE()
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("in catch");
            throw new Exception();
        }
    }

    public HttpResponse<String> sendPostRequest(String endpoint, String body) throws Exception {
        try {
            URI uri = new URI("http://localhost:8080/api/" + endpoint);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("in catch");
            throw new Exception();
        }
    }

    public HttpResponse<String> sendPutRequest(String endpoint, String body) throws Exception {
        try {
            URI uri = new URI("http://localhost:8080/api/" + endpoint);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("in catch");
            throw new Exception();
        }
    }

}
