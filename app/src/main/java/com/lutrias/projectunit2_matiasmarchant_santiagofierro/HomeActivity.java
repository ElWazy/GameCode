package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects.Card;

public class HomeActivity extends AppCompatActivity {
    private Button buttonCard, deseo;
    private Card card;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadComponents();
        setupButtons();
    }
    private void loadComponents(){
        buttonCard = findViewById(R.id.btnCard);
        deseo      = findViewById(R.id.btnWish);
        videoView  = findViewById(R.id.video);

        String ruta = "android.resource://" + getPackageName() + '/' + R.raw.eneba;
        MediaController media = new MediaController(this);
        videoView.setVideoURI( Uri.parse(ruta) );
        videoView.setMediaController(media);
        videoView.start();

        card = new Card();
    }

    private void setupButtons() {
        buttonCard.setOnClickListener(this::cardbutton);
        deseo.setOnClickListener(this::wishButton);
    }

    private void cardbutton(View v){
        Intent i = new Intent(this, InsumosActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray("Cards",card.getTarjeta());
        i.putExtras(bundle);
        startActivity(i);
    }

    private void wishButton(View v){
        Intent i = new Intent(this, Deseos_act.class);
        startActivity(i);

    }
}