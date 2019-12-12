package com.dobon.projectm7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class Registre extends AppCompatActivity {

    EditText nom;
    EditText cognom;
    EditText username;
    EditText contrasenya;
    SharedPreferences prefs = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registre);
    }

    public void registrar(View view) {

        nom = findViewById(R.id.txt_nom);
        cognom = findViewById(R.id.txt_cognom);
        username = findViewById(R.id.txt_username);
        contrasenya = findViewById(R.id.txt_contrasenya);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nom", String.valueOf(nom));
        editor.putString("cognom", String.valueOf(cognom));
        editor.putString("user", String.valueOf(username));
        editor.putString("password", String.valueOf(contrasenya));
        editor.commit();

    }

}
