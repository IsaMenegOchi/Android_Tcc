package com.example.tcc_after.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.uiFragments.FeedFragment;
import com.example.tcc_after.uiFragments.user.perfil.UserPerfilFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedActivity extends AppCompatActivity {


    RouterInterface routerInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_feed);

        routerInterface = APIUtil.getApiInterface();
        Call<List<Evento>> call = routerInterface.getEventos();

        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if (response.isSuccessful()) {
                    List<Evento> list = new ArrayList<Evento>();
                    List<String> eventos = new ArrayList<String>();

                    list = response.body();

//                    for (int i = 0; i < list.size(); i++) {
//
//                    }
                    RecyclerView recyclerView = findViewById(R.id.rcFeed_CardEvent);
                    recyclerView.setAdapter(new EventoAdapter(list));

                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });


    }

    private class EventoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Evento> evento;

        public EventoAdapter(List<Evento> eventos) {
            this.evento = eventos;
        }

        //cria a view holder
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EventoAdapter.EventoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false));
        }

        //passsa os dados para a view holder
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Evento evento = new Evento();
            ((EventoAdapter.EventoViewHolder) holder).setEventoData(evento);
        }



        //conta a quantidade de livros
        @Override
        public int getItemCount() {

            return evento.size();

        }


        public int getItemViewType(int position) {

            return evento.size();

        }

        class EventoViewHolder extends RecyclerView.ViewHolder {

            /**
             * ATRIBUTOS DA CLASS LIVROVIEWHOLDER
             **/
            private TextView tvTituloEvento, tvEmpresa, tvTipoEvento, tvCelebridade;
            private int idEvento;

            //View itemView - elementos de view (et, tv, btn)
            //o item_conteiner entre na no itemView
            public EventoViewHolder(@NonNull View itemView) {
                //estamos chamando o mestoto construtor de quem foi herdado
                super(itemView);

                tvTituloEvento = itemView.findViewById(R.id.tvCardEvent_Title);
                tvEmpresa = itemView.findViewById(R.id.tvCardEvent_Company);
                tvTipoEvento = itemView.findViewById(R.id.tvCardEvent_EventType);
                tvCelebridade = itemView.findViewById(R.id.tvCardEvent_Atractions);

                /** AÇÃO DE CLIQUE PARA EDITAR LIVRO E EXCLUIR LIVRO **/

                itemView.setOnClickListener(view -> {


                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(FeedActivity.this)
                            .setMessage("O que você deseja fazer?")
                            .setPositiveButton("Editar", (dialog1, witch) -> {

                                Intent intent = new Intent(FeedActivity.this, UserPerfilFragment.class);
                                intent.putExtra("idEvento", idEvento);
                                startActivity(intent);
                            })
                            .setNegativeButton("Excluir", (dialog1, witch) -> {

                                routerInterface = APIUtil.getApiInterface();
                                Call<Evento> call = routerInterface.deleteEvento(idEvento);
                                call.enqueue(new Callback<Evento>() {
                                    @Override
                                    public void onResponse(Call<Evento> call, Response<Evento> response) {
                                        Toast.makeText(FeedActivity.this, "Você exclui um livro", Toast.LENGTH_SHORT).show();
                                        //                                        recreate();
                                        //                                        finish();
                                        //                                        overridePendingTransition(0,0);
                                        //                                        startActivity(getIntent());
                                        //                                        overridePendingTransition(0, 0);
                                    }

                                    @Override
                                    public void onFailure(Call<Evento> call, Throwable t) {
                                        Toast.makeText(FeedActivity.this, "Nao pegamos eventos", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            });
                    alertDialog.show();
                });

            }//fim do construtor da classe eventoviewholder


            public void setEventoData(Evento evento) {
                tvTituloEvento.setText(evento.getTituloEvento());
//                tvEmpresa.setText(evento.getNicknameEmpresaEvento());
                tvTipoEvento.setText(evento.getTipoEvento());
//                tvCelebridade.setText(evento.getNicknameCelEvento());
                idEvento = evento.getIdEvento();
            }
        }//fim da classe livroViewHolder
    }

}