package com.example.tcc_after.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterActivity01;
import com.example.tcc_after.UI.user.user_register.UserRegisterActivity01;

public class ChoosePerfil extends AppCompatActivity {


    private ImageView imgBussinesIcon;
    private ImageView imgBgCompanyIcon;
    private ImageView imgBgUserIcon;
    private ImageView imgUserIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_perfil);

        imgBgUserIcon = findViewById(R.id.tvChoosePerfil_BgUser);
        imgBgCompanyIcon = findViewById(R.id.ivChoosePerfil_BgCompany);
        imgUserIcon = findViewById(R.id.tvChoosePerfil_UserIcon);
        imgBussinesIcon = findViewById(R.id.ivChoosePerfil_CompanyIcon);

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