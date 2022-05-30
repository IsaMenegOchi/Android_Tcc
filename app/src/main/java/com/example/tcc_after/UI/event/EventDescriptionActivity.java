package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.evento.Comentario;
import com.example.tcc_after.model.evento.EnderecoEvento;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDescriptionActivity extends AppCompatActivity {

    TextView tvTituloEvento, tvNomeEmpresa, tvNomeCelebridade, tvDataInicio, tvHoraInicio, tvValorMin, tvLocal, tvDescricao,
                tvCategoria, tvTipoEvento, tvFaixaEtaria;

    ImageView ivSendComent;
    EditText etComentario;

//    int idEvento = 3;

    RouterInterface routerInterface;
    int idPerfil = 2;
    List<Evento> listEvento = new ArrayList<Evento>();
    List<EnderecoEvento> listEnderecoEvento = new ArrayList<EnderecoEvento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);


        int idEvento = getIntent().getExtras().getInt("idEvento");

        tvTituloEvento = findViewById(R.id.tvEventDescription_EventTitle);
        tvNomeEmpresa = findViewById(R.id.tvEventDescription_Company);
        tvDataInicio = findViewById(R.id.tvEventDescription_Date);
        tvHoraInicio = findViewById(R.id.tvEventDescription_Hour);
        tvValorMin = findViewById(R.id.tvEventDescription_LowPrice);
        tvDescricao = findViewById(R.id.tvEventDescription_Description);
        tvCategoria = findViewById(R.id.tvEventDescription_Category);
        tvFaixaEtaria = findViewById(R.id.tvEventDescription_Age);
        tvTipoEvento = findViewById(R.id.tvEventDescription_EventType);

        ivSendComent = findViewById(R.id.ivEventdescription_SendComent);

        tvLocal = findViewById(R.id.tvEventDescription_Place);

        etComentario = findViewById(R.id.etEventDescription_AddComent);

        routerInterface = APIUtil.getApiInterface();
        Call<List<Evento>> getEventoId = routerInterface.getEventoIdEvento(idEvento);

        Log.d("teste", "onResponse: estou no create");

        getEventoId.enqueue(new Callback<List<Evento>>() {

            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                Log.d("teste", "onResponse: estou no on response" );

                if (response.isSuccessful()){
                    listEvento = response.body();

                    tvTituloEvento.setText(listEvento.get(0).getTituloEvento());
                    tvNomeEmpresa.setText(listEvento.get(0).getEmpresa().getNicknameEmpresa());
//                    tvNomeCelebridade.setText(listEvento.get(0).getNicknameCelebridadeEvento());
                    tvDataInicio.setText("Hora de início: " + listEvento.get(0).getDataInicioEvento().toString());
                    tvHoraInicio.setText(listEvento.get(0).getHoraInicioEvento().replaceFirst(":00", ""));
                    String local = listEvento.get(0).getEnderecoEvento().get(0).getLogradouro() + ", " + listEvento.get(0).getEnderecoEvento().get(0).getNumero() + " - " +
                            listEvento.get(0).getEnderecoEvento().get(0).getCidade() + " - " + listEvento.get(0).getEnderecoEvento().get(0).getEstado();
                    tvLocal.setText(local);
                    tvDescricao.setText(listEvento.get(0).getDescricaoEvento());
                    tvTipoEvento.setText(listEvento.get(0).getTipoEvento().getTipo());
                    tvCategoria.setText(listEvento.get(0).getCategoria().getCategoriaEvento());
                    tvFaixaEtaria.setText(listEvento.get(0).getFaixaEtaria().getIdadeFaixaEtaria());

                    int valorMin = 0;
//
//                    for (int i = 0; i <= listEvento.get(i).getLote().get(i).getIngressoLote().get(i).getValor(); i++){
//
//
//                    }
//
//                    tvValorMin.setText(valorMin);

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