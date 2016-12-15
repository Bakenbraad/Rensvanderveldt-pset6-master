package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
    }

    public void forward() {
        Intent goToSubmitActivity = new Intent(this, AlarmView.class);
        startActivity(goToSubmitActivity);
    }

    public void RegisterUser() {
        EditText userName = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        EditText repeatPass = (EditText) findViewById(R.id.repeatPass);

        String name = userName.getText().toString();
        String pass = password.getText().toString();
        String passCompare = repeatPass.getText().toString();

        if (name.length() != 0){
            if (pass.length() != 0){
                if (pass.equals(passCompare)){

                    // Register the user
                    auth.createUserWithEmailAndPassword(name, pass);

                    // Let them know what a good boy they are.
                    Toast toast = Toast.makeText(this, "Bedankt voor het registreren, u word ingelogd", Toast.LENGTH_SHORT);
                    toast.show();

                    // Log the user in and send them to their personal page.
                    auth.signInWithEmailAndPassword(name, pass);
                    forward();
                }
                else{
                    // Let them know what a bad boy they are.
                    Toast toast = Toast.makeText(this, "Wachtwoorden komen niet overeen", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else{
                // Let them know what a bad boy they are.
                Toast toast = Toast.makeText(this, "Vul een wachtwoord adres in", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else{
            // Let them know what a bad boy they are.
            Toast toast = Toast.makeText(this, "Vul een e-mail adres in", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
