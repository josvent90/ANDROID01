package com.herson.mvc.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.herson.mvc.R;
import com.herson.mvc.interfaces.User;
import com.herson.mvc.models.UserModel;
import com.herson.mvc.utils.UserList;

public class HomeActivity extends AppCompatActivity {
    UserModel userModel = new UserModel(UserList.generateUserList());
    User currentUser;
    int userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resolveArguments();
        resolveCurrentUser();

        loadWelcomeText();
    }

    private void resolveArguments() {
        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", 0);
    }

    private void resolveCurrentUser() {
        currentUser = userModel.getUserById(userId);
    }

    private void loadWelcomeText() {
        if (currentUser != null) {
            TextView welcomeText = findViewById(R.id.welcomeText);
            welcomeText.setText("Bienvenido " + currentUser.getName());
        }
    }
}