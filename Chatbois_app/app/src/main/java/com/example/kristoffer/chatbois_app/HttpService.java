package com.example.kristoffer.chatbois_app;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kristoffer on 10/24/2017.
 */

public class HttpService {

    private OkHttpClient http;

    public HttpService(){
        this.http = new OkHttpClient();
    }

    public String get(String url) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        try {
            Response response = http.newCall(request).execute();
            String res = response.body().string();
            return res;
        } catch (IOException e) {
            Log.e("HttpService", e.getMessage());
            return null;
        }
    }

}
