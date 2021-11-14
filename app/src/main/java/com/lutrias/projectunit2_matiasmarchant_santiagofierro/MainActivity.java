package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects.Administrator;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;
    private Button btnLogin, btnExit;
    private final ImageButton[] imageButtons = new ImageButton[3];
    private ImageButton info;
    private Administrator admin;
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
        info        = findViewById(R.id.btnInfo);

        imageButtons[0] = findViewById(R.id.btnFacebook);
        imageButtons[1] = findViewById(R.id.btnYoutube);
        imageButtons[2] = findViewById(R.id.btnTwitter);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        admin = new Administrator();
    }

    private void setupButtons() {
        btnLogin.setOnClickListener(this::login);
        btnExit.setOnClickListener(this::exit);
        info.setOnClickListener(this::info);

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
        String adminUsername = admin.getUsername().trim();
        String adminPassword = admin.getPassword().trim();

        String username = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        boolean usernameMatch = username.equals(adminUsername);
        boolean passwordMatch = password.equals(adminPassword);

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!usernameMatch || !passwordMatch) {
            Toast.makeText(this, "Campos incorrectos", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    private void exit(View view) {

    }

    private void info(View v){
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }
}