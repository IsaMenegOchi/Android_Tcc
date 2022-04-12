package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.tcc_after.R;

public class UserRegisterActivity02 extends AppCompatActivity {
    private EditText etDataNasc;
    private EditText etCep;
    private EditText etCidade;
    private EditText etEstado;
    private EditText etSenha;
    private EditText etConfSenha;

    private Button btnAvancar2;

    public static String dataNascCadastroUsuario;
    public static String cepCadastroUsuario;
    public static String cidadeCadastroUsuario;
    public static String estadoCadastroUsuario;
    public static String senhaCadastroUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register02);


        etDataNasc = findViewById(R.id.etUserRegister_Birth);
        etCep = findViewById(R.id.etUserRegister_Cep);
        etCidade = findViewById(R.id.etUserRegister_City);
        etEstado = findViewById(R.id.etUserRegister_State);
        etSenha = findViewById(R.id.etUserRegister_Passaword);
        etConfSenha = findViewById(R.id.etUserRegister_ConfPassaword);

        btnAvancar2 = findViewById(R.id.btnUserRegister02_Foward);

        btnAvancar2.setOnClickListener(view ->
        {
            dataNascCadastroUsuario = etDataNasc.getText().toString();
            cepCadastroUsuario = etCep.getText().toString();
            cidadeCadastroUsuario = etCidade.getText().toString();
            estadoCadastroUsuario = etEstado.getText().toString();
            senhaCadastroUsuario = etSenha.getText().toString();

            Intent intent = new Intent(UserRegisterActivity02.this, PhotoRegisterActivity.class);
            startActivity(intent);
        });

    }
}