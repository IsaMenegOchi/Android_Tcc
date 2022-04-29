package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterActivity01;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterPasswordActivity;
import com.example.tcc_after.UI.user.user_register.PhotoUserRegisterActivity;
import com.example.tcc_after.UI.user.user_register.UserRegisterActivity01;
import com.example.tcc_after.UI.user.user_register.UserRegisterActivity02;
import com.example.tcc_after.model.Cep;
import com.example.tcc_after.model.Evento;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.ConectionViaCep;
import com.example.tcc_after.remote.ConsumeXML;
import com.example.tcc_after.remote.RouterInterface;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRegisterActivity extends AppCompatActivity {

    private EditText tituloEvento, categoriaEvento, assuntoEvento,
            tipoEvento, cepEvento, estadoEvento, logradouroEvento,
            cidadeEvento, descricaoEvento, contaEvento, capaEvento,
            dataInicioEvento, dataFimEvento, horaInicioEvento, horaFimEvento,
            faixaEtariaEvento, celebridadeEvento, imagensEvento, complementoEvento, bairroEvento ;

    private TextView sobreTermos;

    private CheckBox aceitarTermos;

    private Button avancarEvento;

    public static String tituloCadastroEvento, categoriaCadastroEvento, assuntoCadastroEvento,
    tipoCadastroEvento, cepCadastroEvento, estadoCadastroEvento, logradouroCadastroEvento,
    cidadeCadastroEvento, descricaoCadastroEvento, contaCadastroEvento;

    private List<Cep> cepList = new ArrayList<>();
    RouterInterface routerInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register);

        tituloEvento = findViewById(R.id.etEventRegister_Title);
        descricaoEvento = findViewById(R.id.etEventRegister_Description);
        capaEvento = findViewById(R.id.btnEventRegister_Cover);
        dataInicioEvento = findViewById(R.id.etEventRegister_StartDate);
        dataFimEvento = findViewById(R.id.etEventRegister_FinishDate);
        horaInicioEvento = findViewById(R.id.etEventRegister_StartHour);
        horaFimEvento = findViewById(R.id.etEventRegister_FinishtHour);
        categoriaEvento = findViewById(R.id.etEventRegister_Category);
        tipoEvento = findViewById(R.id.etEventRegister_EventType);
        faixaEtariaEvento = findViewById(R.id.etEventRegister_AgeGroup);
        assuntoEvento = findViewById(R.id.etEventRegister_Subject);
        imagensEvento = findViewById(R.id.btnEventRegister_ExtraPhoto);
        celebridadeEvento = findViewById(R.id.etEventRegister_Celebrity);
        cepEvento = findViewById(R.id.etEventRegister_Cep);
        logradouroEvento = findViewById(R.id.etEventRegister_Street);
        complementoEvento = findViewById(R.id.etEventRegister_Complement);
        bairroEvento = findViewById(R.id.etEventRegister_Neighborhood);
        cidadeEvento = findViewById(R.id.etEventRegister_City);
        estadoEvento = findViewById(R.id.etEventRegister_State);
        contaEvento = findViewById(R.id.etEventRegister_BankAccount);

        avancarEvento = findViewById(R.id.btnEventRegister_RegisterEvent);

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        cepEvento.setOnFocusChangeListener((view, b) -> {
            BringJsonCep bringJsonCep = new BringJsonCep();
            bringJsonCep.execute("https://viacep.com.br/ws/"+cepEvento.getText().toString()+"/xml/");

        });

        avancarEvento.setOnClickListener(view -> {

            Evento evento = new Evento();

            evento.setTituloEvento(tituloEvento.getText().toString());
            evento.setDescricaoEvento(descricaoEvento.getText().toString());
            evento.setCapaEvento(capaEvento.getText().toString());
            try {
                evento.setDataInicioEvento(format.parse(dataInicioEvento.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                evento.setDataFimEvento(format.parse(dataFimEvento.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

//            evento.setHoraInicioEvento(Time.valueOf(horaInicioEvento.getText().toString()));
//            evento.setHoraFimEvento(LocalTime.parse(horaFimEvento.getText().toString()));

            evento.setCategoriaEvento(categoriaEvento.getText().toString());
            evento.setTipoEvento(tipoEvento.getText().toString());
            evento.setFaixaEtariaEvento(Integer.parseInt(faixaEtariaEvento.getText().toString()));
            evento.setAssuntoEvento(assuntoEvento.getText().toString());
            evento.setImagensEvento(imagensEvento.getText().toString());
            evento.setNicknameCelEvento(celebridadeEvento.getText().toString());

            evento.setCepEvento(cepEvento.getText().toString());
            evento.setLogradouroEvento(logradouroEvento.getText().toString());
            evento.setComplementoEvento(complementoEvento.getText().toString());
            evento.setBairroEvento(bairroEvento.getText().toString());
            evento.setCidadeEvento(cidadeEvento.getText().toString());
            evento.setEstadoEvento(estadoEvento.getText().toString());
            evento.setNumeroContaEvento(contaEvento.getText().toString());

            routerInterface = APIUtil.getApiInterface();
            addEvento(evento);

            Intent intent = new Intent(EventRegisterActivity.this, EventRegisterAllotmentActivity.class);
            startActivity(intent);
        });

    }

    public void addEvento(Evento evento) {

        Call<Evento> call = routerInterface.addEvento(evento);
        call.enqueue(new Callback<Evento>() {

            @Override
            public void onResponse(Call<Evento> call, Response<Evento> response) {
                Toast.makeText(EventRegisterActivity.this, "Evento inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Evento> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });
    }// fim da funcao addEvento


    private class BringJsonCep extends AsyncTask<String, String, String> {
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
                    estadoEvento.setText(cep.getUf());
                    cidadeEvento.setText(cep.getLocalidade());
                    logradouroEvento.setText(cep.getLogradroudo());
                    complementoEvento.setText(cep.getComplemento());
                    bairroEvento.setText(cep.getBairro());
                }
            }
        }
    }



//    private boolean validateFields (){
//
//        //cria uma variavel que se inicia com true
//        boolean valid = true;
//
//        //verifica se os campos obrigatorios estao preenchidos
//        if (etNome.getText().length() == 0  && etNickname.getText().length() == 0 && etEmail.getText().length() == 0){
//            Toast.makeText(UserRegisterActivity01.this, "Você precisa preencher os campos", Toast.LENGTH_LONG).show();
//            valid = false;
//        }
//
//
//        /** nome **/
//        //verifica se o campo de nome esta preenchido
//        if (etNome.getText().length() == 0){
//            etNome.setError( "Voce precisa prencher o campo nome");
//            valid = false;
//        }
//        //verifica se o campo de nickname contem mais de 100 caracteres
//        if (etNome.getText().length() > 100){
//            Toast.makeText(UserRegisterActivity01.this, "Nome inserido é muito grande", Toast.LENGTH_LONG).show();
//            valid = false;
//        }
//
//
//        /** nickname **/
//        //verifica se o campos de nickname esta preenchido
//        if (etNickname.getText().length() == 0){
//            etNickname.setError("Voce precisa prencher o campo nickname");
//            valid = false;
//        }
//        //verifica se o campo de nickname contem mais de 25 caracteres
//        if (etNickname.getText().length() > 25){
//            Toast.makeText(UserRegisterActivity01.this, "Nickname inserido é muito grande", Toast.LENGTH_LONG).show();
//            valid = false;
//        }
//
//
//        /** email **/
//        //verifica se o campo de email esta preenchido
//        if (etEmail.getText().length() == 0) {
//            etEmail.setError("Voce precisa prencher o campo email");
//            valid = false;
//        }
//        //verifica se o campo de emil contem mais de 200 caracteres
//        if (etEmail.getText().length() > 200){
//            Toast.makeText(UserRegisterActivity01.this, "Email inserido é muito grande", Toast.LENGTH_LONG).show();
//            valid = false;
//        }
//
//        //verifica se o email e a confirmacao são iguais
//        if (etEmail.getText().toString().length() != etConfirmEmail.getText().toString().length()){
//            Toast.makeText(UserRegisterActivity01.this, "Reveja os campos de email", Toast.LENGTH_LONG).show();
//            valid = false;
//        }
//
//        return valid;
//    }

//    public void openGalery(){
//
//        //criamos uma variavel com
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//
//        //qual o tipo de recurso que quero pegar
//        intent.setType("image/*");
//
//        //abrir a activity responsavel por exibir as imagens, na qual retornará o conteudo selecionado para o nosso app
//        this.startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE);
//    }


}