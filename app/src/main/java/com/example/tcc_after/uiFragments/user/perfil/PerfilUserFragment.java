package com.example.tcc_after.uiFragments.user.perfil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilUserFragment extends Fragment {



    public PerfilUserFragment() {
        // Required empty public constructor
    }

    public static PerfilUserFragment newInstance(String param1, String param2) {
        PerfilUserFragment fragment = new PerfilUserFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.settingsArray, android.R.layout.simple_spinner_item);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spConfiguracoes.setAdapter(arrayAdapter);

    }

    private Spinner spConfiguracoes;
    private TextView tvNumeroSeguindo, tvEventosPresenciados;
    RouterInterface routerInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {

        spConfiguracoes = requireActivity().findViewById(R.id.spUserPerfil_Config);
        tvNumeroSeguindo = getActivity().findViewById(R.id.tvUserPerfil_NumberFollowing);
        tvEventosPresenciados = getActivity().findViewById(R.id.tvUserPerfil_NumberWitnessedEvents);

        routerInterface = APIUtil.getApiInterface();
        Call<List<Evento>> call = routerInterface.getEventos();

        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if (response.isSuccessful()) {
                    List<Evento> list = new ArrayList<Evento>();

                    list = response.body();
                    Log.d("teste", String.valueOf(list.get(0).getTituloEvento()));


                    RecyclerView recyclerView = getActivity().findViewById(R.id.rcUserPerfil_CardEvent);
                    recyclerView.setAdapter(new PerfilUserFragment.EventoAdapter(list));
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });

        Log.d("teste", "onCreateView: " + spConfiguracoes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.settingsArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spConfiguracoes.setAdapter(adapter);


        spConfiguracoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d("teste", "onItemSelected: " + spConfiguracoes.getSelectedItemPosition());
//                if (spConfiguracoes.getSelectedItemId() == 0){
//                     Fragment fragment = new UserEditPerfilFragment();
//                }
//                else if (spConfiguracoes.getSelectedItemId() == 1){
//                    startActivity(new Intent(getActivity(), VerificacaoUsuario.class));
//                }
//                else if (spConfiguracoes.getSelectedItemId() == 2){
//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity())
//                                    .setMessage("Você deseja sair da sua conta?")
//                                    .setPositiveButton("Sim", (dialog1, witch) -> {
//
//                                    })
//                                    .setNegativeButton("Não", (dialog1, witch) -> {
//
//                                    });
//                            alertDialog.show();
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return inflater.inflate(R.layout.fragment_user_perfil, container, false);
    }



    private class EventoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Evento> listEventos;
//            List<TipoEvento> listTiposEvento = new ArrayList<TipoEvento>();


        public EventoAdapter(List<Evento> eventos) {
            this.listEventos = eventos;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PerfilUserFragment.EventoAdapter.EventoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false));
        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Evento evento = this.listEventos.get(position);
//            TipoEvento tipoEvento = this.listTiposEvento.get(position);
            ((PerfilUserFragment.EventoAdapter.EventoViewHolder) holder).setEventoData(evento);

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

            private TextView tvTituloEvento, tvEmpresa, tvTipoEvento, tvCelebridade;
            private ImageView ivEmpresa, ivCelebridade1, ivCelebridade2, ivCount;
            private int idEvento;


            public EventoViewHolder(@NonNull View itemView) {
                //estamos chamando o mestoto construtor de quem foi herdado
                super(itemView);

                tvTituloEvento = itemView.findViewById(R.id.tvCardEvent_Title);
                tvEmpresa = itemView.findViewById(R.id.tvCardEvent_Company);
                tvTipoEvento = itemView.findViewById(R.id.tvCardEvent_EventType);
//                tvCelebridade = itemView.findViewById(R.id.tvCardEvent_Atractions);

                ivEmpresa = itemView.findViewById(R.id.ivCardEvent_Company);
//                ivCelebridade1 = itemView.findViewById(R.id.ivCardEvent_person1);
//                ivCelebridade2 = itemView.findViewById(R.id.ivCardEvent_person2);


//                    itemView.setOnClickListener(view -> {
//
//                        Log.d("teste", "EventoViewHolder: " + idEvento);


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
//                    });

            }//fim do construtor da classe eventoviewholder


            public void setEventoData(Evento evento) {
                tvTituloEvento.setText(evento.getTituloEvento());
//                tvEmpresa.setText(evento.getNicknameEmpresaEvento());
//                ivEmpresa.setImageBitmap(evento.getImagemPerfilEmpresaEvento());
//                precisamodo cod livro para informar qual estamos editando
//                tvTipoEvento.setText(tipoEvento.getTipo());
//                tvCelebridade.setText(evento.getNicknameCelEvento());
                idEvento = evento.getIdEvento();
            }
        }//fim da classe livroViewHolder
    }
}