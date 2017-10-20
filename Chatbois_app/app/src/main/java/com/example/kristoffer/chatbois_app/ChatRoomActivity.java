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

import java.util.ArrayList;
import java.util.List;

public class ChatRoomActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String username;
    private TextView usernameField;

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
        for(int i = 0;i < 100; i++) {
            input.add("Test " + i);
        }
        adapter = new ChatRoomsAdapter(input);
        recyclerView.setAdapter(adapter);

    }
}
