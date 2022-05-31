package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.evento.Comentario;
import com.example.tcc_after.model.evento.EnderecoEvento;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.evento.Ingresso;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.uiFragments.user.tickets.buy.PandemicWarningFragment;
import com.example.tcc_after.util.DateConvert;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDescriptionActivity extends AppCompatActivity {

    TextView tvTituloEvento, tvNomeEmpresa, tvNomeCelebridade, tvDataInicio, tvHoraInicio, tvValorMin, tvLocal, tvDescricao,
                tvCategoria, tvTipoEvento, tvFaixaEtaria, tvDataFim, tvHoraFim;

    ImageView ivSendComent;
    Button btnComprar;
    EditText etComentario;

    int idEvento = 3;

    RouterInterface routerInterface;
    int idPerfil = 2;
    int valorMin = 0;
    int valorMax = 0;
    List<Evento> listEvento = new ArrayList<Evento>();
    List<EnderecoEvento> listEnderecoEvento = new ArrayList<EnderecoEvento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);
        routerInterface = APIUtil.getApiInterface();

//        int idEvento = getIntent().getExtras().getInt("idEvento");

        tvTituloEvento = findViewById(R.id.tvEventDescription_EventTitle);
        tvNomeEmpresa = findViewById(R.id.tvEventDescription_Company);
        tvDataInicio = findViewById(R.id.tvEventDescription_StartDate);
        tvDataFim = findViewById(R.id.tvEventDescription_FinishDate);
        tvHoraInicio = findViewById(R.id.tvEventDescription_StartHour);
        tvHoraFim = findViewById(R.id.tvEventDescription_FinishHour);
        tvValorMin = findViewById(R.id.tvEventDescription_LowPrice);
        tvDescricao = findViewById(R.id.tvEventDescription_Description);
        tvCategoria = findViewById(R.id.tvEventDescription_Category);
        tvFaixaEtaria = findViewById(R.id.tvEventDescription_Age);
        tvTipoEvento = findViewById(R.id.tvEventDescription_EventType);
        btnComprar = findViewById(R.id.btnEventDescription_Buy);
        ivSendComent = findViewById(R.id.ivEventdescription_SendComent);

        tvLocal = findViewById(R.id.tvEventDescription_Place);

        etComentario = findViewById(R.id.etEventDescription_AddComent);


//        btnComprar.setOnClickListener(startActivity(new Intent(EventDescriptionActivity.this, PandemicWarningFragment.class)));


        Call<List<Evento>> getEventoId = routerInterface.getEventoIdEvento(idEvento);
        getEventoId.enqueue(new Callback<List<Evento>>() {

            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if (response.isSuccessful()) {
                    listEvento = response.body();

                    tvTituloEvento.setText(listEvento.get(0).getTituloEvento());
                    tvNomeEmpresa.setText(listEvento.get(0).getEmpresa().getPerfil().getNicknamePerfil());
//                    tvNomeCelebridade.setText(listEvento.get(0).getNicknameCelebridadeEvento());
                    tvDataInicio.setText(DateConvert.format.format(listEvento.get(0).getDataInicioEvento()));
                    if (listEvento.get(0).getDataFimEvento() == null) {
                        tvDataFim.setVisibility(View.GONE);
                    } else {
                        tvDataFim.setText(DateConvert.format.format(listEvento.get(0).getDataFimEvento()));
                    }
                    tvHoraInicio.setText(listEvento.get(0).getHoraInicioEvento().replaceFirst(":00", ""));
                    String local = listEvento.get(0).getEnderecoEvento().get(0).getLogradouro() + ", " + listEvento.get(0).getEnderecoEvento().get(0).getNumero() + " - " +
                            listEvento.get(0).getEnderecoEvento().get(0).getCidade() + " - " + listEvento.get(0).getEnderecoEvento().get(0).getEstado();
                    tvLocal.setText(local);
                    tvDescricao.setText(listEvento.get(0).getDescricaoEvento());
                    tvTipoEvento.setText(listEvento.get(0).getTipoEvento().getTipo());
                    tvCategoria.setText(listEvento.get(0).getCategoria().getCategoriaEvento());
                    tvFaixaEtaria.setText(listEvento.get(0).getFaixaEtaria().getIdadeFaixaEtaria());

                    tvValorMin.setText("R$" + String.valueOf(valorMin) + "-" + "R$" + String.valueOf(valorMax));
//
//                    Log.d("teste", "onResponse: " + listEvento.get(0).getLote().get(0).getIngressoLote().size());

                    for (int i = 0; i <= listEvento.get(0).getLote().get(i).getIngressoLote().size(); i++) {
//                        Log.d("teste", "onResponse: " + listEvento.get(0).getLote().get(i).getIngressoLote().size());
                        List<Ingresso> listIngressos = new ArrayList<Ingresso>();
                        listIngressos = listEvento.get(i).getLote().get(i).getIngressoLote();

                        if (listIngressos.get(i).getValor() == 0) {
                            continue;
                        }
                        if (listIngressos.get(i).getValor() > listIngressos.get(i++).getValor()) {
                            valorMin = listIngressos.get(i).getValor().intValue();
                        }
                        if (listIngressos.get(i).getValor() < listIngressos.get(i++).getValor()) {
                            valorMax = listIngressos.get(i).getValor().intValue();
                        }
//
//                    tvValorMin.setText(valorMin);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                Log.d("teste", "onFailure: " + t.getMessage());
            }
        });

        ivSendComent.setOnClickListener(view -> {

            Comentario comentario = new Comentario();
            comentario.setTextComentario(etComentario.getText().toString());

            Call<Comentario> postComentario = routerInterface.postComentarios(idPerfil, idEvento, comentario);
            postComentario.enqueue(new Callback<Comentario>() {
                @Override
                public void onResponse(Call<Comentario> call, Response<Comentario> response) {
                    Toast.makeText(EventDescriptionActivity.this, "Você cadastrou um comentário", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Comentario> call, Throwable t) {

                }
            });
        });




    }

}