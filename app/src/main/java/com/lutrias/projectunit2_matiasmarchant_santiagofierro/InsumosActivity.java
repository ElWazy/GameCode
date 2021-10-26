package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects.Card;

public class InsumosActivity extends AppCompatActivity {
    private Spinner insumos;
    private EditText numero;
    private Button bt1, btnCal;
    private TextView texto;
    private RatingBar star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);
        loadComponents();
        setupButtons();
    }
    private void loadComponents() {
        numero  = findViewById(R.id.txtnumber);
        insumos = findViewById(R.id.spinner2);
        bt1     = findViewById(R.id.btnBuy);
        texto   = findViewById(R.id.txtresumen);
        btnCal  = findViewById(R.id.btnCalculate);
        star    = findViewById(R.id.ratingBar);

        bt1.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();
        String[] listaInsumos = bundle.getStringArray("Cards");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaInsumos);
        insumos.setAdapter(adapter);

    }
    private void setupButtons(){
        btnCal.setOnClickListener(this::calcular);

    }
    @SuppressLint("SetTextI18n")
    private void calcular (View v){
        try {
            Card taj = new Card();
            int valuenumber = Integer.parseInt(numero.getText().toString());
            String option = insumos.getSelectedItem().toString();
            if (valuenumber <= 10 && valuenumber >0){
                texto.setText("Usted escogio " + numero.getText().toString() +" "+ insumos.getSelectedItem().toString()+", siendo un total de: $"+ taj.cal(Integer.parseInt(numero.getText().toString()),insumos.getSelectedItem().toString()));
                bt1.setVisibility(View.VISIBLE);
                if (option.equals("Tarjeta bronce")){
                    star.setRating(1);
                }
                if (option.equals("Tarjeta plata")){
                    star.setRating(2);
                }
                if (option.equals("Tarjeta Oro")) {
                    star.setRating(3);
                }
                if (option.equals("Tarjeta Platino")){
                    star.setRating(4);
                }
            }else {
                Toast.makeText(this, "Ingrese un numero desde el 1 hasta el 10", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Debe ingresar un numero", Toast.LENGTH_SHORT).show();
        }



    }

}