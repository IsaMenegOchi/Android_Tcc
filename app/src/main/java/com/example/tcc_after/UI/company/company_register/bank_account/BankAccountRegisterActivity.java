package com.example.tcc_after.UI.company.company_register.bank_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.CompanyVerificationActivity;
import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankAccountRegisterActivity extends AppCompatActivity {

    private EditText etBancoEmpresa, etAgenciaEmpresa, etContaEmpreasa, etDigitoEmpresa, etTipoContaEmpresa;

    private Button btnCadastrarContaBancaria;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register_bank_account);

        etBancoEmpresa = findViewById(R.id.etCompanyRegisterBankAccount_Bank);
        etAgenciaEmpresa = findViewById(R.id.etCompanyRegisterBankAccount_Agency);
        etContaEmpreasa = findViewById(R.id.etCompanyRegisterBankAccount_Account);
        etDigitoEmpresa = findViewById(R.id.etCompanyRegisterBankAccount_Digit);
        etTipoContaEmpresa= findViewById(R.id.etCompanyRegisterBankAccount_TypeOfAccount);

        btnCadastrarContaBancaria = findViewById(R.id.btnCompanyRegisterBankAccount);

        /** CRIANDO UM ALERT DIÁLOGO **/

        btnCadastrarContaBancaria.setOnClickListener(view -> {

            ContaBancaria contaBancaria = new ContaBancaria();
            contaBancaria.setAgenciaCB(Integer.parseInt(etAgenciaEmpresa.getText().toString()));
            contaBancaria.setDigitoCB(Integer.parseInt(etDigitoEmpresa.getText().toString()));
            contaBancaria.setNomeBancoCB(etBancoEmpresa.getText().toString());
            contaBancaria.setNomeTipoCB(etTipoContaEmpresa.getText().toString());
            contaBancaria.setNumeroCB(Integer.parseInt(etDigitoEmpresa.getText().toString()));

            routerInterface = APIUtil.getUsuarioInterface();
            addContaBancaria(contaBancaria);

            Log.d("socorro", "Ta apertando");

//            Toast.makeText(this,"VOce esta cadastrando",Toast.LENGTH_LONG).show();

//            Intent intent = new Intent(BankAccountRegisterActivity.this, CompanyVerificationActivity.class);
//            startActivity(intent);

        });


    }

    public void addContaBancaria(ContaBancaria contaBancaria) {

        //calback - classe do java
        Call<ContaBancaria> call = routerInterface.addContaBancaria(contaBancaria);
        call.enqueue(new Callback<ContaBancaria>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<ContaBancaria> call, Response<ContaBancaria> response) {
                Toast.makeText(BankAccountRegisterActivity.this, "Conta bancária inserida com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ContaBancaria> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }//fim do onFailure
        }); //fim do enqueue e do calback
    }// fim da funcao addEmprea
}