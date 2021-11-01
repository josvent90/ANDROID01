package com.herson.mvc.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;
import com.herson.mvc.R;
import com.herson.mvc.models.UserModel;
import com.herson.mvc.utils.UserList;

public class LoginActivity extends AppCompatActivity {
    UserModel userModel = new UserModel(UserList.generateUserList());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginBtnClicks(View view) {
        EditText email = findViewById(R.id.emailEditText);
        EditText password = findViewById(R.id.passwordEditText);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginBtn.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
                tryToDoLogin(email.getText().toString(), password.getText().toString(), view);
            }
        }, 3000);
    }

    private void tryToDoLogin(String email, String password, View view) {
        boolean isUserLocated = userModel.doLogin(email, password);

        if (!isUserLocated) {
            Snackbar.make(view, "Usuario no encontrado", 2500).show();
        } else {
            int userId = userModel.getCurrentUser().getId();

            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
        }
    }
}