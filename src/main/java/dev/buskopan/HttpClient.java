package dev.buskopan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class HttpClient {

    public HttpClient() {
    }

    public String getActivity(String username) {
        String baseurl = "https://api.github.com/users/"+username+"/events";
        try {
            URL url = URI.create(baseurl).toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "GithubAcitivyCLI");

            int code = con.getResponseCode();

            if (code != 200) {
                return null;
            }

            StringBuilder sb = new StringBuilder();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;

            while((line = in.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
