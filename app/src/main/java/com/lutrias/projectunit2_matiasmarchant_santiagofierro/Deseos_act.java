package com.lutrias.projectunit2_matiasmarchant_santiagofierro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lutrias.projectunit2_matiasmarchant_santiagofierro.database.AdminSQliteOpenHelper;

public class Deseos_act extends AppCompatActivity {
    private EditText code, name, category;
    private Button add, search, upgrade, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deseos);
        loadComponents();
        setupButtons();
    }

    private void loadComponents(){
        code     = findViewById(R.id.ptCode);
        name     = findViewById(R.id.ptnombre);
        category = findViewById(R.id.ptCategoria);
        add      = findViewById(R.id.btnAñadir);
        search   = findViewById(R.id.btnBuscar);
        upgrade  = findViewById(R.id.btnActualizar);
        delete   = findViewById(R.id.btnEliminar);


    }
    private void setupButtons(){
        add.setOnClickListener(this::add);
        search.setOnClickListener(this::searchof);
        upgrade.setOnClickListener(this::update);
        delete.setOnClickListener(this::delete);
    }


    private void add(View v){
        String id        = code.getText().toString();
        String nom       = name.getText().toString();
        String cate      = category.getText().toString();

        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this, "gamecodes",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if (!id.isEmpty()&&!cate.isEmpty()&&!nom.isEmpty()){

            ContentValues cont = new ContentValues();//PERMITE AÑADIR VALORES

            cont.put("id",id);
            cont.put("nombre",nom);
            cont.put("categoria",cate);

            db.insert("wishs",null, cont);
            db.close();


            clean();
            Toast.makeText(getBaseContext(),"Has guardado un juego como deseo!",Toast.LENGTH_SHORT).show();

        }else{
           Toast.makeText(getBaseContext(),"Campos vacios",Toast.LENGTH_LONG).show();
        }

    }

    private void searchof(View v){
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this, "gamecodes",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if (!codigo.isEmpty()){
            Cursor file = db.rawQuery("SELECT nombre, categoria FROM wishs WHERE id = "+codigo,null);
            if (file.moveToFirst()){
                name.setText(file.getString(0));
                category.setText(file.getString(1));
                db.close();
            }else{
                Toast.makeText(getBaseContext(),"No hay ningun juego asociado al codigo en tus deseos",Toast.LENGTH_SHORT).show();
            }
            db.close();
        }else{
            Toast.makeText(getBaseContext(),"Campos vacios",Toast.LENGTH_SHORT).show();
        }

    }

    private void update(View v){
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this, "gamecodes",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String catego = category.getText().toString();

        if (!codigo.isEmpty()&&!nombre.isEmpty()&&!catego.isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("id",codigo);
            cont.put("nombre",nombre);
            cont.put("categoria",catego);

            db.update("wishs",cont,"id = "+codigo,null);
            Toast.makeText(getBaseContext(),"Se actualizo el juego con el codigo: "+codigo,Toast.LENGTH_SHORT).show();
            db.close();
            clean();

        }else{
            Toast.makeText(getBaseContext(),"Campos vacios",Toast.LENGTH_SHORT).show();
        }
    }
    private void delete(View v){
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this, "gamecodes",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if (!codigo.isEmpty()){
            int can = db.delete("wishs","id="+codigo,null);
            db.close();
            clean();
            if (can == 1){
                Toast.makeText(getBaseContext(),"Eliminaste el juego deseado con el codigo: "+ codigo,Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getBaseContext(),"No se encontro el juego deseado",Toast.LENGTH_SHORT).show();
        }
    }






    private void clean(){
        code.setText("");
        name.setText("");
        category.setText("");
    }
}