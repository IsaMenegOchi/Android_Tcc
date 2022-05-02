package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.Ingresso;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketActivity extends AppCompatActivity {

//    Switch switch;
    private EditText tituloIngresso, quantidadeIngresso, precoIngresso, descricaoIngresso;

    private Button btnCadastrar;
    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_ticket);

//        switch (isCheked){
//            edtDescricao.android:visibility="true";
//        }

        tituloIngresso = findViewById(R.id.etCompanyPaidTicket_TicketTitle);
        quantidadeIngresso = findViewById(R.id.etCompanyPaidTicket_Qtdd);
        precoIngresso = findViewById(R.id.etCompanyPaidTicket_Price);
        descricaoIngresso = findViewById(R.id.etCompanyPaidTicket_Description);

        btnCadastrar = findViewById(R.id.btnCompanyPaidTicket_Finish);

        btnCadastrar.setOnClickListener(view -> {
            Ingresso ingresso = new Ingresso();
            ingresso.setQtdIngresso(Integer.parseInt(quantidadeIngresso.getText().toString()));
            ingresso.setTitulo(tituloIngresso.getText().toString());
            ingresso.setValor(Float.parseFloat(precoIngresso.getText().toString()));
            ingresso.setDescricaoIngresso(descricaoIngresso.getText().toString());

        });
    }

    public void addIngresso(Ingresso ingresso) {

        Call<Ingresso> call = routerInterface.addIngresso(ingresso);
        call.enqueue(new Callback<Ingresso>() {

            @Override
            public void onResponse(Call<Ingresso> call, Response<Ingresso> response) {
                Toast.makeText(TicketActivity.this, "Ingresso inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Ingresso> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });
    }// fim da funcao addEmprea
}