package com.example.tcc_after.UI.event;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.util.DatePickerFragment;
import com.example.tcc_after.util.TimePickerFragment;
import com.example.tcc_after.model.evento.Assunto;
import com.example.tcc_after.model.evento.Categoria;
import com.example.tcc_after.model.Cep;
import com.example.tcc_after.model.empresa.ContaBancaria;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.evento.FaixaEtaria;
import com.example.tcc_after.model.evento.TipoEvento;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.ConectionViaCep;
import com.example.tcc_after.remote.ConsumeXML;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.util.DateConvert;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRegisterActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
//    DatePickerDialog.OnDateSetListener
    private EditText tituloEvento, cepEvento, estadoEvento, logradouroEvento,
            cidadeEvento, descricaoEvento, capaEvento,
            dataInicioEvento, dataFimEvento, horaInicioEvento, horaFimEvento,complementoEvento,
        bairroEvento, numeroEvento;

    private TextView sobreTermos;

    private ImageView imagensEvento;

    private ScrollView scrollView;

    private Spinner faixaEtariaEvento, celebridadeEvento, tipoEvento,categoriaEvento,assuntoEvento, contaEvento;

    private CheckBox aceitarTermos;

    private Button avancarEvento;

    int idCategoria, idAssunto, idTipoEvento, idFaixaEtaria, idContaBancaria, idCelebridade = 0;
    private final int CODEIMAGE = 1;
    private List<Cep> cepList = new ArrayList<>();

    RouterInterface routerInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register);

        scrollView = findViewById(R.id.eventResgister_ScrollView);
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
        imagensEvento = findViewById(R.id.ivEventRegister_ExtraPhoto);
        celebridadeEvento = findViewById(R.id.spEventRegister_Celebrity);
        cepEvento = findViewById(R.id.etEventRegister_Cep);
        logradouroEvento = findViewById(R.id.etEventRegister_Street);
        complementoEvento = findViewById(R.id.etEventRegister_Complement);
        bairroEvento = findViewById(R.id.etEventRegister_Neighborhood);
        cidadeEvento = findViewById(R.id.etEventRegister_City);
        estadoEvento = findViewById(R.id.etEventRegister_State);
        contaEvento = findViewById(R.id.spEventRegister_BankAccount);
        numeroEvento = findViewById(R.id.etEventRegister_Number);
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
                                 List<Integer> listIdCategoria = new ArrayList<Integer>();

                                 list = response.body();

