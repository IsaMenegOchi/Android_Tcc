package com.example.tcc_after.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcc_after.R;

public class LoginActivity extends AppCompatActivity {

    private TextView tvLoginRegisterNow;

    private EditText etSenha, etEmail;

    private ImageView ivVerSenha;

    private int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvLoginRegisterNow = findViewById(R.id.tvLogin_RegisterNow);
        etEmail = findViewById(R.id.etLogin_Email);
        etSenha = findViewById(R.id.etLogin_Passaword);
        ivVerSenha = findViewById(R.id.ivLogin_SeePassaword);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ivVerSenha.setOnClickListener(view -> {
            contador++;
            if (contador % 2 == 0){
                etSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                ivVerSenha.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility_off));
            }
            if (contador % 2 != 0){
                //mostrar
                etSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                ivVerSenha.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility));
            }
        });


        tvLoginRegisterNow.setOnClickListener(view->{
            startActivity(new Intent(
                    LoginActivity.this, ChoosePerfil.class
            ));
        });
    }
}