package com.example.tcc_after.UI.company.company_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;

public class CompanyRegisterActivity01 extends AppCompatActivity {

    EditText nicknameEmpresa, emailEmpresa, cnpjEmpresa, confEmailEmpresa;
    Button avancar01;

    public static String cnpjCadastroEmpresa, emailCadastroEmpresa,  nicknameCadastroEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register01);

        nicknameEmpresa = findViewById(R.id.etCompanyRegister_Nickname);
        emailEmpresa = findViewById(R.id.etCompanyRegister_Email);
        cnpjEmpresa = findViewById(R.id.etCompanyRegister_Cnpj);
        confEmailEmpresa = findViewById(R.id.etCompanyRegister_ConfEmail);
        avancar01 = findViewById(R.id.btnCompanyRegister_01);

        avancar01.setOnClickListener(view ->{

            if (validateFields()){

                nicknameCadastroEmpresa = nicknameEmpresa.getText().toString();
                emailCadastroEmpresa = emailEmpresa.getText().toString();
                cnpjCadastroEmpresa = cnpjEmpresa.getText().toString();

                Intent intent = new Intent(CompanyRegisterActivity01.this, CompanyRegisterPasswordActivity.class);
                startActivity(intent);
            }

        });


    }

    private boolean validateFields (){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se os campos obrigatorios estao preenchidos
        if (nicknameEmpresa.getText().length() == 0  && emailEmpresa.getText().length() == 0 && cnpjEmpresa.getText().length() == 0){
            Toast.makeText(CompanyRegisterActivity01.this, "Você precisa preencher os campos", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** nome **/
        //verifica se o campo de nome esta preenchido
        if (nicknameEmpresa.getText().length() == 0){
            nicknameEmpresa.setError( "Voce precisa prencher o campo nome");
            valid = false;
        }
        //verifica se o campo de nickname contem mais de 100 caracteres
        if (nicknameEmpresa.getText().length() > 100){
            Toast.makeText(CompanyRegisterActivity01.this, "Nome inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** nickname **/
        //verifica se o campos de nickname esta preenchido
        if (cnpjEmpresa.getText().length() == 0){
           cnpjEmpresa.setError("Voce precisa prencher o campo de CNPJ");
            valid = false;
        }
        //verifica se o campo de nickname contem mais de 25 caracteres
        if (cnpjEmpresa.getText().length() > 25){
            Toast.makeText(CompanyRegisterActivity01.this, "CNPJ inválido", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** email **/
        //verifica se o campo de email esta preenchido
        if (emailEmpresa.getText().length() == 0) {
            emailEmpresa.setError("Voce precisa prencher o campo email");
            valid = false;
        }
        //verifica se o campo de emil contem mais de 200 caracteres
        if (emailEmpresa.getText().length() > 200){
            Toast.makeText(CompanyRegisterActivity01.this, "Email inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        //verifica se o email e a confirmacao são iguais
        if (!emailEmpresa.getText().toString().equals(confEmailEmpresa.getText().toString())){
            Toast.makeText(CompanyRegisterActivity01.this, "Reveja os campos de email", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }
}