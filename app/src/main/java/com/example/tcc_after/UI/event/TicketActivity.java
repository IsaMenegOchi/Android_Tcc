package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.evento.Ingresso;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketActivity extends AppCompatActivity {

//    Switch switch;
    private EditText tituloIngresso, quantidadeIngresso, precoIngresso, descricaoIngresso;
    private TextView precoGratuitoIngresso, tituloTela;
    private Button btnCadastrar;
    private Switch swAdicionarMeia;

    public static int qtdLote;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_ticket);


        int tipoDeIngresso = getIntent().getExtras().getInt("modificarTela");
//        int tipoDeIngresso = 0;
        int quantidadeIngressoLote = getIntent().getExtras().getInt("quantidadeLote");
//        int quantidadeIngressoLote = 200;
        qtdLote = quantidadeIngressoLote;


        tituloIngresso = findViewById(R.id.etCompanyPaidTicket_TicketTitle);
        quantidadeIngresso = findViewById(R.id.etCompanyPaidTicket_Qtdd);
        precoIngresso = findViewById(R.id.etCompanyPaidTicket_Price);
        descricaoIngresso = findViewById(R.id.etCompanyPaidTicket_Description);

        tituloTela = findViewById(R.id.tvCompanyPaidTicket_Title);
        precoGratuitoIngresso = findViewById(R.id.tvCompanyPaidTicket_FreePrice);

        btnCadastrar = findViewById(R.id.btnCompanyPaidTicket_Finish);

        swAdicionarMeia = findViewById(R.id.switchCompanyPaidTicket_HalfTicket);


        if (tipoDeIngresso == 1){
            precoGratuitoIngresso.setVisibility(View.GONE);
            precoIngresso.setVisibility(View.VISIBLE);
        }

        else {
            precoGratuitoIngresso.setVisibility(View.VISIBLE);
            precoIngresso.setVisibility(View.GONE);
            tituloTela.setText(R.string.freeTicket);
            swAdicionarMeia.setVisibility(View.GONE);
        }

        btnCadastrar.setOnClickListener(view -> {

            if (validateFields()) {
                Ingresso ingresso = new Ingresso();
                ingresso.setQtdIngresso(Integer.parseInt(quantidadeIngresso.getText().toString()));
                ingresso.setTitulo(tituloIngresso.getText().toString());
                ingresso.setDescricaoIngresso(descricaoIngresso.getText().toString());
                if (tipoDeIngresso == 1){
                    ingresso.setValor(Float.parseFloat(precoIngresso.getText().toString()));
                }
                else{
                    ingresso.setValor(0.0F);
                }
                ingresso.setIdLoteIngresso(1);

                routerInterface = APIUtil.getApiInterface();
                addIngresso(ingresso);
            }
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
    }// fim da funcao addIngresso


    private boolean validateFields (){

        //cria uma variavel que se inicia com true
        boolean valid = true;

        //verifica se os campos obrigatorios estao preenchidos
        if (Integer.parseInt(quantidadeIngresso.getText().toString()) > qtdLote){
            quantidadeIngresso.setError("A quantidade de ingressos inseridos é maior que a inseridas no lote");
            valid = false;
        }


        /** nome **/
        //verifica se o campo de nome esta preenchido
        if (tituloIngresso.getText().length() == 0){
            tituloIngresso.setError( "Voce precisa prencher o campo de titulo");
            valid = false;
        }
        //verifica se o campo de nickname contem mais de 100 caracteres
        if (quantidadeIngresso.getText().length() == 0){
            quantidadeIngresso.setError("Você precisa preencher o campo de quantidade de ingresso");
            valid = false;
        }


        /** nickname **/
        //verifica se o campos de nickname esta preenchido
        if (precoIngresso.getText().length() == 0){
            precoIngresso.setError("Voce precisa prencher o campo de preço do ingresso");
            valid = false;
        }

        //verifica se o campo de emil contem mais de 200 caracteres
        if (descricaoIngresso.getText().length() > 200){
            Toast.makeText(TicketActivity.this, "Descição inserido é muito grande", Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }
}