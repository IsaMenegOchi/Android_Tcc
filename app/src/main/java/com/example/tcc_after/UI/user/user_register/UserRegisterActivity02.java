package com.example.tcc_after.UI.user.user_register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.LoginActivity;
import com.example.tcc_after.model.Cep;
import com.example.tcc_after.remote.ConectionViaCep;
import com.example.tcc_after.remote.ConsumeXML;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.util.DatePickerFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserRegisterActivity02 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView tvLogin;

    private EditText etDataNasc,etCep, etCidade, etEstado, etSenha, etConfSenha;

    private Button btnAvancar2;

    private List<Cep> cepList = new ArrayList<>();


    public static String dataNascCadastroUsuario, cepCadastroUsuario, cidadeCadastroUsuario, estadoCadastroUsuario, senhaCadastroUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register02);

        /** ATRIBUINDO OS IDS DOS CAMPOS DO XML AS VARIAVEIS **/
        tvLogin = findViewById(R.id.tvUserRegister02_conectAccount);

        etDataNasc = findViewById(R.id.etUserRegister_Birth);
        etCep = findViewById(R.id.etUserRegister_Cep);
        etCidade = findViewById(R.id.etUserRegister_City);
        etEstado = findViewById(R.id.etUserRegister_State);
        etSenha = findViewById(R.id.etUserRegister_Passaword);
        etConfSenha = findViewById(R.id.etUserRegister_ConfPassaword);
        btnAvancar2 = findViewById(R.id.btnUserRegister02_Foward);

        tvLogin.setOnClickListener(view -> {
            startActivity(new Intent(UserRegisterActivity02.this, LoginActivity.class));
        });



        etCep.setOnFocusChangeListener((view, b) -> {
            BringJsonCep bringJsonCep = new BringJsonCep();
            bringJsonCep.execute("https://viacep.com.br/ws/"+etCep.getText().toString()+"/xml/");

        });

        etDataNasc.setOnClickListener(view -> {
            DatePickerFragment mDatePickerDialogFragment;
            mDatePickerDialogFragment = new DatePickerFragment();
            mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
        });

        etSenha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= etSenha.getRight() - etSenha.getTotalPaddingRight())
                    return true;
                }
                return false;
            }
        });


        /** EXECUTAR QUANDO CLICAR NO BOTAO **/
        btnAvancar2.setOnClickListener(view ->
        {

            // FAZ A VALIDAÇÃO DOS CAMPOS
            if (validateFields()) {

                //ATRIBUINDO VALORES AS VARIAVEIS PÚBLICAS
                dataNascCadastroUsuario = etDataNasc.getText().toString();
                cepCadastroUsuario = etCep.getText().toString();
                cidadeCadastroUsuario = etCidade.getText().toString();
                estadoCadastroUsuario = etEstado.getText().toString();
                senhaCadastroUsuario = etSenha.getText().toString();

//            REDIRECIONANDO A OUTRA TELA
                Intent intent = new Intent(UserRegisterActivity02.this, PhotoUserRegisterActivity.class);
                startActivity(intent);

            }

        });
    }

    //*função de pegar data
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        String diaMes = String.valueOf(dayOfMonth);
        String mes = String.valueOf(month);
        String data = null;

        if (diaMes.length() == 1 && mes.length() == 1){
            data = "0"+ diaMes + "/" + "0" + (month+1) + "/" + year;

        }
        else if (diaMes.length() == 1){
            data = "0"+ diaMes + "/" + (month+1) + "/" + year;
        }
        else if (mes.length() == 1){
            data = diaMes + "/" + "0" + (month+1) + "/" + year;
        }
        else {
                data = diaMes + "/" + (month+1) + "/" + year;
            }

            etDataNasc.setText(data);

    }


    private class BringJsonCep extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            String returnConection = ConectionViaCep.getData(strings[0]);
            Log.d("boco", "InBackg");
            return returnConection;
        }

        @Override
        protected void onPostExecute(String s) {
            cepList = ConsumeXML.xmlDatas(s);
            showDatas();
            Log.d("boco", "onPostexecute");
        }

        private void showDatas()
        {
            if (cepList != null){
                for (Cep cep : cepList){
                    etEstado.setText(cep.getUf());
                    etCidade.setText(cep.getLocalidade());
                }
            }
        }
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

        if (!etSenha.getText().toString().equals(etConfSenha.getText().toString())){
            Toast.makeText(UserRegisterActivity02.this, "Reveja os campos de senha", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }

}