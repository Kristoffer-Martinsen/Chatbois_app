package com.example.kristoffer.chatbois_app;

import android.os.AsyncTask;
import java.util.List;

/**
 * Created by Kristoffer on 10/23/2017.
 */

public class LoadMessages extends AsyncTask<Void, Integer, List<Message>> {
    public interface OnPostExecute {
        void onPostExecute(List<Message> messages);
    }
    LoadMessages.OnPostExecute callback;
    private MessageService messageService;


    public LoadMessages(OnPostExecute callback) {
        this.callback = callback;
        this.messageService = new MessageService();
    }

    @Override
    protected List<Message> doInBackground(Void... voids) {
        return messageService.getAll();
    }

    @Override
    public void onPostExecute(List<Message> messages) {
        if(callback != null) {
            callback.onPostExecute(messages);
        }
    }
}
