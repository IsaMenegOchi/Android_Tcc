package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterActivity01;
import com.example.tcc_after.UI.company.company_register.CompanyRegisterPasswordActivity;
import com.example.tcc_after.model.Ingresso;
import com.example.tcc_after.model.Lote;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRegisterAllotmentActivity extends AppCompatActivity {


    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register_allotment);

        Intent intent = new Intent(EventRegisterAllotmentActivity.this, TicketActivity.class);
        startActivity(intent);
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