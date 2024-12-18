package dev.buskopan.parser;

import dev.buskopan.model.GithubEvent;
import dev.buskopan.model.GithubRepo;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<GithubEvent> parseEvents(String json) {
        List<GithubEvent> events = new ArrayList<>();
        int level = 0; // Controle do nível de `{` e `}`
        StringBuilder currentObject = new StringBuilder();

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '{') {
                level++;
            }

            if (level > 0) {
                currentObject.append(c);
            }

            if (c == '}') {
                level--;

                // Quando o nível volta a 0, significa que fechamos um objeto JSON
                if (level == 0) {
                    String eventJson = currentObject.toString();
                    System.out.println(eventJson);
                    GithubEvent event = parseSingleEvent(eventJson);
                    events.add(event);

                    // Limpa o buffer para o próximo objeto
                    currentObject.setLength(0);
                }
            }
        }

        return events;
    }

    private static String extractNestedObject(String json, String startKey, String endMarker) {
        int startIndex = json.indexOf(startKey);
        if (startIndex == -1) return null;

        startIndex += startKey.length() - 1; // Inclui o '{' inicial
        int level = 0;
        StringBuilder nestedJson = new StringBuilder();

        for (int i = startIndex; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') {
                level++;
            }
            if (c == '}') {
                level--;
            }
            nestedJson.append(c);

            // Quando o nível volta a zero, o objeto está completo
            if (level == 0) {
                break;
            }
        }

        return nestedJson.toString();
    }


    private static GithubEvent parseSingleEvent(String json) {
        GithubEvent event = new GithubEvent();

        event.setId(extractValue(json, "\"id\":\"", "\""));
        event.setType(extractValue(json, "\"type\":\"", "\""));
        // Busca o objeto "repo" e extrai o nome
        String repoJson = extractNestedObject(json, "\"repo\":{", "}");
        if (repoJson != null) {
            String repoName = extractValue(repoJson, "\"name\":\"", "\"");
            String repoId = String.valueOf(extractValue(repoJson, "\"id\":", ","));
            GithubRepo repo = new GithubRepo(repoId, repoName);
            event.setRepo(repo);
        }

        return event;
    }

    private static String extractValue(String json, String key, String endMarker) {
        int startIndex = json.indexOf(key);
        if (startIndex == -1) return null;

        startIndex += key.length();
        int endIndex = json.indexOf(endMarker, startIndex);
        if (endIndex == -1) return null;

        return json.substring(startIndex, endIndex);
    }
}
