package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername, txtPassword;
    private Button btnLogin, btnExit;
    private ImageButton[] imageButtons = new ImageButton[3];
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadComponents();
        setupButtons();
    }

    private void loadComponents() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin    = findViewById(R.id.btnLogin);
        btnExit     = findViewById(R.id.btnExit);

        imageButtons[0] = findViewById(R.id.btnFacebook);
        imageButtons[1] = findViewById(R.id.btnYoutube);
        imageButtons[2] = findViewById(R.id.btnTwitter);

        progressBar = findViewById(R.id.progressBar);
    }

    private void setupButtons() {
        btnLogin.setOnClickListener(this::login);
        btnExit.setOnClickListener(this::exit);

        String[] urls = {"facebook", "youtube", "twitter"};
        for (int i = 0; i < imageButtons.length; i++) {
            int iterator = i;
            imageButtons[i].setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://" + urls[iterator] + ".com/"));
                startActivity(intent);
            });
        }
    }

    private void login(View view) {

    }

    private void exit(View view) {

    }
}