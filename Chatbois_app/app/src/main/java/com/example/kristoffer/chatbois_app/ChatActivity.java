package com.example.kristoffer.chatbois_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = (RecyclerView) findViewById(R.id.chat_recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MessageAdapter();
        recyclerView.setAdapter(adapter);
        getMessages(adapter);

    }

    public void getMessages(final MessageAdapter adapter) {
        new LoadMessages(new LoadMessages.OnPostExecute() {
            @Override
            public void onPostExecute(List<Message> messages) {
                adapter.setData(messages);
            }
        }).execute();
    }
}
