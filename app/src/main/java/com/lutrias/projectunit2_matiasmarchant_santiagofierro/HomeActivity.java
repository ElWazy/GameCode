package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects.Card;

public class HomeActivity extends AppCompatActivity {
    private Button buttonCard;
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
        videoView  = findViewById(R.id.video);

        String ruta = "android.resource://" + getPackageName() + '/' + R.raw.video;
        videoView.setVideoURI( Uri.parse(ruta) );
        videoView.start();

        card = new Card();

        // CONTROLES
        /*
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
         */
    }


    private void setupButtons() {
        buttonCard.setOnClickListener(this::cardbutton);
    }

    private void cardbutton(View v){
        Intent i = new Intent(this, InsumosActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray("Cards",card.getTarjeta());
        i.putExtras(bundle);
        startActivity(i);
    }
}