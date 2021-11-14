package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoActivity extends AppCompatActivity {
    private ImageButton call, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        loadComponents();
        setupButtons();
    }




    private void loadComponents(){
        call      = findViewById(R.id.btnCall);
        location  = findViewById(R.id.btnLocation);
    }
    private void setupButtons(){
        call.setOnClickListener(this::calling);
        location.setOnClickListener(this::locating);
    }

    private void calling(View v){
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+"937156494"));
        startActivity(i);

    }
    private void locating(View v){
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}