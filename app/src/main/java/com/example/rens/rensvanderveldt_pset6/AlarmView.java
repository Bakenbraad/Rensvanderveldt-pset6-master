package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class AlarmView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_view);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    }

    public void logOut(View view) {

        // Back to login screen
        Intent goToLogin = new Intent(this, LoginActivity.class);
        startActivity(goToLogin);
    }


    public void goToSettings(View view) {
        Intent goToSettings = new Intent(this, SettingsActivity.class);
    }
}
