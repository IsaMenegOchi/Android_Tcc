package com.example.tcc_after.UI.company.company_register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.MainCompanyActivity;
import com.example.tcc_after.UI.company.company_register.bank_account.BankAccountRegisterActivity;
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.model.empresa.Empresa;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoCompanyRegisterActivity extends AppCompatActivity {

    private ImageView photoPerfil;
    private ImageView photoCover;
    private Button btnFinalizar;
    private EditText etBiografia;
    private TextView tvPularEtapa;

    RouterInterface routerInterface;
    private final int CODE_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_photo_register);

        photoPerfil = findViewById(R.id.ivCompanyPhotoRegister_Perfil);
        photoCover = findViewById(R.id.ivCompanyPhotoRegister_Cover);
        btnFinalizar = findViewById(R.id.btnCompanyPhotoRegister_Add);
        etBiografia = findViewById(R.id.etCompanyPhotoRegister_Description);
        tvPularEtapa = findViewById(R.id.tvCompanyPhotoRegister_Skip);

        btnFinalizar.setOnClickListener(view -> {

            if (validateFields()){
                Empresa empresa = new Empresa();
                empresa.setNicknameEmpresa(CompanyRegisterActivity01.nicknameCadastroEmpresa);
                empresa.setCnpjEmpresa(CompanyRegisterActivity01.cnpjCadastroEmpresa);
//                empresa.setImagemPerfilEmpresa(photoPerfil);
//                empresa.setImagemFundoEmpresa(photoCover);
                empresa.setEmailEmpresa(CompanyRegisterActivity01.emailCadastroEmpresa);
                empresa.setSenhaEmpresa(CompanyRegisterPasswordActivity.senhaCadastroEmpresa);
                empresa.setBiografiaEmpresa(etBiografia.getText().toString());

                //PEDE A ROUTER INTERFACE PARA INSERIR NO BANCO DE DADOS O QUE PASSAMOS
                routerInterface = APIUtil.getApiInterface();
                addEmpresa(empresa);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PhotoCompanyRegisterActivity.this)
                        .setMessage("Deseja adicionar uma conta bancária?")
                        .setPositiveButton("Sim", (dialog1, witch)->{
                            Intent intent = new Intent(PhotoCompanyRegisterActivity.this, BankAccountRegisterActivity.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("Não", (dialog1, witch)->{
                            Intent intent = new Intent(PhotoCompanyRegisterActivity.this, MainCompanyActivity.class);
                            startActivity(intent);
                        });
                alertDialog.show();
            }

        });

        /** EXECUTAR QUANDO CLICAR NO BOTAO DE FOTO DE FUNDO **/
        photoPerfil.setOnClickListener( view -> {
            openGalery();
        });
//
        /** EXECUTAR QUANDO CLICAR NO BOTAO DE FOTO DE PERFIL **/
        photoCover.setOnClickListener(view -> {
            openGalery();
        });

        tvPularEtapa.setOnClickListener(view -> {

            if (validateFields()) {
                Empresa empresa = new Empresa();
                empresa.setNicknameEmpresa(CompanyRegisterActivity01.nicknameCadastroEmpresa);
                empresa.setCnpjEmpresa(CompanyRegisterActivity01.cnpjCadastroEmpresa);
                empresa.setEmailEmpresa(CompanyRegisterActivity01.emailCadastroEmpresa);
                empresa.setSenhaEmpresa(CompanyRegisterPasswordActivity.senhaCadastroEmpresa);

                //PEDE A ROUTER INTERFACE PARA INSERIR NO BANCO DE DADOS O QUE PASSAMOS
                routerInterface = APIUtil.getApiInterface();
                addEmpresa(empresa);

                Intent intent = new Intent(PhotoCompanyRegisterActivity.this, BankAccountRegisterActivity.class);
                startActivity(intent);
            }
        });

    }


    /** FUNCOES DE MODEL **/
    public void addEmpresa(Empresa empresa) {

        //calback - classe do java
        Call<Empresa> call = routerInterface.addEmpresa(empresa);
        call.enqueue(new Callback<Empresa>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                Toast.makeText(PhotoCompanyRegisterActivity.this, "Empresa inserida com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Empresa> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }//fim do onFailure
        });
    }// fim da funcao addEmprea

    public void openGalery(){

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        this.startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE);
    }

    /** funcao de validar dados **/
    private boolean validateFields(){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se o campo de biografia contem mais de 200 caracteres
        if (etBiografia.getText().length() > 200){
            Toast.makeText(PhotoCompanyRegisterActivity.this, "Data inserida é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }
}