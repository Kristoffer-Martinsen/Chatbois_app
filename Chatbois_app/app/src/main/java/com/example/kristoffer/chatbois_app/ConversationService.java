package com.example.kristoffer.chatbois_app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Kristoffer on 10/24/2017.
 */

public class ConversationService {

    private static final String URL = "http://158.38.72.94:8080/Chatbois/api/messages/conversation";
    private static final Type LIST_TYPE = new TypeToken<List<Conversation>>(){}.getType();

    private HttpService httpService;
    private Gson gson;

    public ConversationService(){
        httpService = new HttpService();
        gson = new Gson();
    }

    public List<Conversation> getAll(){
        String response = httpService.get(URL);
        return gson.fromJson(response, LIST_TYPE);
    }

}
