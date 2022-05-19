package com.example.tcc_after.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.tcc_after.R;

public class LoginActivity extends AppCompatActivity {


    private TextView tvLoginRegisterNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_login);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        getSupportActionBar().hide();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    tvLoginRegisterNow = findViewById(R.id.tvLogin_RegisterNow);

        tvLoginRegisterNow.setOnClickListener(view->{
            startActivity(new Intent(
                    LoginActivity.this, ChoosePerfil.class
            ));
        });
    }
}