package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.Lote;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRegisterAllotmentActivity extends AppCompatActivity {

    private EditText tituloLote, dataInicioLote, dataFimLote,
            horaInicioLote, horaFimLote, quantidadeIngLote,
            minimoLote, maximoLote;

    private Button btnAvancar, btnSalvarLote, btnIngressoGratuito, btnIngressoPago;
    RouterInterface routerInterface;

    public static Switch switchAbsorvertaxa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register_allotment);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        tituloLote = findViewById(R.id.etEventRegisterAllotment_Title);
        dataFimLote = findViewById(R.id.etEventRegisterAllotment_FinishDate);
        dataInicioLote = findViewById(R.id.etEventRegisterAllotment_StartDate);
        horaFimLote = findViewById(R.id.etEventRegisterAllotment_FinishTime);
        horaInicioLote = findViewById(R.id.etEventRegisterAllotment_StartTime);
        quantidadeIngLote = findViewById(R.id.etEventRegisterAllotment_qtdTicket);
        minimoLote = findViewById(R.id.etEventRegisterAllotment_Minimum);
        maximoLote = findViewById(R.id.etEventRegisterAllotment_Maximum);



        btnAvancar = findViewById(R.id.btnEventRegisterAllotment_RegisterAllEvent);
        btnSalvarLote = findViewById(R.id.btnEventRegisterAllotment_FinishRegisterAllotment);

        btnSalvarLote.setOnClickListener(view -> {

            Lote lote = new Lote();

            try {
                lote.setDataFimVenda(format.parse(dataFimLote.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                lote.setDataInicioVenda(format.parse(dataInicioLote.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            lote.setMaxDeCompraUsuario(Integer.parseInt(maximoLote.getText().toString()));
            lote.setQtdEstoque(Integer.parseInt(quantidadeIngLote.getText().toString()));
//            lote.setHoraFimVenda(Time.valueOf(horaFimLote.getText().toString()));
//            lote.setHoraInicioVenda(Time.valueOf(horaInicioLote.getText().toString()));
            lote.setMinDeCompraUsuario(Integer.parseInt(minimoLote.getText().toString()));

            if (switchAbsorvertaxa.isChecked()){
                lote.setTaxaAbsorvida(true);
            }
            else{
                lote.setTaxaAbsorvida(false);
            }

            routerInterface = APIUtil.getApiInterface();
            addLote(lote);

            Intent intent = new Intent(EventRegisterAllotmentActivity.this, TicketActivity.class);
            startActivity(intent);

        });


    }

    public void addLote(Lote lote) {

        Call<Lote> call = routerInterface.addLote(lote);
        call.enqueue(new Callback<Lote>() {

            @Override
            public void onResponse(Call<Lote> call, Response<Lote> response) {
                Toast.makeText(EventRegisterAllotmentActivity.this, "Ingresso inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Lote> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }//fim do onFailure
        }); //fim do enqueue e do calback
    }// fim da funcao addEmprea
}