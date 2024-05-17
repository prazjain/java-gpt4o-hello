package org.prazjain;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String openAiApiKey = System.getenv("GPT4O-JAVA-HELLO-OPEN_API_KEY");

        var body = """
            {
                "model" : "gpt-4o",
                "messages" : [
                    {
                        "role" : "user",
                        "content" : "Tell me a random quote from Matrix movie"
                    }
                ]
            }
            """;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.openai.com/v1/chat/completions"))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + openAiApiKey)
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());



    }
}