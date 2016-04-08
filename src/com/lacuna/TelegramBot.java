package com.lacuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lacuna on 08.04.2016.
 */
public class TelegramBot {
    private String token;
    private static final String BEGINQUERY = "https://api.telegram.org/bot";
    public TelegramBot(String token) {
        this.token = token;
    }

    public void SendMessage(String text, int chat_id) throws IOException {
        //lol&chat_id=

        String queryString = BEGINQUERY + token + "/sendMessage?" +
                "text=" + text +
                "&chat_id=" + chat_id;

        URL url = new URL(queryString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null)
            builder.append(line);

        reader.close();
        connection.disconnect();

        System.out.println(builder.toString());
    }
}
