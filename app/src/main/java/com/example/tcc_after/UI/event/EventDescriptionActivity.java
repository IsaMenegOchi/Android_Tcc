package com.example.tcc_after.UI.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.tcc_after.uiFragments.FeedFragment;
import com.example.tcc_after.util.DateConvert;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDescriptionActivity extends AppCompatActivity {

    private TextView tvTituloEvento, tvNomeEmpresa, tvNomeCelebridade, tvDataInicio, tvHoraInicio, tvValorMin, tvLocal, tvDescricao,
                tvCategoria, tvTipoEvento, tvFaixaEtaria, tvDataFim, tvHoraFim, tvComentario, tvPerfil, tvNenhumComentario, tvAssunto;

    private ImageView ivPerfil, ivSendComent;
    private int idComentario;

    private Button btnComprar;
    private EditText etComentario;
    private RecyclerView recyclerView;

//    int idEvento = 3;

    RouterInterface routerInterface;
    int idPerfil = 2;
//    int valorMin = 0;
//    int valorMax = 0;
    private String local;
    List<Evento> listEvento = new ArrayList<Evento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);
        routerInterface = APIUtil.getApiInterface();

        int idEvento = getIntent().getExtras().getInt("idEvento");

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
        tvNenhumComentario = findViewById(R.id.tvEventDescription_NoComents);
        tvLocal = findViewById(R.id.tvEventDescription_Place);
        recyclerView = findViewById(R.id.rcEventDescription_Coments);
        etComentario = findViewById(R.id.etEventDescription_AddComent);
        tvAssunto = findViewById(R.id.tvEventDescription_Subject);
//        btnComprar.setOnClickListener(startActivity(new Intent(EventDescriptionActivity.this, PandemicWarningFragment.class)));

        Call<List<Comentario>> getComentarios = routerInterface.getComentarios(idEvento);
        getComentarios.enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {

                if (response.isSuccessful()) {
                    List<Comentario> listComentario = new ArrayList<Comentario>();
                    listComentario = response.body();

                    if (listComentario.size() == 0){
                        tvNenhumComentario.setVisibility(View.VISIBLE);
                    }
                    else{

                        recyclerView.setAdapter(new ComentarioAdapter(listComentario));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {

            }
        });

        Call<List<Evento>> getEventoId = routerInterface.getEventoIdEvento(idEvento);
        getEventoId.enqueue(new Callback<List<Evento>>() {

            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if (response.isSuccessful()) {
                    listEvento = response.body();

                    tvTituloEvento.setText(listEvento.get(0).getTituloEvento());
                    tvNomeEmpresa.setText("by "+ listEvento.get(0).getEmpresa().getPerfil().getNicknamePerfil());
//                    tvNomeCelebridade.setText(listEvento.get(0).getNicknameCelebridadeEvento());
                    tvDataInicio.setText(DateConvert.format.format(listEvento.get(0).getDataInicioEvento()));
                    if (listEvento.get(0).getDataFimEvento() == null) {
                        tvDataFim.setVisibility(View.GONE);
                    } else {
                        tvDataFim.setText(DateConvert.format.format(listEvento.get(0).getDataFimEvento()));
                    }
                    tvHoraInicio.setText(listEvento.get(0).getHoraInicioEvento().replaceFirst(":00", ""));


                    if (listEvento.get(0).getEnderecoEvento().get(0).getComplemento() == null || listEvento.get(0).getEnderecoEvento().get(0).getComplemento().equals("") ){
                        local = listEvento.get(0).getEnderecoEvento().get(0).getLogradouro() + ", " + listEvento.get(0).getEnderecoEvento().get(0).getNumero() + " - " +
                                listEvento.get(0).getEnderecoEvento().get(0).getCidade() + " - " + listEvento.get(0).getEnderecoEvento().get(0).getEstado();

                    }
                    else{
                        local = listEvento.get(0).getEnderecoEvento().get(0).getLogradouro() + ", " + listEvento.get(0).getEnderecoEvento().get(0).getNumero() + " - " +
                                listEvento.get(0).getEnderecoEvento().get(0).getCidade() + "("  + listEvento.get(0).getEnderecoEvento().get(0).getComplemento() + ")" + " - " + listEvento.get(0).getEnderecoEvento().get(0).getEstado();
                    }

                    tvLocal.setText(local);
                    tvDescricao.setText(listEvento.get(0).getDescricaoEvento());
                    tvTipoEvento.setText(listEvento.get(0).getTipoEvento().getTipo());
                    tvCategoria.setText(listEvento.get(0).getCategoria().getCategoriaEvento());
                    tvFaixaEtaria.setText(listEvento.get(0).getFaixaEtaria().getIdadeFaixaEtaria());

//                        tvAssunto.setVisibility(View.VISIBLE);
//                        tvAssunto.setText();

                    tvValorMin.setText("R$ " + listEvento.get(0).getLote().get(0).getIngressoLote().get(0).getValor());
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                Log.d("teste", "onFailure: " + t.getMessage());
            }
    });

        ivSendComent.setOnClickListener(view -> {
            if (!etComentario.getText().toString().trim().equals("") && etComentario.getText().toString().length() != 0) {

                Comentario comentario = new Comentario();
                comentario.setTextComentario(etComentario.getText().toString().trim());

                Call<Comentario> postComentario = routerInterface.postComentarios(idPerfil, idEvento, comentario);
                postComentario.enqueue(new Callback<Comentario>() {
                    @Override
                    public void onResponse(Call<Comentario> call, Response<Comentario> response) {
//                    Toast.makeText(EventDescriptionActivity.this, "Você cadastrou um comentário", Toast.LENGTH_SHORT).show();
                        recreate();
                        etComentario.setText("");
                    }

                    @Override
                    public void onFailure(Call<Comentario> call, Throwable t) {

                    }
                });
            }
        });

        btnComprar.setOnClickListener(view -> {
//            startActivity(new Intent(this, ));
        });
    }


    private class ComentarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Comentario> listComentarios;

        public ComentarioAdapter(List<Comentario> comentario) {
            this.listComentarios = comentario;
        }

        //cria a view holder
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ComentarioAdapter.ComentarioViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_coment, parent, false));
        }

        //passsa os dados para a view holder
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            Comentario comentario = this.listComentarios.get(position);
            ((ComentarioViewHolder) holder).setEventoData(comentario);

        }

        //conta a quantidade de livros
        @Override
        public int getItemCount() {

            return listComentarios.size();

        }

        public int getItemViewType(int position) {

            return listComentarios.size();

        }

        class ComentarioViewHolder extends RecyclerView.ViewHolder {

            public ComentarioViewHolder(@NonNull View itemView) {
                super(itemView);

                tvComentario = itemView.findViewById(R.id.tvCardComent_Coment);
                ivPerfil = itemView.findViewById(R.id.ivCardComent_ImagePerfil);
                tvPerfil = itemView.findViewById(R.id.tvCardComent_PerfilName);

            }


            public void setEventoData(Comentario comentario) {
                if (tvComentario != null){
                    tvComentario.setText(comentario.getTextComentario());
                    tvPerfil.setText(comentario.getPerfil().getNicknamePerfil());
//                ivPerfil.setImageBitmap(evento.getComentarios().get(0).getPerfil().getNicknamePerfil());

                }
            }
        }
    }
}