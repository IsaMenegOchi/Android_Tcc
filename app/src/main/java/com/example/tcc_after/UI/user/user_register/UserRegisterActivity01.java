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

    public static String nomeCadastroUsuario;
    public static String nicknameCadastroUsuario;
    public static String emailCadastroUsuario;



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

            nomeCadastroUsuario = etNome.getText().toString();
            nicknameCadastroUsuario = etNickname.getText().toString();
            emailCadastroUsuario = etEmail.getText().toString();

            Intent intent = new Intent(UserRegisterActivity01.this, UserRegisterActivity02.class);
            startActivity(intent);

        }); //fim do setOnClickListener
    }// fim do metodo onCreate

}