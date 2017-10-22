package com.example.kristoffer.chatbois_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kristoffer on 22.10.2017.
 */

public class HTTPGet {

    static String get;

    public static String httpGet(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String input;
        StringBuffer response  = new StringBuffer();

        while((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();

        return response.toString();

    }
}