//                                 int quantidadeIndicesArray = list.size();
//                                 String [] teste = new String[quantidadeIndicesArray];

                                 for(int i = 0 ; i < list.size(); i++){
//                                     teste[i] = list.get(i).getCategoriaEvento();
                                     listNomeCategoria.add(list.get(i).getCategoriaEvento());
                                     listIdCategoria.add(list.get(i).getIdCategoriaEvento());
                                 }

                                 ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeCategoria);
                                 arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                 categoriaEvento.setAdapter(arrayAdapter);


                                 categoriaEvento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        for(int ii = 0 ; ii < listIdCategoria.size(); ii++){

                                            if (categoriaEvento.getSelectedItemPosition() == listIdCategoria.get(ii)){
                                                idCategoria = listIdCategoria.get(ii);
                                            }
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {
                                        Toast.makeText(EventRegisterActivity.this, "Escolha uma categoria", Toast.LENGTH_SHORT).show();
                                    }
                                 });
                             }
                         }
                         @Override
                         public void onFailure(Call<List<Categoria>> call, Throwable t) {
                             Log.d("ErrorEvento", "onFailure: Categorias não foram capturadas");
                         }
                }

        );

    //*FAZENDO LISTAGEM DE ASSUNTOS
        Call<List<Assunto>> getAssuntos = routerInterface.getAssuntos();
        getAssuntos.enqueue(

                new Callback<List<Assunto>>() {
                    @Override
                    public void onResponse(Call<List<Assunto>> call, Response<List<Assunto>> response) {
                        if (response.isSuccessful()) {

                            List<Assunto> listAssuntos = new ArrayList<Assunto>();

                            List<String> listNomeAssunto = new ArrayList<String>();
                            List<Integer> listIdAssunto = new ArrayList<Integer>();

                            listAssuntos = response.body();


                            for (int i = 0; i < listAssuntos.size(); i++) {
                                listNomeAssunto.add(listAssuntos.get(i).getAssuntoEvento());
                                listIdAssunto.add(listAssuntos.get(i).getIdAssuntoEvento());
                            }

                            ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeAssunto);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            assuntoEvento.setAdapter(arrayAdapter);


                            assuntoEvento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                    for (int ii = 0; ii < listIdAssunto.size(); ii++) {

                                        if (assuntoEvento.getSelectedItemPosition() == listIdAssunto.get(ii)) {
                                            idAssunto = listIdAssunto.get(ii);
                                        }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Assunto>> call, Throwable t) {
                        Log.d("ErrorEvento", "onFailure: Assuntos não foi capturado");
                    }
                }

        );

    //*FAZENDO LISTAGEM DE TIPOS DE EVENTO
        Call<List<TipoEvento>> getTiposEvento = routerInterface.getTiposEvento();
        getTiposEvento.enqueue(

                new Callback<List<TipoEvento>>() {
                    @Override
                    public void onResponse(Call<List<TipoEvento>> call, Response<List<TipoEvento>> response) {

                        if(response.isSuccessful()){

                            List<TipoEvento> listTipoEvento = new ArrayList<TipoEvento>();

                            List<String> listNomeTipoEvento = new ArrayList<String>();
                            List<Integer> listIdTipoEvento = new ArrayList<Integer>();

                            listTipoEvento = response.body();

//                                 int quantidadeIndicesArray = list.size();
//                                 String [] teste = new String[quantidadeIndicesArray];

                            for(int i = 0 ; i < listTipoEvento.size(); i++){
//                                     teste[i] = list.get(i).getCategoriaEvento();
                                listNomeTipoEvento.add(listTipoEvento.get(i).getTipo());
                                listIdTipoEvento.add(listTipoEvento.get(i).getIdTipoEvento());
                            }

                            ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeTipoEvento);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            tipoEvento.setAdapter(arrayAdapter);

                            tipoEvento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                    for(int ii = 0 ; ii < listIdTipoEvento.size(); ii++){

                                        if (tipoEvento.getSelectedItemPosition() == listIdTipoEvento.get(ii)){
                                            idCategoria = listIdTipoEvento.get(ii);
                                        }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                    Toast.makeText(EventRegisterActivity.this, "Escolha um tipo de evento", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                    @Override
                    public void onFailure(Call<List<TipoEvento>> call, Throwable t) {
                        Log.d("ErrorEvento", "onFailure: Tipos de eventos não foram capturados");
                    }
                }

        );

    //*FAZENDO LISTAGEM DE FAIXAS ETÁRIAS
        Call<List<FaixaEtaria>> getFaixasEtaria = routerInterface.getFaixasEtaria();
        getFaixasEtaria.enqueue(

                new Callback<List<FaixaEtaria>>() {
                    @Override
                    public void onResponse(Call<List<FaixaEtaria>> call, Response<List<FaixaEtaria>> response) {

                        if(response.isSuccessful()){

                            List<FaixaEtaria> listFaixaEtaria = new ArrayList<FaixaEtaria>();

                            List<String> listNomeFaixaEtaria = new ArrayList<String>();
                            List<Integer> listIdFaixaEtaria = new ArrayList<Integer>();

                            listFaixaEtaria = response.body();

                            for(int i = 0 ; i < listFaixaEtaria.size(); i++){
                                listNomeFaixaEtaria.add(listFaixaEtaria.get(i).getIdadeFaixaEtaria());
                                listIdFaixaEtaria.add(listFaixaEtaria.get(i).getIdFaixaEtaria());
                            }

                            ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNomeFaixaEtaria);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            faixaEtariaEvento.setAdapter(arrayAdapter);

                            faixaEtariaEvento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                    for(int ii = 0 ; ii < listIdFaixaEtaria.size(); ii++){

                                        if (faixaEtariaEvento.getSelectedItemPosition() == listIdFaixaEtaria.get(ii)){
                                            idFaixaEtaria = listIdFaixaEtaria.get(ii);
                                        }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                    Toast.makeText(EventRegisterActivity.this, "Escolha uma faixa etária", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                    @Override
                    public void onFailure(Call<List<FaixaEtaria>> call, Throwable t) {
                        Log.d("ErrorEvento", "onFailure: Faixas etárias não foram capturadas");
                    }
                }

        );



    //*FAZENDO LISTAGEM DE CONTA BANCÁRIA
        Call<List<ContaBancaria>> getContasBancarias = routerInterface.getContaBancariaPorId(1);
        getContasBancarias.enqueue(

                new Callback<List<ContaBancaria>>() {
            @Override
            public void onResponse(Call<List<ContaBancaria>> call, Response<List<ContaBancaria>> response) {


                if(response.isSuccessful()){

                    List<ContaBancaria> listContaBancaria = new ArrayList<ContaBancaria>();

                    List<String> listNumeroContaBancaria = new ArrayList<String>();
                    List<Integer> listIdContaBancaria = new ArrayList<Integer>();


                    listContaBancaria = response.body();

                    for(int i = 0 ; i < listContaBancaria.size(); i++){

                        listNumeroContaBancaria.add(listContaBancaria.get(i).getNumeroCB());
                        listIdContaBancaria.add(listContaBancaria.get(i).getIdContaBancaria());

                    }

                    ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNumeroContaBancaria);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    contaEvento.setAdapter(arrayAdapter);

                    contaEvento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            for(int ii = 0 ; ii < listIdContaBancaria.size(); ii++){

                                if (contaEvento.getSelectedItemPosition() == listIdContaBancaria.get(ii)){
                                    idContaBancaria = listIdContaBancaria.get(ii);
                                }
                            }
                            Log.d("teste", "onItemSelected: " + idContaBancaria);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            Toast.makeText(EventRegisterActivity.this, "Escolha uma conta bancária", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<List<ContaBancaria>> call, Throwable t) {
                Log.d("ErrorEvento", "onFailure: Contas bancárias não foram capturadas");
            }
        }

        );


//        //*FAZENDO LISTAGEM DE USUARIOS COMUNS
//        Call<List<UsuarioComum>> getUsuarioComuns = routerInterface.getUsuariosComuns();
//        getUsuarioComuns.enqueue(
//
//                new Callback<List<UsuarioComum>>() {
//            @Override
//            public void onResponse(Call<List<UsuarioComum>> call, Response<List<UsuarioComum>> response) {
//
//                if(response.isSuccessful()) {
//                    List<UsuarioComum> listUsuarioComum = new ArrayList<UsuarioComum>();
//
//                    List<String> listNicknameUsuarioComum = new ArrayList<String>();
//                    List<Integer> listIdPerfilUsuarioComum = new ArrayList<Integer>();
//
//                    listUsuarioComum = response.body();
//
//                    for (int i = 0; i < listUsuarioComum.size(); i++) {
//
//                        listNicknameUsuarioComum.add(listUsuarioComum.get(i).getNicknameUsuario());
//                        listIdPerfilUsuarioComum.add(listUsuarioComum.get(i).getIdPerfil());
//
//                    }
//
//                    ArrayAdapter arrayAdapter = new ArrayAdapter(EventRegisterActivity.this, android.R.layout.simple_spinner_item, listNicknameUsuarioComum);
//                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    celebridadeEvento.setAdapter(arrayAdapter);
//
//                    celebridadeEvento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                            for (int ii = 0; ii < listIdPerfilUsuarioComum.size(); ii++) {
//
//                                if (celebridadeEvento.getSelectedItemPosition() == listIdPerfilUsuarioComum.get(ii)) {
//                                    idCelebridade = listIdPerfilUsuarioComum.get(ii);
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> adapterView) {
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<UsuarioComum>> call, Throwable t) {
//                Log.d("ErrorEvento", "onFailure: Celebridades não foram capturadas");
//            }
//
//        }
//
//        );

        //*FAZENDO CONSUMO DE VIA CEP


        dataInicioEvento.setOnClickListener(view -> {
            DatePickerFragment mDatePickerDialogFragment;
            mDatePickerDialogFragment = new DatePickerFragment();
            mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
        });

        dataFimEvento.setOnClickListener(view -> {
            DatePickerFragment mDatePickerDialogFragment;
            mDatePickerDialogFragment = new DatePickerFragment();
            mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
        });

        horaInicioEvento.setOnClickListener(view -> {
            DialogFragment timePicker = new TimePickerFragment();
            timePicker.show(getSupportFragmentManager(), "time picker");
        });

        horaFimEvento.setOnClickListener(view -> {
            DialogFragment timePicker = new TimePickerFragment();
            timePicker.show(getSupportFragmentManager(), "time picker");
        });


        imagensEvento.setOnClickListener(view -> {
            openGalery();
        });

        cepEvento.setOnFocusChangeListener((view, b) -> {
            BringJsonCep bringJsonCep = new BringJsonCep();
            bringJsonCep.execute("https://viacep.com.br/ws/" + cepEvento.getText().toString()+"/xml/");

        });

        //* CADASTRAR EVENTO
        avancarEvento.setOnClickListener(view -> {
            Evento evento = new Evento();

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

            evento.setHoraInicioEvento(horaInicioEvento.getText().toString());
            evento.setHoraFimEvento(horaFimEvento.getText().toString());


            //* SPINNERS
            evento.setIdCategoriaEvento(idCategoria);
            evento.setIdAssuntoEvento(idAssunto);
            evento.setIdTipoEvento(idTipoEvento);
            evento.setIdFaixaEtariaEvento(idFaixaEtaria);
            evento.setIdContaEmpresaEvento(idContaBancaria);
//            evento.setIdCelebridadeEvento(idCelebridade);

//            evento.setImagensEvento(imagensEvento.getText().toString());
            evento.setCepEvento(cepEvento.getText().toString());
            evento.setLogradouroEvento(logradouroEvento.getText().toString());
            evento.setComplementoEvento(complementoEvento.getText().toString());
            evento.setBairroEvento(bairroEvento.getText().toString());
            evento.setCidadeEvento(cidadeEvento.getText().toString());
            evento.setEstadoEvento(estadoEvento.getText().toString());
            evento.setNumeroEvento(numeroEvento.getText().toString());

            addEvento(evento);

            Intent intent = new Intent(EventRegisterActivity.this, EventRegisterAllotmentActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String hora = dayOfMonth + "/" + month + "/" + year;

        if (dataInicioEvento.isFocusable() && dataInicioEvento.length() == 0){
            dataInicioEvento.setText(hora);
        }
        else if(dataFimEvento.isFocusable() && dataFimEvento.length() == 0){
            dataFimEvento.setText(hora);
        }

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String hora = hourOfDay + ":" + minute;
        if (horaInicioEvento.isFocusable() && horaInicioEvento.length() == 0){
            horaInicioEvento.setText(hora);
        }
        else if(horaFimEvento.isFocusable() && horaFimEvento.length() == 0){
            horaFimEvento.setText(hora);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_CANCELED)
        {
            return;
        }
        if (requestCode == CODEIMAGE)
        {
            if (data != null) //veio alguma coisa?
            {
                Uri uri = data.getData(); //uri é responsável por manipular enderecos do recurso

                try
                {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    //esse bitmap representa o recurso de imagem vindo do local URI que foi convertido para um MediaStote

                    imagensEvento.setImageBitmap(bitmap);

                    Log.d("IMAGEM", "Imagem alterada");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    Log.d("IMAGEM", e.getMessage());
                }
            }
        }

    }

    private void openGalery(){
        Intent intent = new Intent(Intent.ACTION_PICK, //o pick permite abrir uma parte especifica do smartphine
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI //o priveder permite acessar funcionalidades do Sistema Operacional
        );
        intent.setType("image/*"); //tipo de arquivo a ser aceito

        startActivityForResult(Intent.createChooser(intent, "Selecione a imagem do livro"), CODEIMAGE);
    }

    public void addEvento(Evento evento) {

        //! ARRUMAR O ID DA EMPRESA
        Call<Evento> call = routerInterface.addEvento(1, evento);
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