package com.example.tcc_after.UI.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tcc_after.R;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDescriptionActivity extends AppCompatActivity {

    TextView tvTituloEvento, tvNomeEmpresa, tvNomeCelebridade, tvDataInicio, tvHoraInicio, tvValorMin;

    EditText etComentario;

    int idEvento = 3;

    RouterInterface routerInterface;
    List<Evento> listEvento = new ArrayList<Evento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);


//        int idEvento = getIntent().getExtras().getInt("idEvento");

        tvTituloEvento = findViewById(R.id.tvEventDescription_EventTitle);
        tvNomeEmpresa = findViewById(R.id.tvEventDescription_Company);
        tvNomeCelebridade = findViewById(R.id.tvEventDescription_NameAtraction);
        tvDataInicio = findViewById(R.id.tvEventDescription_Date);
        tvHoraInicio = findViewById(R.id.tvEventDescription_Hour);
        tvValorMin = findViewById(R.id.tvEventDescription_LowPrice);

        etComentario = findViewById(R.id.etEventDescription_AddComent);

        routerInterface = APIUtil.getApiInterface();
        Call<List<Evento>> getEventoId = routerInterface.getEventoIdEvento(4);

        Log.d("teste", "onResponse: estou no create");

        getEventoId.enqueue(new Callback<List<Evento>>() {

            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                Log.d("teste", "onResponse: estou no on response" );

                if (response.isSuccessful()){
                    listEvento = response.body();

                    Log.d("teste", "onResponse: " + listEvento);
                    tvTituloEvento.setText(listEvento.get(0).getTituloEvento());
//                    tvNomeEmpresa.setText(listEvento.get(0).getNicknameEmpresaEvento());
//                    tvNomeCelebridade.setText(listEvento.get(0).getNicknameCelebridadeEvento());
                    tvDataInicio.setText(listEvento.get(0).getDataInicioEvento().toString());
                    tvHoraInicio.setText(listEvento.get(0).getHoraInicioEvento());

                    //! fazer leitura de ingressos
//                    tvValorMin.setText(listEvento.get(0).get);

                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });

    }
}