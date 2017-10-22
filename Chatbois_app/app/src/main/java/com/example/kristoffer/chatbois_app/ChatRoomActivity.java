package com.example.kristoffer.chatbois_app;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatRoomActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String username;
    private TextView usernameField;
    private ArrayList<Conversation> convos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Get the username from the previous activity
        Intent intent = getIntent();
        username = intent.getStringExtra(LoginActivity.USERNAME);
        usernameField = (TextView) findViewById(R.id.username_field);
        usernameField.setText(username);


        // Show the chat rooms
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        for(int i = 0;i < 10; i++) {
            input.add("Test " + i);
        }
        adapter = new ChatRoomsAdapter(input);
        recyclerView.setAdapter(adapter);
    }

    public void objectMapper() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String get;
            get = HTTPGet.httpGet("localhost:8080/chatbois/api/messages/conversation");
            List<Conversation> myObjects = mapper.readValue(get, mapper.getTypeFactory().
            constructCollectionType(List.class, Conversation.class));

            for(Conversation con : myObjects) {
                System.out.println(con.getId());
            }

        } catch (Exception e) {
            Logger.getLogger(HTTPGet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void getConversation() {
        Conversation c = new Conversation();
        c.setId("This is dummy, dummy");
        convos.add(c);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HTTPGet httpGet = new HTTPGet();
                    String get;
                    get = httpGet.httpGet("localhost:8080/chatbois/api/messages/conversation");

                    ArrayList<Conversation> myObjects = mapper.readValue
                } catch (Exception e) {

                }
            }
        })
    }
}
