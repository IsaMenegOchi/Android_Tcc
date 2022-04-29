package com.example.tcc_after.UI.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.FeedActivity;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterActivity01;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterPasswordActivity;
import com.example.tcc_after.UI.event.EventRegisterActivity;

public class CompanyVerificationActivity extends AppCompatActivity {

    private Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_verification);

        btnAvancar = findViewById(R.id.btnCompanyVerification);

        btnAvancar.setOnClickListener(view -> {
            Intent intent = new Intent(CompanyVerificationActivity.this, EventRegisterActivity.class);
            startActivity(intent);
        });
    }
}