package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegisterActivity01 extends AppCompatActivity {

    private EditText etNome;
    private EditText etNickname;
    private EditText etEmail;
    private EditText etConfirmEmail;
    private Button btnAvancar1;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register01);

        btnAvancar1 = findViewById(R.id.btnUserRegister01_Foward);
        etNome = findViewById(R.id.etUserRegister_FullName);
        etNickname = findViewById(R.id.etUserRegister_Nickname);
        etEmail = findViewById(R.id.etUserRegister_Email);
        etConfirmEmail = findViewById(R.id.etUserRegister_ConfEmail);



        /** EXECUTAR QUANDO CLICAR NO BOTAO **/
        btnAvancar1.setOnClickListener(view->{

            //Crcia um objeto modal de UsuarioComum

                UsuarioComum usuarioComum = new UsuarioComum();

                usuarioComum.setNomeCompletoUsuario(etNome.getText().toString());
                usuarioComum.setNicknameUsuario(etNickname.getText().toString());
                usuarioComum.setEmailUsuario(etEmail.getText().toString());
                usuarioComum.setEmailUsuario(etConfirmEmail.getText().toString());

                routerInterface = APIUtil.getUsuarioInterface();
                addUsuario(usuarioComum);


            //passa os dados para a API Rest

        }); //fim do setOnClickListener
    }// fim do metodo onCreate

    public void addUsuario(UsuarioComum usuarioComum){

        //calback - classe do java
        Call<UsuarioComum> call = routerInterface.addUsuarioComum(usuarioComum);
        call.enqueue(new Callback<UsuarioComum>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<UsuarioComum> call, Response<UsuarioComum> response) {
                Toast.makeText(UserRegisterActivity01.this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioComum> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });

    }
}