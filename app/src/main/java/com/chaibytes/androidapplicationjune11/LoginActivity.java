package com.chaibytes.androidapplicationjune11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Toast.makeText(this, "LoginActivity.onCreate() method", Toast.LENGTH_LONG).show();

        // Get user text from Email
        EditText email = (EditText) findViewById(R.id.emailEditText);
        final String emailText = email.getText().toString();

        // Get user text from Password

        EditText password = (EditText) findViewById(R.id.passwordEditText);
        final String passwordText = password.getText().toString();


        // On Login button click, open another activity
        Button login = (Button) findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open another Activity
                Bundle loginData = new Bundle();
                loginData.putCharArray("email", emailText.toCharArray());
                loginData.putCharArray("password", passwordText.toCharArray());

                Intent postLogin = new Intent(getApplicationContext(), PostLoginScreenActivity.class);
                postLogin.putExtra("login", loginData);
                startActivity(postLogin);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        //Toast.makeText(this, "LoginActivity.onStart() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        //Toast.makeText(this, "LoginActivity.onResume() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        //Toast.makeText(this, "LoginActivity.onPause() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        //Toast.makeText(this, "LoginActivity.onStop() method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Toast.makeText(this, "LoginActivity.onDestroy() method", Toast.LENGTH_LONG).show();
    }

}
