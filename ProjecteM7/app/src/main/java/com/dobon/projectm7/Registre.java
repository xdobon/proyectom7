package com.dobon.projectm7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class Registre extends AppCompatActivity {

    EditText nom;
    EditText cognom;
    EditText username;
    EditText contrasenya;
    RadioButton home;
    RadioButton dona;
    SeekBar seekBar;
    Spinner sp_frase;
    CheckBox checkBox;
    Button btn_registrar;
    SharedPreferences prefs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registre);

        prefs  = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);
    }

    public void registrar(View view) {

        nom = findViewById(R.id.txt_nom);
        cognom = findViewById(R.id.txt_cognom);
        username = findViewById(R.id.txt_username);
        contrasenya = findViewById(R.id.txt_contrasenya);
        home = findViewById(R.id.rb_home);
        dona= findViewById(R.id.rb_dona);
        seekBar= findViewById(R.id.seekBar);
        sp_frase= findViewById(R.id.sp_frase);
        checkBox= findViewById(R.id.checkBox);


        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nom", String.valueOf(nom));
        editor.putString("cognom", String.valueOf(cognom));
        editor.putString("user", String.valueOf(username));
        editor.putString("password", String.valueOf(contrasenya));
      /*  editor.putBoolean("home", Boolean.valueOf(home));
        editor.putBoolean("dona", Boolean.valueOf(dona));
        editor.putBoolean("seekBar", Boolean.valueOf(seekBar));
        editor.putBoolean("sp_frase", Boolean.valueOf(sp_frase));
        editor.putBoolean("checkBox", Boolean.valueOf(checkBox));*/
        editor.commit();

    }

}
