package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.Categoria;
import com.example.tcc_after.model.Cep;
import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.model.Evento;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.ConectionViaCep;
import com.example.tcc_after.remote.ConsumeXML;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.util.DateConvert;

import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRegisterActivity extends AppCompatActivity {

    private EditText tituloEvento, cepEvento, estadoEvento, logradouroEvento,
            cidadeEvento, descricaoEvento, capaEvento,
            dataInicioEvento, dataFimEvento, horaInicioEvento, horaFimEvento,
             imagensEvento, complementoEvento, bairroEvento ;

    private TextView sobreTermos;

    private Spinner faixaEtariaEvento, celebridadeEvento, tipoEvento,categoriaEvento,assuntoEvento, contaEvento;

    private CheckBox aceitarTermos;

    private Button avancarEvento;


    private List<Cep> cepList = new ArrayList<>();

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register);

//* LISTAGEM DE COMPONENTES COM IDS
        routerInterface = APIUtil.getApiInterface();
        tituloEvento = findViewById(R.id.etEventRegister_Title);
        descricaoEvento = findViewById(R.id.etEventRegister_Description);
        capaEvento = findViewById(R.id.btnEventRegister_Cover);
        dataInicioEvento = findViewById(R.id.etEventRegister_StartDate);
        dataFimEvento = findViewById(R.id.etEventRegister_FinishDate);
        horaInicioEvento = findViewById(R.id.etEventRegister_StartHour);
        horaFimEvento = findViewById(R.id.etEventRegister_FinishtHour);
        categoriaEvento = findViewById(R.id.spEventRegister_Category);
        tipoEvento = findViewById(R.id.spEventRegister_EventType);
        faixaEtariaEvento = findViewById(R.id.spEventRegister_AgeGroup);
        assuntoEvento = findViewById(R.id.spEventRegister_Subject);
        imagensEvento = findViewById(R.id.btnEventRegister_ExtraPhoto);
        celebridadeEvento = findViewById(R.id.spEventRegister_Celebrity);
        cepEvento = findViewById(R.id.etEventRegister_Cep);
        logradouroEvento = findViewById(R.id.etEventRegister_Street);
        complementoEvento = findViewById(R.id.etEventRegister_Complement);
        bairroEvento = findViewById(R.id.etEventRegister_Neighborhood);
        cidadeEvento = findViewById(R.id.etEventRegister_City);
        estadoEvento = findViewById(R.id.etEventRegister_State);
        contaEvento = findViewById(R.id.spEventRegister_BankAccount);

        avancarEvento = findViewById(R.id.btnEventRegister_RegisterEvent);

//*FAZENDO LISTAGEM DE CATEGORIAS
        Call<List<Categoria>> getCategorias = routerInterface.getCategorias();
        getCategorias.enqueue(
                new Callback<List<Categoria>>() {
                         @Override
                         public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {

                             if(response.isSuccessful()){

                                 List<Categoria> list = new ArrayList<Categoria>();

                                 List<String> listNomeCategoria = new ArrayList<String>();
//                                 List<Integer> listIdCategoria = new ArrayList<Integer>();

                                 list = response.body();

//                                 int quantidadeIndicesArray = list.size();
//                                 String [] teste = new String[quantidadeIndicesArray];

                                 for(int i = 0 ; i < list.size(); i++){
//                                     teste[i] = list.get(i).getCategoriaEvento();
                                     listNomeCategoria.add(list.get(i).getCategoriaEvento());
//                                     listIdCategoria.add(list.get(i).getIdCategoriaEvento());
                                 }

                                 ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeCategoria);
                                 arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                 categoriaEvento.setAdapter(arrayAdapter);

                                 categoriaEvento.setOnClickListener(view -> {
                                             Toast.makeText(EventRegisterActivity.this, "VOce esta selecionando" + categoriaEvento.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                                         });
                             }
                         }
                         @Override
                         public void onFailure(Call<List<Categoria>> call, Throwable t) {
                             Toast.makeText(EventRegisterActivity.this, "Nao pegamos a categoria", Toast.LENGTH_SHORT).show();
                         }
                }
        );

        //*FAZENDO LISTAGEM DE ASSUNTOS
