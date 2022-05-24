package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.LoginActivity;
import com.example.tcc_after.remote.RouterInterface;

public class UserRegisterActivity01 extends AppCompatActivity {

    private EditText etNome, etConfirmEmail, etNickname, etEmail;
    private TextView tvLogin;
    private Button btnAvancar1;
    public static String nomeCadastroUsuario, emailCadastroUsuario, nicknameCadastroUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register01);

        /** ATRIBUINDO OS IDS DOS CAMPOS DO XML AS VARIAVEIS **/
        tvLogin = findViewById(R.id.tvUserregister01_entrarPerfil);

        etNome = findViewById(R.id.etUserRegister_FullName);
        etNickname = findViewById(R.id.etUserRegister_Nickname);
        etEmail = findViewById(R.id.etUserRegister_Email);
        etConfirmEmail = findViewById(R.id.etUserRegister_ConfEmail);

        btnAvancar1 = findViewById(R.id.btnUserRegister01_Foward);


        tvLogin.setOnClickListener(view -> {
            startActivity(new Intent(UserRegisterActivity01.this, LoginActivity.class));
        });


        /** EXECUTAR QUANDO CLICAR NO BOTAO **/
        btnAvancar1.setOnClickListener(view->{

            // FAZ A VALIDAÇÃO DOS CAMPOS
            if (validateFields()){
                //ATRIBUINDO VALORES AS VARIAVEIS PÚBLICAS
                nomeCadastroUsuario = etNome.getText().toString();
                nicknameCadastroUsuario = etNickname.getText().toString();
                emailCadastroUsuario = etEmail.getText().toString();

                //REDIRECIONANDO A OUTRA TELA
                Intent intent = new Intent(UserRegisterActivity01.this, UserRegisterActivity02.class);
                startActivity(intent);
            }

        }); //fim do setOnClickListener



    }// fim do metodo onCreate

    /** CRIANDO UMA FUNÇÃO DE VALIDAR CAMPOS **/
    private boolean validateFields (){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se os campos obrigatorios estao preenchidos
        if (etNome.getText().length() == 0  && etNickname.getText().length() == 0 && etEmail.getText().length() == 0){
            Toast.makeText(UserRegisterActivity01.this, "Você precisa preencher os campos", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** nome **/
        //verifica se o campo de nome esta preenchido
        if (etNome.getText().length() == 0){
            etNome.setError( "Voce precisa prencher o campo nome");
            valid = false;
        }
        //verifica se o campo de nickname contem mais de 100 caracteres
        if (etNome.getText().length() > 100){
            Toast.makeText(UserRegisterActivity01.this, "Nome inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** nickname **/
        //verifica se o campos de nickname esta preenchido
        if (etNickname.getText().length() == 0){
            etNickname.setError("Voce precisa prencher o campo nickname");
            valid = false;
        }
        //verifica se o campo de nickname contem mais de 25 caracteres
        if (etNickname.getText().length() > 25){
            Toast.makeText(UserRegisterActivity01.this, "Nickname inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** email **/
        //verifica se o campo de email esta preenchido
        if (etEmail.getText().length() == 0) {
            etEmail.setError("Voce precisa prencher o campo email");
            valid = false;
        }
        //verifica se o campo de emil contem mais de 200 caracteres
        if (etEmail.getText().length() > 200){
            Toast.makeText(UserRegisterActivity01.this, "Email inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        //verifica se o email e a confirmacao são iguais
        if (!etEmail.getText().toString().equals(etConfirmEmail.getText().toString())){
            Toast.makeText(UserRegisterActivity01.this, "Reveja os campos de email", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }
}