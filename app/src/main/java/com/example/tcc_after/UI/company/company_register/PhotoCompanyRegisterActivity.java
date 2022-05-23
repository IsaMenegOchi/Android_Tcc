package com.example.tcc_after.UI.company.company_register;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.MainCompanyActivity;
import com.example.tcc_after.UI.company.company_register.bank_account.BankAccountRegisterActivity;
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.model.empresa.Empresa;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoCompanyRegisterActivity extends AppCompatActivity {

    private ImageView photoPerfil, photoCover;
    private Button btnFinalizar;
    private EditText etBiografia;
    private TextView tvPularEtapa;

    RouterInterface routerInterface;
    private final int CODEIMAGE = 1;

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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == this.RESULT_CANCELED){
//            return;
//        }
//
//        if (requestCode == CODEIMAGE){
//
//            if (data != null){
//                Uri uri = data.getData();
//                //?Imagens vetoriais - desenhso que conseguimos adicionar cor, mudar forma, aumentar e diminuir componentes sem perda de resolução
//                //? Imagens de bitMap - Quando tiramos uma foto, quando ela é realista e estática (resolucao da a densidade de pixels na imagem)
//
//                try {
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
//                    photoCover.setImageBitmap(bitmap);
//
//                    Log.d("imagem", "onActivityResult: imagem alterada");
//
//                    uploadImageRetroFit(bitmap);
//                }
//
//                catch (IOException e) {
//                    e.printStackTrace();
//                    Log.d("imagem", e.getMessage());
//                }
//            }
//        }
//    }// fim do matodo do on activity result


    //* FUNCOES DE MODEL
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

    //* ABRIR GALERIA
    public void openGalery(){

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        //
        startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODEIMAGE);
    }


//    private void uploadImageRetroFit(Bitmap bitmap) {
//
//        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat. JPEG, 100, byteArrayInputStream);
//
//        String file = Base64.encodeToString(byteArrayInputStream.toByteArray(), Base64.DEFAULT);
//
//
//        Call<String> upload =  RouterInterface.uploadImage(file);
//        upload.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful()){
//                    Toast.makeText(PhotoCompanyRegisterActivity.this, "Foi vei hehe", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("testeErro", "onFailure: " + t);
//
//            }
//        });
//
//    }

    //* FUNÇÃO DE VALIDAR DADOS
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