package com.example.tcc_after.UI.company.company_register.bank_account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankAccountRegisterActivity extends AppCompatActivity {

    private EditText etBancoEmpresa, etAgenciaEmpresa;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_bank_account_register);

        /** CRIANDO UM ALERT DIÁLOGO **/




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