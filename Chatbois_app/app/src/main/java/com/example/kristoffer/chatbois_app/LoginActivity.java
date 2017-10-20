package com.example.kristoffer.chatbois_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public static final String USERNAME = "com.example.kristoffer.chatbois_app.USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Intent intent = new Intent(this, ChatRoomActivity.class);
        EditText usernameField = (EditText) findViewById(R.id.username);
        String username  = usernameField.getText().toString();
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }
}