//        Call<List<Assunto>> call = routerInterface.getCategorias();

        //*FAZENDO LISTAGEM DE TIPOS DE EVENTO
//        Call<List<TipoEvento>> call = routerInterface.getCategorias();

        //*FAZENDO LISTAGEM DE CONTA BANCÁRIA
        Call<List<ContaBancaria>> getContasBancarias = routerInterface.getContasBancarias();
        getContasBancarias.enqueue(new Callback<List<ContaBancaria>>() {
            @Override
            public void onResponse(Call<List<ContaBancaria>> call, Response<List<ContaBancaria>> response) {
//                List<ContaBancaria>
            }

            @Override
            public void onFailure(Call<List<ContaBancaria>> call, Throwable t) {

            }
        });


        //*FAZENDO LISTAGEM DE USUARIOS COMUNS
        Call<UsuarioComum> getUsuarioComuns = routerInterface.getUsuariosComuns();
        getUsuarioComuns.enqueue(new Callback<UsuarioComum>() {
            @Override
            public void onResponse(Call<UsuarioComum> call, Response<UsuarioComum> response) {

            }

            @Override
            public void onFailure(Call<UsuarioComum> call, Throwable t) {

            }
        });


        cepEvento.setOnFocusChangeListener((view, b) -> {
            BringJsonCep bringJsonCep = new BringJsonCep();
            bringJsonCep.execute("https://viacep.com.br/ws/" + cepEvento.getText().toString()+"/xml/");

        });



        avancarEvento.setOnClickListener(view -> {
//          SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Evento evento = new Evento();
            Categoria categoria = new Categoria();

            evento.setTituloEvento(tituloEvento.getText().toString());
            evento.setDescricaoEvento(descricaoEvento.getText().toString());
            evento.setCapaEvento(capaEvento.getText().toString());

            try {
                evento.setDataInicioEvento(DateConvert.format.parse(dataInicioEvento.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                evento.setDataFimEvento(DateConvert.format.parse(dataFimEvento.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

//            evento.setHoraInicioEvento(LocalTime.parse(horaInicioEvento.getText().toString()));
//            evento.setHoraFimEvento(LocalTime.parse(horaFimEvento.getText().toString()));


            //* SPINNER
//            categoriaEvento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    if(categoriaEvento.getSelectedItem().equals("Musical")){
//
//
//                        evento.setIdCategoriaEvento(categoria.getIdCategoriaEvento());
//                    }
//                    Log.d("testeS", "onItemClick: " + evento.getIdCategoriaEvento());
//                }
//            });




//            evento.setCategoriaEvento(categoriaEvento.getText().toString());
//            evento.setIdTipoEvento(Integer.parseInt(tipoEvento.getText().toString()));
//            evento.setIdFaixaEtariaEvento(Integer.parseInt(faixaEtariaEvento.getText().toString()));
//            evento.setIdAssuntoEvento(Integer.parseInt(assuntoEvento.getText().toString()));
//            evento.setImagensEvento(imagensEvento.getText().toString());
//            evento.setNicknameCelEvento(celebridadeEvento.getText().toString());
//
//            evento.setCepEvento(cepEvento.getText().toString());
//            evento.setLogradouroEvento(logradouroEvento.getText().toString());
//            evento.setComplementoEvento(complementoEvento.getText().toString());
//            evento.setBairroEvento(bairroEvento.getText().toString());
//            evento.setCidadeEvento(cidadeEvento.getText().toString());
//            evento.setEstadoEvento(estadoEvento.getText().toString());
//            evento.setIdContaEmpresaEvento(Integer.parseInt(contaEvento.getText().toString()));

//            Log.d("teste", contaEvento.getText().toString());
//            Log.d("teste", tipoEvento.getText().toString());
//            Log.d("teste", faixaEtariaEvento.getText().toString());
//            Log.d("teste", assuntoEvento.getText().toString());
//            Log.d("teste", categoriaEvento.getText().toString());


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