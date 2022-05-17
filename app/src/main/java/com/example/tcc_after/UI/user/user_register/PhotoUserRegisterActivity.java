package com.example.tcc_after.UI.user.user_register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.MainActivity;
import com.example.tcc_after.R;
import com.example.tcc_after.model.usuarioComum.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.util.DateConvert;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoUserRegisterActivity extends AppCompatActivity {

    private ImageView photoPerfil;
    private ImageView photoCover;
    private Button btnFoward;
    private EditText etBiografia;
    private TextView tvPularEtapa;

    private final int CODEIMAGE = 1;
    RouterInterface routerInterface;

    private final int CODE_IMAGE = 100;

    private Bitmap imageBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_photo_register);

        /** ATRIBUINDO OS IDS DOS CAMPOS DO XML AS VARIAVEIS **/
        photoPerfil = findViewById(R.id.ivUserPhotoRegister_Perfil);
        photoCover = findViewById(R.id.ivUserPhotoRegister_Cover);
        btnFoward = findViewById(R.id.btnUserPhotoRegister_Add);
        etBiografia = findViewById(R.id.etUserPhotoRegister_Description);
        tvPularEtapa = findViewById(R.id.tvUserPhotoRegister_Skip);

        /** EXECUTAR QUANDO CLICAR NO BOTAO DE FOTO DE FUNDO **/
        photoPerfil.setOnClickListener( view -> {
            openGalery();
        });

        /** EXECUTAR QUANDO CLICAR NO BOTAO DE FOTO DE PERFIL **/
        photoCover.setOnClickListener(view -> {
            openGalery();
        });

        /** EXECUTAR QUANDO CLICAR NO BOTAO DE FINALIZAR **/
        btnFoward.setOnClickListener(view ->
                {
                    // FAZ A VALIDAÇÃO DOS CAMPOS
                    if (validateFields()){

                        // CRIANDO UMA MODEL DE USUARIO COMUM
                        UsuarioComum usuarioComum = new UsuarioComum();

                        //CHAMANDO AS VARIAVEIS PUBLICAS
                        usuarioComum.setNomeCompletoUsuario(UserRegisterActivity01.nomeCadastroUsuario);
                        usuarioComum.setNicknameUsuario(UserRegisterActivity01.nicknameCadastroUsuario);
                        usuarioComum.setEmailUsuario(UserRegisterActivity01.emailCadastroUsuario);
                        try {
                            usuarioComum.setDataNascUsuario(DateConvert.format.parse(UserRegisterActivity02.dataNascCadastroUsuario));
                        }
                        catch (ParseException e) {
                            e.printStackTrace();
                        }

                        //fotoCapa
                        //fotoFundo
                        usuarioComum.setCep(UserRegisterActivity02.cepCadastroUsuario);
                        usuarioComum.setCidade(UserRegisterActivity02.cidadeCadastroUsuario);
                        usuarioComum.setEstado(UserRegisterActivity02.estadoCadastroUsuario);
                        usuarioComum.setSenhaUsuario(UserRegisterActivity02.senhaCadastroUsuario);
                        usuarioComum.setBiografia(etBiografia.getText().toString());

                        //PEDE A ROUTER INTERFACE PARA INSERIR NO BANCO DE DADOS O QUE PASSAMOS
                        routerInterface = APIUtil.getApiInterface();
                        addUsuario(usuarioComum);

                        //REDIRECIONANDO A OUTRA TELA
                        Intent intent = new Intent(PhotoUserRegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }//fim do if
                }//fim da view
        ); //fim do click listener

        tvPularEtapa.setOnClickListener(view ->
                {
                    // FAZ A VALIDAÇÃO DOS CAMPOS
                    if (validateFields()){

                        // CRIANDO UMA MODEL DE USUARIO COMUM
                        UsuarioComum usuarioComum = new UsuarioComum();

                        //CHAMANDO AS VARIAVEIS PUBLICAS
                        usuarioComum.setNomeCompletoUsuario(UserRegisterActivity01.nomeCadastroUsuario);
                        usuarioComum.setNicknameUsuario(UserRegisterActivity01.nicknameCadastroUsuario);
                        usuarioComum.setEmailUsuario(UserRegisterActivity01.emailCadastroUsuario);
                        try {
                            usuarioComum.setDataNascUsuario(DateConvert.format.parse(UserRegisterActivity02.dataNascCadastroUsuario));
                        }
                        catch (ParseException e) {
                            e.printStackTrace();
                        }

                        usuarioComum.setCep(UserRegisterActivity02.cepCadastroUsuario);
                        usuarioComum.setCidade(UserRegisterActivity02.cidadeCadastroUsuario);
                        usuarioComum.setEstado(UserRegisterActivity02.estadoCadastroUsuario);
                        usuarioComum.setSenhaUsuario(UserRegisterActivity02.senhaCadastroUsuario);

                        //PEDE A ROUTER INTERFACE PARA INSERIR NO BANCO DE DADOS O QUE PASSAMOS
                        routerInterface = APIUtil.getApiInterface();
                        addUsuario(usuarioComum);

                        //REDIRECIONANDO A OUTRA TELA
                        Intent intent = new Intent(PhotoUserRegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }//fim do if
                }//fim da view
        ); //fim d

    }//fim do onCreate


    /** FUNCOES DE MODEL **/
    public void addUsuario(UsuarioComum usuarioComum) {

        Call<UsuarioComum> call = routerInterface.addUsuarioComum(usuarioComum);
        call.enqueue(new Callback<UsuarioComum>() {

            @Override
            public void onResponse(Call<UsuarioComum> call, Response<UsuarioComum> response) {
                Toast.makeText(PhotoUserRegisterActivity.this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioComum> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }//fim do onFailure
        }); //fim do enqueue e do calback
    }// fim da funcao addUsuario

    //* FUNCOES GERAIS

        /** funcao de pegar a imagem **/
//    public void onActivityResult (int requestCode, int resultCode,Intent imagem) {
//        super.onActivityResult(requestCode, resultCode, imagem);
//
//        //se não selecionado a imagem, volta 0
//        //se retornar -1, significa que foi selecionada uma imagem
//
//        if (requestCode == CODE_IMAGE && resultCode == -1){
//
//            //Resuperar a imagem do stream/fluxo de bits
//            Bitmap imageStream = getContentResolver().openInputStream(imagem.getData());
//
//            //converter os bits em bit map
//            imageBitmap = BitmapFactory.decodeStream(imageStream);
//
//            //colocar o bitmap no imageview
//            photoPerfil.setImageBitmap(imageBitmap);
//        }
//
//    }



    //* funcao de abrir galeria
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
        {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == this.RESULT_CANCELED)
            {
                return;
            }
            if (requestCode == CODEIMAGE)
            {
                if (data != null) //veio alguma coisa?
                {
                    Uri uri = data.getData(); //uri é responsável por manipular enderecos do recurso

                    try
                    {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                        if (photoCover.isActivated()){
                            photoCover.setImageBitmap(bitmap);
                        }
                        else{
                            photoPerfil.setImageBitmap(bitmap);
                        }

                        Log.d("IMAGEM", "Imagem alterada");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                        Log.d("IMAGEM", e.getMessage());
                    }
                }
            }

        }

    private void openGalery(){
        Intent intent = new Intent(Intent.ACTION_PICK, //o pick permite abrir uma parte especifica do smartphine
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI //o priveder permite acessar funcionalidades do Sistema Operacional
        );
        intent.setType("image/*"); //tipo de arquivo a ser aceito

        startActivityForResult(Intent.createChooser(intent, "Selecione a imagem do livro"), CODEIMAGE);
    }
    //* funcao de validar dados
    private boolean validateFields(){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se o campo de biografia contem mais de 200 caracteres
        if (etBiografia.getText().length() > 200){
            Toast.makeText(PhotoUserRegisterActivity.this, "Data inserida é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }
}