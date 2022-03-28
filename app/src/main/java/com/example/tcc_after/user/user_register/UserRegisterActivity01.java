package com.example.tcc_after.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tcc_after.R;

public class UserRegisterActivity01 extends AppCompatActivity {

    private Button btnAvancar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register01);

        btnAvancar1 = findViewById(R.id.fowardButton1);

        btnAvancar1.setOnClickListener(view->{
            startActivity(new Intent(
                    UserRegisterActivity01.this, UserRegisterActivity02.class
            ));
        });
    }
}