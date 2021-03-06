package com.example.tcc_after.uiFragments.company;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.LoginActivity;
import com.example.tcc_after.UI.event.EventDescriptionActivity;
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.model.Perfil;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.uiFragments.FeedFragment;
import com.example.tcc_after.uiFragments.user.perfil.PerfilUserFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyPerfilFragment#newInstance} factory method to
=======
import com.example.tcc_after.UI.event.EventRegisterActivity;
import com.example.tcc_after.UI.event.EventRegisterAllotmentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the { testeFragment#newInstance} factory method to
>>>>>>> Stashed changes:app/src/main/java/com/example/tcc_after/testeFragment.java
 * create an instance of this fragment.
 */
public class CompanyPerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompanyPerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyPerfilFragment newInstance(String param1, String param2) {
        CompanyPerfilFragment fragment = new CompanyPerfilFragment();
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



    List<Perfil> listPerfil = new ArrayList<Perfil>();
    RouterInterface routerInterface;

    ImageView ivAddEvento, ivFotoPerfil;
    private TextView tvCompanyUsername, tvCompanyBiografia;

    int idPerfil = LoginActivity.idPerfil;
    int idEmpresa = LoginActivity.idEmpresa;

    private TextView tvTituloEvento, tvEmpresa, tvTipoEvento, tvCategoria, tvAssunto, tvFaixaEtaria, tvCelebridade;
    private ImageView ivEmpresa, ivCelebridade1, ivCelebridade2, ivFavorito, ivConfiguracao;
    private int idEvento;
    private int count = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCompanyUsername = getActivity().findViewById(R.id.tvCompanyPerfil_UserName);
        tvCompanyBiografia = getActivity().findViewById(R.id.tvCompanyPerfil_Biografia);
        ivConfiguracao = getActivity().findViewById(R.id.ivCompanyPerfil_Settings);

        ivAddEvento = getActivity().findViewById(R.id.ivCompanyPerfil_AddEvent);
        ivFotoPerfil = getActivity().findViewById(R.id.ivCompanyPhotoRegister_Perfil);

        ivFotoPerfil.setClipToOutline(true);

        routerInterface = APIUtil.getApiInterface();

        ivConfiguracao.setOnClickListener(view1 -> {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        );

        ivAddEvento.setOnClickListener(view1 -> {

            Intent intent = new Intent(getActivity(), EventRegisterActivity.class);
            intent.putExtra("idEmpresa", idEmpresa);
            startActivity(intent);
        });

        Call<List<Perfil>> callPerfil = routerInterface.getPerfilPorId(idPerfil);
        callPerfil.enqueue(new Callback<List<Perfil>>() {
            @Override
            public void onResponse(Call<List<Perfil>> call, Response<List<Perfil>> response) {
                if (response.isSuccessful()){

                    listPerfil = response.body();

                    tvCompanyUsername.setText(listPerfil.get(0).getNicknamePerfil());
                    tvCompanyBiografia.setText(listPerfil.get(0).getBiografiaPerfil());
                }
            }

            @Override
            public void onFailure(Call<List<Perfil>> call, Throwable t) {

            }
        });

        Call<List<Evento>> callEventos = routerInterface.getEventoIdEmpresa(idEmpresa);
        callEventos.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                if (response.isSuccessful()) {
                    List<Evento> list = new ArrayList<Evento>();

                    Log.d("teste", "onResponse: idEmpresa" + idEmpresa);
                    list = response.body();
                    Log.d("teste", "onResponse: tamanho da lista" + list.size());

                    RecyclerView recyclerView = getActivity().findViewById(R.id.rcCompanyPerfil_CardEvent);
                    recyclerView.setAdapter(new CompanyPerfilFragment.EventoAdapter(list));
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });


        // Inflate the layout for this fragment

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_company_perfil, container, false);
    }

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
            return new CompanyPerfilFragment.EventoAdapter.EventoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false));
        }

        //passsa os dados para a view holder
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Evento evento = this.listEventos.get(position);
//            TipoEvento tipoEvento = this.listTiposEvento.get(position);
            Log.d("teste", "onBindViewHolder: " + listEventos.get(0).getIdEvento());
            ((CompanyPerfilFragment.EventoAdapter.EventoViewHolder) holder).setEventoData(evento);

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
                ivFavorito = itemView.findViewById(R.id.ivCardEvent_Favorite);
//                tvCelebridade = itemView.findViewById(R.id.tvCardEvent_Atractions);

                ivEmpresa = itemView.findViewById(R.id.ivCardEvent_Company);
                ivEmpresa.setClipToOutline(true);
//                ivCelebridade1 = itemView.findViewById(R.id.ivCardEvent_person1);
//                ivCelebridade2 = itemView.findViewById(R.id.ivCardEvent_person2);
                Resources res = getContext().getResources();
                Drawable drawableRounded = ResourcesCompat.getDrawable(res, R.drawable.ic_baseline_favorite,null);
                Drawable drawableOutlined = ResourcesCompat.getDrawable(res, R.drawable.ic_baseline_favorite_border,null);

                ivFavorito.setOnClickListener(view -> {
                    count++;
                    if (count %2 == 0){
                        ivFavorito.setImageDrawable(drawableOutlined);
                    }
                    else{
                        ivFavorito.setImageDrawable(drawableRounded);
                    }

                });

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
//                            .setMessage("O que voc?? deseja fazer?")
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
//                                        Toast.makeText(getActivity(), "Voc?? exclui um livro", Toast.LENGTH_SHORT).show();
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
//                tvAssunto.setText(evento.getAssuntoEvento().);
                tvFaixaEtaria.setText(evento.getFaixaEtaria().getIdadeFaixaEtaria());
                tvTipoEvento.setText(evento.getTipoEvento().getTipo());
//                ivEmpresa.setImageBitmap(evento.getImagemPerfilEmpresaEvento());
                idEvento = evento.getIdEvento();
            }
        }//fim da classe livroViewHolder
    }

}