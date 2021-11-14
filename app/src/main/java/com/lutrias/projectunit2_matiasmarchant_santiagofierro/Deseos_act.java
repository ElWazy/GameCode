package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.database.AdminSQliteOpenHelper;

public class Deseos_act extends AppCompatActivity {
    private EditText name, category;
    private Button add, search, upgrade, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deseos);
        loadComponents();
        setupButtons();
    }

    private void loadComponents(){
        name = findViewById(R.id.ptnombre);
        category = findViewById(R.id.ptCategoria);
        add      = findViewById(R.id.btnAñadir);
        search   = findViewById(R.id.btnBuscar);
        upgrade  = findViewById(R.id.btnActualizar);
        delete   = findViewById(R.id.btnEliminar);


    }


    private void setupButtons(){
        add.setOnClickListener(this::add);
    }


    private void add(View v){
        String nombre    = name.getText().toString();
        String categoria = category.getText().toString();
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this, "gamecode",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if (!nombre.isEmpty()&&!categoria.isEmpty()){

            ContentValues cont = new ContentValues();//PERMITE AÑADIR VALORES


            cont.put("nombre",nombre);
            cont.put("categoria",categoria);

            db.insert("wish",null, cont);
            db.close();

            clear();
            Toast.makeText(getBaseContext(),"Has guardado un juego como deseo!",Toast.LENGTH_SHORT).show();

        }else{
           Toast.makeText(getBaseContext(),"Campos vacios",Toast.LENGTH_SHORT).show();
        }

    }





    private void clear(){
        name.setText("");
        category.setText("");
    }
}