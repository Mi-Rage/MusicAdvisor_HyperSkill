package advisor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The authorization class. Here we get the authorization code
 * and use it to get the authorization token
 */
public class Authorisation {
    public static String REDIRECT_URI = "http://localhost:8080";
    public static String CLIENT_ID = "67da7afe4b20443ca01445b1a0a75d6b";
    public static String CLIENT_SECRET = "6f5efccb851c4b0eb547443ee7de94ec";
    public static String ACCESS_TOKEN = "";
    public static String ACCESS_CODE = "";

    /**
     * Getting access_code
     */
    public void getAccessCode() {
        //Creating a line to go to in the browser
        String uri = Main.SERVER_PATH + "/authorize"
                + "?client_id=" + CLIENT_ID
                + "&redirect_uri=" + REDIRECT_URI
                + "&response_type=code";
        System.out.println("use this link to request the access code:");
        System.out.println(uri);

        //Creating a server and listening to the request.
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);

            server.createContext("/",
                    new HttpHandler() {
                        public void handle(HttpExchange exchange) throws IOException {
                            String query = exchange.getRequestURI().getQuery();
                            String request;
                            if (query != null && query.contains("code")) {
                                ACCESS_CODE = query.substring(5);
                                System.out.println("code received");
                                request = "Got the code. Return back to your program.";
                            } else {
                                request = "Not found authorization code. Try again.";
                            }
                            exchange.sendResponseHeaders(200, request.length());
                            exchange.getResponseBody().write(request.getBytes());
                            exchange.getResponseBody().close();
                        }
                    });

            server.start();
            System.out.println("waiting for code...");
            while (ACCESS_CODE.length() == 0) {
                Thread.sleep(10);
            }
            server.stop(5);

        } catch (IOException | InterruptedException e) {
            System.out.println("Server error");
        }
    }

    /**
     * Getting access_token based on access_code
     */
    public void getAccessToken() {

        System.out.println("Making http request for access_token...");

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(Main.SERVER_PATH + "/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "grant_type=authorization_code"
                                + "&code=" + ACCESS_CODE
                                + "&client_id=" + CLIENT_ID
                                + "&client_secret=" + CLIENT_SECRET
                                + "&redirect_uri=" + REDIRECT_URI))
                .build();

        try {

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response != null) {
                getAccessToken(response.body());
            }
            System.out.println("Success!");

        } catch (InterruptedException | IOException e) {
            System.out.println("Error response");
        }
    }

    /**
     * Parsing access token from response
     * @param _response - String, JSON response with token
     */
    public void getAccessToken(String _response){
        JsonObject jsonObject = JsonParser.parseString(_response).getAsJsonObject();
        ACCESS_TOKEN = jsonObject.get("access_token").getAsString();
    }
}



