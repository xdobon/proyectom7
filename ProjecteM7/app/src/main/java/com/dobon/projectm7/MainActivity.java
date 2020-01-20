package com.dobon.projectm7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etusername;
    EditText etpassword;
    Button login;
    Button registre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etusername = findViewById(R.id.txt_User);
        etpassword = findViewById(R.id.txt_Password);
        login = findViewById(R.id.btn_signup);
        registre = findViewById(R.id.btn_registre);

    }
    public void formulariRegistre(View view) {
        Intent intent = new Intent(this, Registre.class);

            startActivity(intent);



    }
    public void login(View view) {

        final String username = etusername.getText().toString();
        final String password = etpassword.getText().toString();

        if(username.equals("admin") && password.equals("admin")){

            saveLoginSharedPreferences(username);

            Intent intent = new Intent(this, principal.class);

            startActivity(intent);

        }else{
            Toast toast =
                    Toast.makeText(getApplicationContext(),
                            "Usuari o contrasenya incorrectes.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
            toast.show();
        }



    }
    private void saveLoginSharedPreferences(String username){
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);//guardar los datos
        editor.commit();
        editor.apply();

    }

}
