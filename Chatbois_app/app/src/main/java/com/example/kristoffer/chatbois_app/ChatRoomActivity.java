package com.example.kristoffer.chatbois_app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatRoomActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChatRoomsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String username;
    private TextView usernameField;
    private Context context;
    private HTTPGet httpGet;
    private ObjectMapper mapper;
    private String jsonString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Setup recycler view
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatRoomsAdapter(context);
        recyclerView.setAdapter(adapter);
        getConversation(adapter);

        //go to chat
        adapter.setOnClickListener(new ConversationClickListener() {
            @Override
            public void onClick(Context context, Conversation conversation) {
                Intent intent = new Intent(ChatRoomActivity.this, ChatActivity.class);
                startActivity(intent);            }
        });

        // Get the username from the previous activity
        Intent intent = getIntent();
        username = intent.getStringExtra(LoginActivity.USERNAME);
        usernameField = (TextView) findViewById(R.id.username_field);
        usernameField.setText(username);
    }

    public void getConversation(final ChatRoomsAdapter adapter) {
        new LoadConversation(new LoadConversation.OnPostExecute() {
            @Override
            public void onPostExecute(List<Conversation> conversations) {
                adapter.setData(conversations);
            }
        }).execute();
    }
}
