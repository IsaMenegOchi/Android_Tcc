package com.example.tcc_after.UI.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.company_register.bank_account.BankAccountRegisterActivity;
import com.example.tcc_after.model.empresa.ContaBancaria;
import com.example.tcc_after.model.empresa.Empresa;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPerfilCompanyActivity extends AppCompatActivity {

    EditText nickname, biografia, senha, email, cnpj;

    TextView contaBancaria1, contaBancaria2, contaBancaria3, contaBancaria4, addContaAviso;
    Button btnCancel, btnSave, btnAdd1, btnAdd2, btnAdd3;

    RouterInterface routerInterface;

    List<Empresa> listEmpresa = new ArrayList<Empresa>();
    List<ContaBancaria> listContaBancaria = new ArrayList<ContaBancaria>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_edit_perfil);

        int idEmpresa = 1;
        nickname = findViewById(R.id.etCompanyEditPerfil_Nickname);
        biografia = findViewById(R.id.etCompanyEditPerfil_Description);
        cnpj = findViewById(R.id.etCompanyEditPerfil_cnpj);
        email = findViewById(R.id.etCompanyEditPerfil_Email);
        senha = findViewById(R.id.etCompanyEditPerfil_Password);


        contaBancaria1 = findViewById(R.id.tvCompanyEditPerfil_BankAccount1);
        contaBancaria2 = findViewById(R.id.tvCompanyEditPerfil_BankAccount2);
        contaBancaria3 = findViewById(R.id.tvCompanyEditPerfil_BankAccount3);
        contaBancaria4 = findViewById(R.id.tvCompanyEditPerfil_BankAccount4);
        addContaAviso = findViewById(R.id.tvCompanyEditPerfil_AddAccountWarning);

        btnAdd1 = findViewById(R.id.btnCompanyEditPerfil_Plus1);
        btnAdd2 = findViewById(R.id.btnCompanyEditPerfil_Plus2);
        btnAdd3 = findViewById(R.id.btnCompanyEditPerfil_Plus3);

        btnSave = findViewById(R.id.btnCompanyEditPerfil_Save);
        btnCancel = findViewById(R.id.btnCompanyEditPerfil_Cancel);


        routerInterface = APIUtil.getApiInterface();
        Call<List<Empresa>> getEmpresaPorId = routerInterface.getEmpresaPorId(idEmpresa);
        getEmpresaPorId.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {

                if (response.isSuccessful()){
                    listEmpresa = response.body();
                    Log.d("teste", "onResponse: " + response);

                    int idEmpresa = listEmpresa.get(0).getIdEmpresa();
                    cnpj.setText(listEmpresa.get(0).getCnpjEmpresa());
                    nickname.setText(listEmpresa.get(0).getPerfil().getNicknamePerfil());
                    biografia.setText(listEmpresa.get(0).getPerfil().getBiografiaPerfil());
                    senha.setText(listEmpresa.get(0).getPerfil().getSenhaPerfil());
                    email.setText(listEmpresa.get(0).getPerfil().getEmailPerfil());

                    Call<List<ContaBancaria>> getContaBancariaPorId = routerInterface.getContaBancariaPorId(idEmpresa);
                    getContaBancariaPorId.enqueue(new Callback<List<ContaBancaria>>() {
                        @Override
                        public void onResponse(Call<List<ContaBancaria>> call, Response<List<ContaBancaria>> response) {
                            if (response.isSuccessful()){
                                listContaBancaria = response.body();
                                AtomicInteger idContaBancaria = new AtomicInteger();
                                Intent intent = new Intent();
                                switch (listContaBancaria.size()){

                                    case (0):
                                        contaBancaria1.setVisibility(View.GONE);
                                        contaBancaria2.setVisibility(View.GONE);
                                        contaBancaria3.setVisibility(View.GONE);
                                        contaBancaria4.setVisibility(View.GONE);
                                        btnAdd1.setVisibility(View.GONE);
                                        addContaAviso.setVisibility(View.VISIBLE);
                                        addContaAviso.setOnClickListener(view ->{
                                            intent.putExtra("idEmpresa", idEmpresa);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, BankAccountRegisterActivity.class));
                                        });

                                    case (1):
                                        contaBancaria1.setText(listContaBancaria.get(0).getNumeroCB());
                                        contaBancaria2.setVisibility(View.GONE);
                                        contaBancaria3.setVisibility(View.GONE);
                                        contaBancaria4.setVisibility(View.GONE);
                                        btnAdd1.setOnClickListener(view -> {
                                            intent.putExtra("idEmpresa", idEmpresa);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, BankAccountRegisterActivity.class));
                                        });

                                    break;

                                    case (2):
                                        contaBancaria1.setText(listContaBancaria.get(0).getNumeroCB());
                                        contaBancaria2.setText(listContaBancaria.get(1).getNumeroCB());
                                        contaBancaria3.setVisibility(View.GONE);
                                        contaBancaria4.setVisibility(View.GONE);
                                        btnAdd1.setVisibility(View.GONE);
                                        btnAdd2.setVisibility(View.VISIBLE);
                                        btnAdd2.setOnClickListener(view ->{
                                            intent.putExtra("idEmpresa", idEmpresa);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, BankAccountRegisterActivity.class));
                                        });
                                        btnAdd3.setVisibility(View.GONE);

                                    break;

                                    case (3):
                                        contaBancaria1.setText(listContaBancaria.get(0).getNumeroCB());
                                        contaBancaria1.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(0).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        contaBancaria2.setText(listContaBancaria.get(1).getNumeroCB());
                                        contaBancaria2.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(1).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        contaBancaria3.setText(listContaBancaria.get(2).getNumeroCB());
                                        contaBancaria3.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(2).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        contaBancaria4.setVisibility(View.GONE);
                                        btnAdd1.setVisibility(View.GONE);
                                        btnAdd2.setVisibility(View.GONE);
                                        btnAdd3.setVisibility(View.VISIBLE);
                                        btnAdd3.setOnClickListener(view ->{
                                            intent.putExtra("idEmpresa", idEmpresa);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, BankAccountRegisterActivity.class));
                                        });

                                    break;

                                    case (4):

                                        contaBancaria1.setText(listContaBancaria.get(0).getNumeroCB());
                                        contaBancaria1.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(0).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        contaBancaria2.setText(listContaBancaria.get(1).getNumeroCB());
                                        contaBancaria2.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(1).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        contaBancaria3.setText(listContaBancaria.get(2).getNumeroCB());
                                        contaBancaria3.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(2).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        contaBancaria4.setText(listContaBancaria.get(3).getNumeroCB());
                                        contaBancaria4.setOnClickListener(view -> {
                                            idContaBancaria.set(listContaBancaria.get(3).getIdContaBancaria());
                                            intent.putExtra("idContaBancaria", idContaBancaria);
                                            startActivity(intent.setClass(EditPerfilCompanyActivity.this, EditBankAccount.class));
                                        });

                                        btnAdd1.setVisibility(View.GONE);
                                        btnAdd2.setVisibility(View.GONE);
                                        btnAdd3.setVisibility(View.GONE);
                                    break;
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<List<ContaBancaria>> call, Throwable t) {

                        }
                    });

                    btnSave.setOnClickListener(view -> {
                        Empresa empresa = new Empresa();
                        empresa.setNicknameEmpresa(nickname.getText().toString());
                        empresa.setBiografiaEmpresa(biografia.getText().toString());
                        empresa.setCnpjEmpresa(cnpj.getText().toString());
                        empresa.setEmailEmpresa(email.getText().toString());
                        empresa.setSenhaEmpresa(senha.getText().toString());

                        Call<Empresa> updateEmpresa = routerInterface.updateEmpresa(2, empresa);
                        updateEmpresa.enqueue(new Callback<Empresa>() {
                            @Override
                            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(EditPerfilCompanyActivity.this, "Você editou seu perfil", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Empresa> call, Throwable t) {
                                Toast.makeText(EditPerfilCompanyActivity.this, "Não foi possivel editar seu perfil", Toast.LENGTH_SHORT).show();
                            }
                        });
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Log.d("ErrorEmpresa", "onFailure: nao estamos listando os dados de empresaa");
            }
        });
    }
}