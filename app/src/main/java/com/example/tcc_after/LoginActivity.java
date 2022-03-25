package com.example.tcc_after;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    private TextView tvLoginRegisterNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        tvLoginRegisterNow.setOnClickListener(view->{
//            Intent telaCadastro = new Intent(
//                    MainActivity.this,
//                    CadastroUsuario.class
//            );
//
//            startActivity(telaCadastro);
            startActivity(new Intent(
                    LoginActivity.this,ChoosePerfil.class
            ));
        });
    }
}