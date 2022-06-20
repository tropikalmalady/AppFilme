package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static final String baseUrl = "https://www.omdbapi.com/?t=TITLE&apikey=99f64500";
    public static String sendGetRequest(String requestUrl) {
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            String linhas;
            while ((linhas = buffer.readLine()) != null) {
                response.append(linhas);
            }
            buffer.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MovieParse.parse(response.toString());
    }
    public static String searchMovie(String title) {
        String requestUrl = baseUrl.replaceAll("TITLE", title);
        return sendGetRequest(requestUrl);
    }
}
