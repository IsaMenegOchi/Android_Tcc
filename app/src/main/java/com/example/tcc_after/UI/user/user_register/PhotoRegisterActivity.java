package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRegisterActivity extends AppCompatActivity {

    private ImageView photoPerfil;
    private ImageView photoCover;
    private Button btnFoward;
    private EditText etBiografia;

    RouterInterface routerInterface;

    private final int CODE_IMAGE = 100;

    private Bitmap imageBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_register);

        photoPerfil = findViewById(R.id.ivPhotoRegister_Perfil);
        photoCover = findViewById(R.id.ivPhotoRegister_Cover);
        btnFoward = findViewById(R.id.btnPhotoRegister_Add);
        etBiografia = findViewById(R.id.etPhotoRegister_Description);

        photoPerfil.setOnClickListener( view -> {
            openGalery();
        });

        photoCover.setOnClickListener(view -> {
            openGalery();
        });


        btnFoward.setOnClickListener(view ->
                {
                    UsuarioComum usuarioComum = new UsuarioComum();

                    usuarioComum.setNomeCompletoUsuario(UserRegisterActivity01.nomeCadastroUsuario);
                    usuarioComum.setNicknameUsuario(UserRegisterActivity01.nicknameCadastroUsuario);
                    usuarioComum.setEmailUsuario(UserRegisterActivity01.emailCadastroUsuario);
                    usuarioComum.setDatanascUsuario(UserRegisterActivity02.dataNascCadastroUsuario);
//                    usuarioComum.setEmailUsuario(UserRegisterActivity02.cepCadastroUsuario);
//                    usuarioComum.setEmailUsuario(UserRegisterActivity02.cidadeCadastroUsuario);
//                    usuarioComum.setEmailUsuario(UserRegisterActivity02.estadoCadastroUsuario);
                    usuarioComum.setSenhaUsuario(UserRegisterActivity02.senhaCadastroUsuario);
                    usuarioComum.setBiografiaUsuario(etBiografia.getText().toString());

                    routerInterface = APIUtil.getUsuarioInterface();
                    addUsuario(usuarioComum);

                }
        );
    }

    public void addUsuario(UsuarioComum usuarioComum) {

        //calback - classe do java
        Call<UsuarioComum> call = routerInterface.addUsuarioComum(usuarioComum);
        call.enqueue(new Callback<UsuarioComum>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<UsuarioComum> call, Response<UsuarioComum> response) {
                Toast.makeText(PhotoRegisterActivity.this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioComum> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });
    }
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

    public void openGalery(){

        //criamos uma variavel com
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        //qual o tipo de recurso que quero pegar
        intent.setType("image/*");

        //abrir a activity responsavel por exibir as imagens, na qual retornará o conteudo selecionado para o nosso app
        this.startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE);
    }
}