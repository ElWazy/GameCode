package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.application.LoginUseCase;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.User;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserName;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserPassword;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.domain.UserRepository;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.contexts.user.infrastructure.UserRepositoryInMemory;
import com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects.Administrator;

import java.util.concurrent.Executor;

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
        try {
            UserName username = new UserName(
                txtUsername.getText().toString().trim()
            );

            UserPassword password = new UserPassword(
                    txtPassword.getText().toString().trim()
            );

            UserRepository repository = new UserRepositoryInMemory();

            LoginTask task = new LoginTask(repository, username, password);
            task.execute();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void exit(View view) {

    }

    private void info(View v){
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }

    class LoginTask extends AsyncTask<String, Void, String> {
        private UserRepository repository;
        private UserName username;
        private UserPassword password;
        private User user;

        public LoginTask(UserRepository repository, UserName username, UserPassword password) {
            this.repository = repository;
            this.username = username;
            this.password = password;
            user = null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            LoginUseCase login = new LoginUseCase(repository);
            user = login.canLogin(username, password);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            boolean matched = user != null;

            if (matched) {
                Intent i = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(i);
                return;
            }
            progressBar.setVisibility(View.GONE);

            Toast.makeText(getBaseContext(), "No se encuentra el usuario", Toast.LENGTH_SHORT).show();
        }
    }
}

