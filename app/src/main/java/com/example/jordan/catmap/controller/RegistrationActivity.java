package com.example.jordan.catmap.controller;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.jordan.catmap.R;
import com.example.jordan.catmap.model.Database;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private static FirebaseAuth fAuth;
    private Button register;
    private Button back;
    private EditText name;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        register = (Button) findViewById(R.id.register);
        back = (Button) findViewById(R.id.back);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == register) {
            ();

        }

        if (v == back) {
            //Goes back to the main splash screen
            Intent intent = new Intent(RegistrationActivity.this, Activity_loginactivity.class); // broken at the moment but will not be when we get login activity
            RegistrationActivity.this.startActivity(intent);
            finish();
        }


    }

    public void register(final String email, String password, final String name) {
        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Database.createUser(email, name);
                            FirebaseUser user = fAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(RegistrationActivity.this, "Authentication failed", Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });

    }


}
