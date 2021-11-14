package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

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
    private Spinner spnInsumos;
    private EditText txtNumber;
    private Button btnBuy, btnCalculate;
    private TextView lblResumen;
    private RatingBar star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        loadComponents();
        setupButtons();
    }
    private void loadComponents() {
        txtNumber    = findViewById(R.id.txtnumber);
        spnInsumos   = findViewById(R.id.spinner2);
        btnBuy       = findViewById(R.id.btnWish);
        lblResumen   = findViewById(R.id.txtresumen);
        btnCalculate = findViewById(R.id.btnCalculate);
        star         = findViewById(R.id.ratingBar);

        btnBuy.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();
        String[] insumos = bundle.getStringArray("Cards");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, insumos);
        spnInsumos.setAdapter(adapter);

    }

    private void setupButtons(){
        btnCalculate.setOnClickListener(this::calcular);
    }

    private void calcular (View v){
        try {
            Card taj = new Card();
            int valuenumber = Integer.parseInt(txtNumber.getText().toString());
            String option = spnInsumos.getSelectedItem().toString();
            if (valuenumber <= 10 && valuenumber >0){
                lblResumen.setText("Usted escogio " + txtNumber.getText().toString() +" "+ spnInsumos.getSelectedItem().toString()+", siendo un total de: $"+ taj.cal(Integer.parseInt(txtNumber.getText().toString()), spnInsumos.getSelectedItem().toString()));
                btnBuy.setVisibility(View.VISIBLE);
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