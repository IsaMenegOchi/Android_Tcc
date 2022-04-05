package com.example.tcc_after;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.tcc_after.company.company_register.CompanyRegisterActivity01;
import com.example.tcc_after.user.user_register.UserRegisterActivity01;

public class ChoosePerfil extends AppCompatActivity {


    private ImageView imgBussinesIcon;
    private ImageView imgBgCompanyIcon;
    private ImageView imgBgUserIcon;
    private ImageView imgUserIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_perfil);

        imgBgUserIcon = findViewById(R.id.bgCompany);
        imgBgCompanyIcon = findViewById(R.id.bgUser);
        imgUserIcon = findViewById(R.id.userIconChooseRegister);
        imgBussinesIcon = findViewById(R.id.bussinesIconChooseRegister);

// AREA DE MUDANÇA DE TELA

        imgBussinesIcon.setOnClickListener(view->{
            startActivity(new Intent(
                    ChoosePerfil.this, CompanyRegisterActivity01.class
            ));
        });

        imgBgCompanyIcon.setOnClickListener(view->{
            startActivity(new Intent(
                ChoosePerfil.this, CompanyRegisterActivity01.class
            ));
        });

        imgBgUserIcon.setOnClickListener(view->{
            startActivity(new Intent(
                    ChoosePerfil.this, UserRegisterActivity01.class
            ));
        });

        imgUserIcon.setOnClickListener(view->{
            startActivity(new Intent(
                    ChoosePerfil.this, UserRegisterActivity01.class
            ));
        });
    }
}