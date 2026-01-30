package org.projekti.babai.controller.Babai;

import org.projekti.babai.model.JokeApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class JokeController {

    private final RestClient restClient;

    public JokeController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/api/joke")
    public String getRandomJoke() {

        JokeApiResponse response = restClient.get()
                .uri("/joke/Any")
                .retrieve()
                .body(JokeApiResponse.class);

        if (response == null) {
            return "No joke available right now 😢";
        }

        // Single-line joke
        if ("single".equalsIgnoreCase(response.getType())) {
            return response.getJoke();
        }

        // Two-part joke
        return response.getSetup() + " — " + response.getDelivery();
    }
}

