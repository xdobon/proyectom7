package com.dobon.projectm7;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Registre extends AppCompatActivity {


    EditText nom;
    EditText cognom;
    EditText correuelectronic;
    EditText contrasenya;
    RadioButton home;
    RadioButton dona;
    CheckBox checkBox;
    Button registrar;

    //Variables de los datos
    private String snom ="";
    private String scognom ="";
    private String scorreuelectronic ="";
    private String scontrasenya ="";
    private boolean bhome = false;
    private boolean bdona = false;
    private boolean bcheckBox = false;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registre);
    }
        private void metodoregistrar(){
            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance().getReference();

            nom = findViewById(R.id.txt_nom);
            cognom = findViewById(R.id.txt_cognom);
            correuelectronic = findViewById(R.id.txt_correu);
            contrasenya = findViewById(R.id.txt_contrasenya);
            home = findViewById(R.id.rb_home);
            dona = findViewById(R.id.rb_dona);
            checkBox = findViewById(R.id.checkBox);
            registrar = findViewById(R.id.btn_registrar);

            registrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snom = nom.getText().toString();
                    scognom = cognom.getText().toString();
                    scorreuelectronic = correuelectronic.getText().toString();
                    scontrasenya = contrasenya.getText().toString();

                    if (!snom.isEmpty() && !scognom.isEmpty() && !scorreuelectronic.isEmpty() && scontrasenya.isEmpty()) {
                        registerUser();
                    } else {
                        Toast.makeText(Registre.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    private void registerUser(){
     mAuth.createUserWithEmailAndPassword(scorreuelectronic,scontrasenya).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 Map<String, Object> map = new HashMap<>();
                 map.put("nom",nom);
                 map.put("cognom",cognom);
                 map.put("correuelectronic",correuelectronic);
                 map.put("contrasenya",contrasenya);

                 String id = mAuth.getCurrentUser().getUid();
                 mDatabase.child("Users").child(id).setValue(map);

             }else{
                 Toast.makeText(Registre.this, "No se ha podido registrar este usuario.", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }



}
