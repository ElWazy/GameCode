package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects.Card;

public class HomeActivity extends AppCompatActivity {
    private Button buttoncard;
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
        buttoncard = findViewById(R.id.btnCard);
        videoView      = findViewById(R.id.video);

        String ruta = "android.resource://"+getPackageName()+ "/"+ R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);
        videoView.start();

        //CONTROLES
        /*
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
        card = new Card();

         */
    }


    private void setupButtons() {
        buttoncard.setOnClickListener(this::cardbutton);
    }

    private void cardbutton(View v){
        Intent i = new Intent(this, InsumosActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray("Cards",card.getTarjeta());
        i.putExtras(bundle);
        startActivity(i);
    }
}