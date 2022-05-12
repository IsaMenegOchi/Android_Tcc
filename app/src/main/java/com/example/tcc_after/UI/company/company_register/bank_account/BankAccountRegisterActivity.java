package com.example.tcc_after.UI.company.company_register.bank_account;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.CompanyVerificationActivity;
import com.example.tcc_after.UI.company.company_register.PhotoCompanyRegisterActivity;
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.model.Banco;
import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.model.evento.TipoDeConta;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankAccountRegisterActivity extends AppCompatActivity {

    private EditText etAgenciaEmpresa, etContaEmpresa, etDigitoEmpresa;

    private Spinner spBancoEmpresa, spTipoContaEmpresa;

    private Button btnCadastrarContaBancaria;

    int idBanco, idTipoConta;
    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register_bank_account);

        spBancoEmpresa = findViewById(R.id.spCompanyRegisterBankAccount_Bank);
        etAgenciaEmpresa = findViewById(R.id.etCompanyRegisterBankAccount_Agency);
        etContaEmpresa = findViewById(R.id.etCompanyRegisterBankAccount_Account);
        etDigitoEmpresa = findViewById(R.id.etCompanyRegisterBankAccount_Digit);
        spTipoContaEmpresa= findViewById(R.id.spCompanyRegisterBankAccount_TypeOfAccount);

        btnCadastrarContaBancaria = findViewById(R.id.btnCompanyRegisterBankAccount);

        /** CRIANDO UM ALERT DIÁLOGO **/

        //*FAZENDO LISTAGEM DE CONTA BANCÁRIA
        Call<List<Banco>> getBancos = routerInterface.getBancos();
        getBancos.enqueue(

                new Callback<List<Banco>>() {
                    @Override
                    public void onResponse(Call<List<Banco>> call, Response<List<Banco>> response) {


                        if(response.isSuccessful()){

                            List<Banco> listBanco = new ArrayList<Banco>();

                            List<String> listNomeBanco = new ArrayList<String>();
                            List<Integer> listIdBanco = new ArrayList<Integer>();


                            listBanco = response.body();

                            for(int i = 0 ; i < listBanco.size(); i++){

                                listNomeBanco.add(listBanco.get(i).getNomeBanco());
                                listIdBanco.add(listBanco.get(i).getIdBancoConta());

                            }

                            ArrayAdapter arrayAdapter = new ArrayAdapter(BankAccountRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeBanco);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spBancoEmpresa.setAdapter(arrayAdapter);

                            spBancoEmpresa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                    for(int ii = 0 ; ii < listIdBanco.size(); ii++){

                                        if (spBancoEmpresa.getSelectedItemPosition() == listIdBanco.get(ii)){
                                            idBanco = listIdBanco.get(ii);
                                        }
                                    }
                                    Log.d("teste", "onItemSelected: " + idBanco);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                    Toast.makeText(BankAccountRegisterActivity.this, "Escolha uma conta bancária", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Banco>> call, Throwable t) {
                        Log.d("ErrorEvento", "onFailure: Bancos não foram capturadas");
                    }
                }

        );

        Call<List<TipoDeConta>> getTiposConta = routerInterface.getTiposConta();
        getTiposConta.enqueue(

                new Callback<List<TipoDeConta>>() {
                    @Override
                    public void onResponse(Call<List<TipoDeConta>> call, Response<List<TipoDeConta>> response) {


                        if(response.isSuccessful()){

                            List<TipoDeConta> listTipoConta = new ArrayList<TipoDeConta>();

                            List<String> listNomeTipoConta = new ArrayList<String>();
                            List<Integer> listIdTipoConta = new ArrayList<Integer>();


                            listTipoConta = response.body();

                            for(int i = 0 ; i < listTipoConta.size(); i++){

                                listNomeTipoConta.add(listTipoConta.get(i).getNomeTipo());
                                listIdTipoConta.add(listTipoConta.get(i).getIdTipoConta());

                            }

                            ArrayAdapter arrayAdapter = new ArrayAdapter(BankAccountRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeTipoConta);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spBancoEmpresa.setAdapter(arrayAdapter);

                            spBancoEmpresa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                    for(int ii = 0 ; ii < listIdTipoConta.size(); ii++){

                                        if (spBancoEmpresa.getSelectedItemPosition() == listIdTipoConta.get(ii)){
                                            idBanco = listIdTipoConta.get(ii);
                                        }
                                    }
                                    Log.d("teste", "onItemSelected: " + idBanco);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                    Toast.makeText(BankAccountRegisterActivity.this, "Escolha uma conta bancária", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }

                    @Override
                    public void onFailure(Call<List<TipoDeConta>> call, Throwable t) {
                        Log.d("ErrorEvento", "onFailure: Bancos não foram capturadas");
                    }
                }
        );

        btnCadastrarContaBancaria.setOnClickListener(view -> {

            ContaBancaria contaBancaria = new ContaBancaria();
            contaBancaria.setAgenciaCB(etAgenciaEmpresa.getText().toString());
            contaBancaria.setDigitoCB(etDigitoEmpresa.getText().toString());
            contaBancaria.setIdBancoContaCB(idBanco);
            contaBancaria.setIdTipoCB(idTipoConta);
            contaBancaria.setNumeroCB(etContaEmpresa.getText().toString());

            routerInterface = APIUtil.getApiInterface();
            addContaBancaria(contaBancaria);


//            Toast.makeText(this,"VOce esta cadastrando",Toast.LENGTH_LONG).show();

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(BankAccountRegisterActivity.this)
                    .setMessage("Deseja adicionar outra conta bancária?")
                    .setPositiveButton("Sim", (dialog1, witch)->{
                        Intent intent = new Intent(BankAccountRegisterActivity.this, BankAccountRegisterActivity.class);
                        startActivity(intent);
                    })
                    .setNegativeButton("Não", (dialog1, witch)->{
                        Intent intent = new Intent(BankAccountRegisterActivity.this, CompanyVerificationActivity.class);
                        startActivity(intent);
                    });
            alertDialog.show();

        });


    }

    public void addContaBancaria(ContaBancaria contaBancaria) {

        //! Mudar id da empresa
        //calback - classe do java
        Call<ContaBancaria> call = routerInterface.addContaBancaria(1, contaBancaria);
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