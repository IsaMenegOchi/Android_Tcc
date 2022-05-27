package com.example.tcc_after.uiFragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.event.EventDescriptionActivity;
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.evento.TipoEvento;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.uiFragments.event.EventDescriptionFragment;
import com.example.tcc_after.uiFragments.user.perfil.UserPerfilFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragment extends Fragment {

    RouterInterface routerInterface;


    // TODO: Rename and change types and number of parameters
    public static FeedFragment newInstance(String param1, String param2) {
        FeedFragment fragment = new FeedFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        routerInterface = APIUtil.getApiInterface();
        Call<List<Evento>> call = routerInterface.getEventos();

        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if (response.isSuccessful()) {
                    List<Evento> list = new ArrayList<Evento>();
                    List<String> eventos = new ArrayList<String>();

                    list = response.body();
                    Log.d("teste", String.valueOf(list.get(0).getTituloEvento()));
                    RecyclerView recyclerView = getActivity().findViewById(R.id.rcFeed_CardEvent);
                    recyclerView.setAdapter(new EventoAdapter(list));

                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });

        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    //
    private class EventoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Evento> listEventos;
//        List<TipoEvento> listTiposEvento = new ArrayList<TipoEvento>();



        public EventoAdapter(List<Evento> eventos) {
            this.listEventos = eventos;
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
            Evento evento = this.listEventos.get(position);
//            TipoEvento tipoEvento = this.listTiposEvento.get(position);
            Log.d("teste", "onBindViewHolder: " + listEventos.get(0).getIdEvento());
            ((EventoAdapter.EventoViewHolder) holder).setEventoData(evento);

        }


        //conta a quantidade de livros
        @Override
        public int getItemCount() {

            return listEventos.size();

        }

        public int getItemViewType(int position) {

            return listEventos.size();

        }

        class EventoViewHolder extends RecyclerView.ViewHolder {

            /**
             * ATRIBUTOS DA CLASS LIVROVIEWHOLDER
             **/
            private TextView tvTituloEvento, tvEmpresa, tvTipoEvento, tvCategoria, tvAssunto, tvFaixaEtaria, tvCelebridade;
            private ImageView ivEmpresa, ivCelebridade1, ivCelebridade2, ivCount;
            private int idEvento;

            //View itemView - elementos de view (et, tv, btn)
            //o item_conteiner entre na no itemView
            public EventoViewHolder(@NonNull View itemView) {
                //estamos chamando o mestoto construtor de quem foi herdado
                super(itemView);

                tvTituloEvento = itemView.findViewById(R.id.tvCardEvent_Title);
                tvEmpresa = itemView.findViewById(R.id.tvCardEvent_Company);
                tvTipoEvento = itemView.findViewById(R.id.tvCardEvent_EventType);
                tvCategoria = itemView.findViewById(R.id.tvCardEvent_Category);
                tvAssunto = itemView.findViewById(R.id.tvCardEvent_Subject);
                tvFaixaEtaria = itemView.findViewById(R.id.tvCardEvent_Age);
//                tvCelebridade = itemView.findViewById(R.id.tvCardEvent_Atractions);

                ivEmpresa = itemView.findViewById(R.id.ivCardEvent_Company);
//                ivCelebridade1 = itemView.findViewById(R.id.ivCardEvent_person1);
//                ivCelebridade2 = itemView.findViewById(R.id.ivCardEvent_person2);


                itemView.setOnClickListener(view -> {

                    Log.d("teste", "EventoViewHolder: " + idEvento);


                    Intent intent = new Intent(getActivity(), EventDescriptionActivity.class);
                    intent.putExtra("idEvento", idEvento);
                    startActivity(intent);

//                    Fragment fragment = new EventDescriptionFragment();
//                    Log.d("teste", "EventoViewHolder: " + itemView);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("idEvento", idEvento);
//                    fragment.setArguments(bundle);

//                   Fragment fragment = new EventDescriptionFragment();


//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity())
//                            .setMessage("O que você deseja fazer?")
//                            .setPositiveButton("Editar", (dialog1, witch) -> {
//
//                                Intent intent = new Fragment(getActivity(), UserPerfilFragment.class);
//                                intent.putExtra("idEvento", idEvento);
//                                startActivity(intent);
//                            })
//                            .setNegativeButton("Excluir", (dialog1, witch) -> {
//
//                                routerInterface = APIUtil.getApiInterface();
//                                Call<Evento> call = routerInterface.deleteEvento(idEvento);
//                                call.enqueue(new Callback<Evento>() {
//                                    @Override
//                                    public void onResponse(Call<Evento> call, Response<Evento> response) {
//                                        Toast.makeText(getActivity(), "Você exclui um livro", Toast.LENGTH_SHORT).show();
//    //                                        recreate();
//    //                                        finish();
//    //                                        overridePendingTransition(0,0);
//    //                                        startActivity(getIntent());
//    //                                        overridePendingTransition(0, 0);
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<Evento> call, Throwable t) {
//                                        Toast.makeText(getActivity(), "Nao pegamos eventos", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                            });
//                    alertDialog.show();
                });

                }//fim do construtor da classe eventoviewholder


            public void setEventoData(Evento evento) {
                tvTituloEvento.setText(evento.getTituloEvento());
                tvEmpresa.setText(evento.getEmpresa().getPerfil().getNicknamePerfil());
                tvCategoria.setText(evento.getCategoria().getCategoriaEvento());
//                tvAssunto.setText(evento.getAssunto.getNomeAssunto);
                tvFaixaEtaria.setText(evento.getFaixaEtaria().getIdadeFaixaEtaria());
//                ivEmpresa.setImageBitmap(evento.getImagemPerfilEmpresaEvento());
                tvTipoEvento.setText(evento.getTipoEvento().getTipo());
                idEvento = evento.getIdEvento();
            }
        }//fim da classe livroViewHolder
    }

}
