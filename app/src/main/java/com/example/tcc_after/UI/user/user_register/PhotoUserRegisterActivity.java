package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoUserRegisterActivity extends AppCompatActivity {

    private ImageView photoPerfil;
    private ImageView photoCover;
    private Button btnFoward;
    private EditText etBiografia;
    private TextView tvPularEtapa;

    RouterInterface routerInterface;

    private final int CODE_IMAGE = 100;

    private Bitmap imageBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_photo_register);

        /** ATRIBUINDO OS IDS DOS CAMPOS DO XML AS VARIAVEIS **/
        photoPerfil = findViewById(R.id.ivPhotoRegister_Perfil);
        photoCover = findViewById(R.id.ivPhotoRegister_Cover);
        btnFoward = findViewById(R.id.btnPhotoRegister_Add);
        etBiografia = findViewById(R.id.etPhotoRegister_Description);
        tvPularEtapa = findViewById(R.id.tvPhotoRegister_Skip);

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
                        usuarioComum.setDataNascUsuario(UserRegisterActivity02.dataNascCadastroUsuario);
                        //fotoCapa
                        //fotoFundo
                        usuarioComum.setCep(UserRegisterActivity02.cepCadastroUsuario);
                        usuarioComum.setCidade(UserRegisterActivity02.cidadeCadastroUsuario);
                        usuarioComum.setEstado(UserRegisterActivity02.estadoCadastroUsuario);
                        usuarioComum.setSenhaUsuario(UserRegisterActivity02.senhaCadastroUsuario);
                        usuarioComum.setBiografia(etBiografia.getText().toString());

                        //PEDE A ROUTER INTERFACE PARA INSERIR NO BANCO DE DADOS O QUE PASSAMOS
                        routerInterface = APIUtil.getUsuarioInterface();
                        addUsuario(usuarioComum);

                        //REDIRECIONANDO A OUTRA TELA
//                        Intent intent = new Intent(UserRegisterActivity02.this, PhotoRegisterActivity.class);
//                        startActivity(intent);
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
                        usuarioComum.setDataNascUsuario(UserRegisterActivity02.dataNascCadastroUsuario);
                        usuarioComum.setCep(UserRegisterActivity02.cepCadastroUsuario);
                        usuarioComum.setCidade(UserRegisterActivity02.cidadeCadastroUsuario);
                        usuarioComum.setEstado(UserRegisterActivity02.estadoCadastroUsuario);
                        usuarioComum.setSenhaUsuario(UserRegisterActivity02.senhaCadastroUsuario);
                        usuarioComum.setBiografia(etBiografia.getText().toString());

                        //PEDE A ROUTER INTERFACE PARA INSERIR NO BANCO DE DADOS O QUE PASSAMOS
                        routerInterface = APIUtil.getUsuarioInterface();
                        addUsuario(usuarioComum);

                        //REDIRECIONANDO A OUTRA TELA
//                        Intent intent = new Intent(UserRegisterActivity02.this, PhotoRegisterActivity.class);
//                        startActivity(intent);
                    }//fim do if
                }//fim da view
        ); //fim d

    }//fim do onCreate


    /** FUNCOES DE MODEL **/
    public void addUsuario(UsuarioComum usuarioComum) {

        //calback - classe do java
        Call<UsuarioComum> call = routerInterface.addUsuarioComum(usuarioComum);
        call.enqueue(new Callback<UsuarioComum>() {
            //o req é feito automaticamente
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

    /** FUNCOES GERAIS **/

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

    /** funcao de abrir galeria de fotos **/
    public void openGalery(){

        //criamos uma variavel com
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        //qual o tipo de recurso que quero pegar
        intent.setType("image/*");

        //abrir a activity responsavel por exibir as imagens, na qual retornará o conteudo selecionado para o nosso app
        this.startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE);
    }

    /** funcao de validar dados **/
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