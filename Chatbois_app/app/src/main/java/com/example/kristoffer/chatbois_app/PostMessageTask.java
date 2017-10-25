package com.example.kristoffer.chatbois_app;

import android.util.JsonWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kristoffer on 10/25/2017.
 */
/*
public class PostMessageTask extends AbstractAsyncTask<PostMessageTask.PostMessage, void, boolean{
    public PostMessageTask() {
        super();
    }

    public PostMessageTask(OnPostExecute<Boolean> onPostExecute) {
        super(onPostExecute);
    }

    @Override
    protected Boolean doInBackground(PostMessage... messages) {
        for(PostMessage message : messages) {
            try {
                //setup request
                URL url = new URL(message.getUrl());
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);
                con.setUseCaches(false);
                con.setRequestMethod("POST");
                con.setRequestProperty("Cache-Control", "no-cache");
                con.setRequestProperty("Connection", "Keep-Alive");
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

                //Write message
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(con.getOutputStream(), "UTF8"));
                JsonWriter jw = new JsonWriter(bw);
                jw.beginObject().name("text")
                        .value(message.getText())
                        .endObject()
                        .close();

                //Setup response from server
                StringBuilder result = new StringBuilder();
                int len;
                if(con.)
            }
        }
    }

    public static class PostMessage {
        String url;
        String text;

        public PostMessage(String url, String text) {
            this.url = url;
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }
    }
}
*/