package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
    }

    public void logIn(){
        EditText usernameET = (EditText) findViewById(R.id.loginUsername);
        EditText passwordET = (EditText) findViewById(R.id.loginPass);

        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        if (username.length() != 0){
            if (password.length() != 0){
                // Log the user in
                auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent goToAlarmView = new Intent(LoginActivity.this, AlarmView.class);
                        startActivity(goToAlarmView);

                        if (!task.isSuccessful()) {
                            Toast toast = Toast.makeText(LoginActivity.this, "Bedankt voor het registreren, u word ingelogd", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });
            }
            else {
                Toast toast = Toast.makeText(this, "Vul uw wachtwoord in", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else {
            Toast toast = Toast.makeText(this, "Vul een naam in", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}
