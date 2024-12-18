package dev.buskopan;

import dev.buskopan.model.GithubEvent;
import dev.buskopan.parser.JsonParser;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HttpClient hc = new HttpClient();

        while (true) {
            System.out.println("Type a github username");
            String username = sc.nextLine();
            String response = hc.getActivity(username);

            if (response == null) {
                System.out.println("Couldn't get activity");
                continue;
            }

            List<GithubEvent> githubEvents = JsonParser.parseEvents(response);

            for (GithubEvent event : githubEvents) {
                String type = event.getType();

                switch (type) {
                    case "PushEvent":
                        System.out.println("Pushed to " + event.getRepo().getName());
                        break;
                    case "PullRequestEvent":
                        System.out.println("Made a pull request to " + event.getRepo().getName());
                        break;
                    default:
                        System.out.println("Perfomed " + event.getType() + " to " + event.getRepo().getName());
                }
            }
        }
    }
}