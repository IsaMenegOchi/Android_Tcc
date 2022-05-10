package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.Lote;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.util.DateConvert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRegisterAllotmentActivity extends AppCompatActivity {

    private EditText tituloLote, dataInicioLote, dataFimLote,
            horaInicioLote, horaFimLote, quantidadeIngLote,
            minimoLote, maximoLote;

    private Button btnAvancar, btnSalvarLote, btnIngressoGratuito, btnIngressoPago, btnNovoLote;
    RouterInterface routerInterface;

    private Switch switchAbsorvertaxa;

    private ConstraintLayout constraintLayoutAreaIngresso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register_allotment);

        tituloLote = findViewById(R.id.etEventRegisterAllotment_Title);
        dataFimLote = findViewById(R.id.etEventRegisterAllotment_FinishDate);
        dataInicioLote = findViewById(R.id.etEventRegisterAllotment_StartDate);
        horaFimLote = findViewById(R.id.etEventRegisterAllotment_FinishTime);
        horaInicioLote = findViewById(R.id.etEventRegisterAllotment_StartTime);
        quantidadeIngLote = findViewById(R.id.etEventRegisterAllotment_qtdTicket);
        minimoLote = findViewById(R.id.etEventRegisterAllotment_Minimum);
        maximoLote = findViewById(R.id.etEventRegisterAllotment_Maximum);

        switchAbsorvertaxa = findViewById(R.id.swEventResgisterActivity_AbsorveTaxa);

        btnNovoLote = findViewById(R.id.btnEventRegisterAllotment_NewAllotment);
        btnIngressoGratuito = findViewById(R.id.btnEventRegisterAllotment_FreeTicket);
        btnIngressoPago = findViewById(R.id.btnEventRegisterAllotment_PaidTicket);
        btnAvancar = findViewById(R.id.btnEventRegisterAllotment_RegisterAllEvent);
        btnSalvarLote = findViewById(R.id.btnEventRegisterAllotment_FinishRegisterAllotment);

        constraintLayoutAreaIngresso = findViewById(R.id.clEventRegisterAllotment_TicketArea);

    //*COLOCANDO AÇÕES NOS BOTÕES
        btnSalvarLote.setOnClickListener(view -> {

            if (validateFields()) {

                Lote lote = new Lote();

                try {
                    lote.setDataFimVenda(DateConvert.format.parse(dataFimLote.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    lote.setDataInicioVenda(DateConvert.format.parse(dataInicioLote.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                lote.setMaxDeCompraUsuario(Integer.parseInt(maximoLote.getText().toString()));
                lote.setQtdEstoque(Integer.parseInt(quantidadeIngLote.getText().toString()));
                lote.setHoraFimVenda(horaFimLote.getText().toString());
                lote.setHoraInicioVenda(horaInicioLote.getText().toString());
                lote.setMinDeCompraUsuario(Integer.parseInt(minimoLote.getText().toString()));

                if (switchAbsorvertaxa.isChecked()) {
                    lote.setTaxaAbsorvida(true);
                } else {
                    lote.setTaxaAbsorvida(false);
                }

                routerInterface = APIUtil.getApiInterface();
                addLote(lote);

                constraintLayoutAreaIngresso.setVisibility(View.VISIBLE);
            }
        });

        btnIngressoGratuito.setOnClickListener(view -> {
            Intent intent = new Intent(EventRegisterAllotmentActivity.this, TicketActivity.class);
            intent.putExtra("modificarTela", 0);
            intent.putExtra("quantidadeLote", Integer.parseInt(quantidadeIngLote.getText().toString()));
            startActivity(intent);
        });

        btnIngressoPago.setOnClickListener(view -> {
            Intent intent = new Intent(EventRegisterAllotmentActivity.this, TicketActivity.class);
            intent.putExtra("modificarTela", 1);
            intent.putExtra("quantidadeLote", Integer.parseInt(quantidadeIngLote.getText().toString()));
            startActivity(intent);
        });

        btnNovoLote.setOnClickListener(view -> {

        });

    }//FIM DO CREATE

    public void addLote(Lote lote) {

        Call<Lote> call = routerInterface.addLote(lote);
        call.enqueue(new Callback<Lote>() {

            @Override
            public void onResponse(Call<Lote> call, Response<Lote> response) {
                Toast.makeText(EventRegisterAllotmentActivity.this, "Lote inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Lote> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });
    }//fim da funcao addLote

    private boolean validateFields (){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se os campos obrigatorios estao preenchidos
        if (tituloLote.getText().length() == 0){
            Toast.makeText(EventRegisterAllotmentActivity.this, "A quantidade desse ingresso é maior que a colocada no lote", Toast.LENGTH_LONG).show();
            valid = false;
        }


        /** nome **/
        //verifica se o campo de nome esta preenchido
        if (dataInicioLote.getText().length() == 0){
            dataInicioLote.setError( "Voce precisa prencher o campo de titulo");
            valid = false;
        }
        //verifica se o campo de nickname contem mais de 100 caracteres
        if (horaInicioLote.getText().length() == 0){
            horaInicioLote.setError("Você precisa preencher o campo de quantidade de ingresso");
            valid = false;
        }


        /** nickname **/
        //verifica se o campos de nickname esta preenchido
        if (quantidadeIngLote.getText().length() == 0){
            quantidadeIngLote.setError("Voce precisa prencher o campo de preço do ingresso");
            valid = false;
        }

        //verifica se o campo de emil contem mais de 200 caracteres
        if (minimoLote.getText().length() > 200){
            Toast.makeText(EventRegisterAllotmentActivity.this, "Descição inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (maximoLote.getText().length() > 200){
            Toast.makeText(EventRegisterAllotmentActivity.this, "Descição inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;

    }//fim do validateFields
}