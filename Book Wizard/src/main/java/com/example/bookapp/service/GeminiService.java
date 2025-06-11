package com.example.bookapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.http.*;

import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    public String generateScene(String prompt) {
        RestClient client = RestClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Map<String, Object> body = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[] {
                                Map.of("text", "Wygeneruj opis sceny do książki na podstawie: " + prompt)
                        })
                }
        );

        Map<String, Object> response = client.post()
                .body(body)
                .retrieve()
                .body(Map.class);

        if (response != null && response.containsKey("candidates")) {
            var candidates = (java.util.List<?>) response.get("candidates");
            if (!candidates.isEmpty()) {
                var first = (Map<?, ?>) candidates.get(0);
                var content = (Map<?, ?>) first.get("content");
                var parts = (java.util.List<?>) content.get("parts");
                if (!parts.isEmpty()) {
                    return (String) ((Map<?, ?>) parts.get(0)).get("text");
                }
            }
        }

        return "Nie udało się wygenerować sceny.";
    }

}
