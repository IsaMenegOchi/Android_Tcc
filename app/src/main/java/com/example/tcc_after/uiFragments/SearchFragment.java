package com.example.tcc_after.uiFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.event.EventDescriptionActivity;
import com.example.tcc_after.model.Pesquisa;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    EditText etPesquisa;
    RouterInterface routerInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etPesquisa = getActivity().findViewById(R.id.etSearch_Search);

        etPesquisa.setOnClickListener(view1 -> {

            Pesquisa pesquisa = new Pesquisa();

            pesquisa.setTituloPesquisa(etPesquisa.getText().toString());

            Call<List<Pesquisa>> pesquisar = routerInterface.pesquisar(pesquisa);
            pesquisar.enqueue(new Callback<List<Pesquisa>>() {
                @Override
                public void onResponse(Call<List<Pesquisa>> call, Response<List<Pesquisa>> response) {

                    List<Pesquisa> listPesquisa = new ArrayList<Pesquisa>();

                    listPesquisa = response.body();

//                    Log.d("teste", String.valueOf(listPesquisa.get(0).getTituloEvento()));
                    RecyclerView recyclerView = getActivity().findViewById(R.id.rcSearch_SearchEvents);
                    recyclerView.setAdapter(new SearchFragment.PesquisaAdapter(listPesquisa));
                }

                @Override
                public void onFailure(Call<List<Pesquisa>> call, Throwable t) {

                }
            });

        });
    }




    private class PesquisaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Pesquisa> listPesquisa;
//        List<TipoEvento> listTiposEvento = new ArrayList<TipoEvento>();



        public PesquisaAdapter(List<Pesquisa> pesquisas) {
            this.listPesquisa = pesquisas;
        }

        //cria a view holder
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SearchFragment.PesquisaAdapter.EventoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false));
        }

        //passsa os dados para a view holder
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Pesquisa pesquisa = this.listPesquisa.get(position);
//            TipoEvento tipoEvento = this.listTiposEvento.get(position);
//            Log.d("teste", "onBindViewHolder: " + listPesquisa.get(0).getIdEvento());
            ((SearchFragment.PesquisaAdapter.EventoViewHolder) holder).setEventoData(pesquisa);

        }


        //conta a quantidade de livros
        @Override
        public int getItemCount() {

            return listPesquisa.size();

        }

        public int getItemViewType(int position) {

            return listPesquisa.size();

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


            public void setEventoData(Pesquisa pesquisa) {
                tvTituloEvento.setText(pesquisa.getTituloEvento());
                tvEmpresa.setText(pesquisa.getEmpresa().getPerfil().getNicknamePerfil());
                tvCategoria.setText(pesquisa.getCategoria().getCategoriaEvento());
//                tvAssunto.setText(evento.getAssunto.getNomeAssunto);
                tvFaixaEtaria.setText(pesquisa.getFaixaEtaria().getIdadeFaixaEtaria());
//                ivEmpresa.setImageBitmap(evento.getImagemPerfilEmpresaEvento());
                tvTipoEvento.setText(pesquisa.getTipoEvento().getTipo());
                idEvento = pesquisa.getIdEvento();
            }
        }//fim da classe livroViewHolder
    }
}