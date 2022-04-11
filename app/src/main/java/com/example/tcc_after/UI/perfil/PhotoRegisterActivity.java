package com.example.tcc_after.UI.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tcc_after.R;

public class PhotoRegisterActivity extends AppCompatActivity {

    private ImageView photoPerfil;
    private ImageView photoCover;

    private final int CODE_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_register);

        photoPerfil = findViewById(R.id.ivPhotoRegister_Perfil);
        photoCover = findViewById(R.id.ivPhotoRegister_Cover);

        photoPerfil.setOnClickListener( view -> {

            photoCover.setVisibility(View.VISIBLE);

            openGalery();});
    }

    public void openGalery(){

        //criamos uma variavel com
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        //qual o tipo de recurso que quero pegar
        intent.setType("image/*");

        //abrir a activity responsavel por exibir as imagens, na qual retornará o conteudo selecionado para o nosso app
        this.startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE);
    }
}