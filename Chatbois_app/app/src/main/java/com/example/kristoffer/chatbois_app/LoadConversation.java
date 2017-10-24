package com.example.kristoffer.chatbois_app;

import android.os.AsyncTask;
import java.util.List;

/**
 * Created by Kristoffer on 10/24/2017.
 */

public class LoadConversation extends AsyncTask<Void, Integer, List<Conversation>> {

    public interface OnPostExecute {
        void onPostExecute(List<Conversation> conversations);
    }
    LoadConversation.OnPostExecute callback;
    private ConversationService conversationService;

    public LoadConversation(LoadConversation.OnPostExecute callback) {
        this.callback = callback;
        this.conversationService = new ConversationService();
    }

    @Override
    protected List<Conversation> doInBackground(Void... voids) {
        return conversationService.getAll();
    }

    @Override
    public void onPostExecute(List<Conversation> conversations) {
        if(callback != null) {
            callback.onPostExecute(conversations);
        }
    }
}
