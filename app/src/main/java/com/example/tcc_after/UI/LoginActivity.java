package com.example.tcc_after.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tcc_after.R;

public class LoginActivity extends AppCompatActivity {


    private TextView tvLoginRegisterNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        getSupportActionBar().hide();

    tvLoginRegisterNow = findViewById(R.id.tvLoginRegisterNow);

        tvLoginRegisterNow.setOnClickListener(view->{
//            Intent loginScreen = new Intent(
//                    LoginActivity.this,
//                    ChoosePerfil.class
//            );
////
//            startActivity(telaCadastro);
            startActivity(new Intent(
                    LoginActivity.this, ChoosePerfil.class
            ));
        });
    }
}