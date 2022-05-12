package com.example.tcc_after.UI.company.company_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;

public class CompanyRegisterPasswordActivity extends AppCompatActivity {

    private EditText etSenha, etConfSenha;
    private TextView tvEntrarConta;
    private Button avancar02;

    public static String senhaCadastroEmpresa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register02);

        etSenha = findViewById(R.id.etCompanyRegister_Password);
        etConfSenha = findViewById(R.id.etCompanyRegister_ConfPassword);
//        tvEntrarConta = findViewById(R.id.tvCompanyRegister_LoginPerfil);
        avancar02 = findViewById(R.id.btnCompanyRegister_02);


        avancar02.setOnClickListener(view -> {
            if (validateFields()){
                senhaCadastroEmpresa = etSenha.getText().toString();

                Intent intent = new Intent(CompanyRegisterPasswordActivity.this, PhotoCompanyRegisterActivity.class);
                startActivity(intent);
            }
        });

//        tvEntrarConta.setOnClickListener(view -> {
//            Intent intent = new Intent(CompanyRegisterPasswordActivity.this, LoginActivity.class);
//            startActivity(intent);
//
//        });

    }

    private boolean validateFields (){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        /** email **/
        //verifica se o campo de email esta preenchido
        if (etSenha.getText().length() == 0) {
            etSenha.setError("Voce precisa prencher o campo senha");
            valid = false;
        }
        //verifica se o campo de emil contem mais de 200 caracteres
        if (etSenha.getText().length() > 200){
            Toast.makeText(CompanyRegisterPasswordActivity.this, "Email inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        //verifica se o email e a confirmacao são iguais
        if (!etSenha.getText().toString().equals(etConfSenha.getText().toString())){
            Toast.makeText(CompanyRegisterPasswordActivity.this, "Reveja os campos de email", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }

}