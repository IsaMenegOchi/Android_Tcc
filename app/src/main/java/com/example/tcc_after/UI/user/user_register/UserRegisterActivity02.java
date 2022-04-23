package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.remote.RouterInterface;

public class UserRegisterActivity02 extends AppCompatActivity {
    private EditText etDataNasc;
    private EditText etCep;
    private EditText etCidade;
    private EditText etEstado;
    private EditText etSenha;
    private EditText etConfSenha;

    private Button btnAvancar2;

    RouterInterface routerInterface;

    public static String dataNascCadastroUsuario;
    public static String cepCadastroUsuario;
    public static String cidadeCadastroUsuario;
    public static String estadoCadastroUsuario;
    public static String senhaCadastroUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register02);

        /** ATRIBUINDO OS IDS DOS CAMPOS DO XML AS VARIAVEIS **/
        etDataNasc = findViewById(R.id.etUserRegister_Birth);
        etCep = findViewById(R.id.etUserRegister_Cep);
        etCidade = findViewById(R.id.etUserRegister_City);
        etEstado = findViewById(R.id.etUserRegister_State);
        etSenha = findViewById(R.id.etUserRegister_Passaword);
        etConfSenha = findViewById(R.id.etUserRegister_ConfPassaword);
        btnAvancar2 = findViewById(R.id.btnUserRegister02_Foward);

        /** EXECUTAR QUANDO CLICAR NO BOTAO **/
        btnAvancar2.setOnClickListener(view ->
        {
            // FAZ A VALIDAÇÃO DOS CAMPOS
            if (validateFields()){
            //ATRIBUINDO VALORES AS VARIAVEIS PÚBLICAS
            dataNascCadastroUsuario = etDataNasc.getText().toString();
            cepCadastroUsuario = etCep.getText().toString();
            cidadeCadastroUsuario = etCidade.getText().toString();
            estadoCadastroUsuario = etEstado.getText().toString();
            senhaCadastroUsuario = etSenha.getText().toString();

            //REDIRECIONANDO A OUTRA TELA
            Intent intent = new Intent(UserRegisterActivity02.this, PhotoUserRegisterActivity.class);
            startActivity(intent);

            }
        });
    }

    /** CRIANDO UMA FUNÇÃO DE VALIDAR CAMPOS **/
    private boolean validateFields(){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se os campos obrigatorios estao preenchidos
        if (etDataNasc.getText().length() == 0  && etSenha.getText().length() == 0){
            Toast.makeText(UserRegisterActivity02.this, "Você precisa preencher os campos", Toast.LENGTH_LONG).show();
            valid = false;
        }

        /** data de nascimento **/
        //verifica se o campo de nome esta preenchido
        if (etDataNasc.getText().length() == 0){
            etDataNasc.setError( "Voce precisa prencher o campo de data de nascimento");
            valid = false;
        }
        //verifica se o campo de data nascimento contem mais de 10 caracteres
        if (etDataNasc.getText().length() > 10){
            Toast.makeText(UserRegisterActivity02.this, "Data inserida é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (etCep.getText().length() > 15){
            Toast.makeText(UserRegisterActivity02.this, "O CEP inserido é inválido", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (etEstado.getText().length() > 50){
            Toast.makeText(UserRegisterActivity02.this, "O estado inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (etCidade.getText().length() > 50){
            Toast.makeText(UserRegisterActivity02.this, "A cidade inserida é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        /** senha **/
        //verifica se o campos de nickname esta preenchido
        if (etSenha.getText().length() == 0){
            etSenha.setError("Voce precisa prencher o campo de senha");
            valid = false;
        }
        //verifica se o campo de senha contem mais de 20 caracteres
        if (etSenha.getText().length() > 20){
            Toast.makeText(UserRegisterActivity02.this, "Senha inserida é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (etSenha.getText().toString().length() != etConfSenha.getText().toString().length()){
            Toast.makeText(UserRegisterActivity02.this, "Reveja os campos de senha", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }



}