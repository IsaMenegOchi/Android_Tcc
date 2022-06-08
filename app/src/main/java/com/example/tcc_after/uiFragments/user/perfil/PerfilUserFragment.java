package com.example.tcc_after.uiFragments.user.perfil;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tcc_after.R;
import com.example.tcc_after.UI.LoginActivity;
import com.example.tcc_after.model.Perfil;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.usuarioComum.UsuarioComum;
import com.example.tcc_after.model.usuarioComum.VerificacaoUsuario;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;
import com.example.tcc_after.uiFragments.user.verification.AboutVerificationFragment;
import com.example.tcc_after.uiFragments.user.verification.RequestVerificationFragment;

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

    private ImageView ivConfiguracao;
    private ImageView ivFotoUsuario;
    private TextView tvNumeroSeguindo, tvEventosPresenciados, tvNickname, tvBiografia;

    private ActionMenuView actionMenuView;
    RouterInterface routerInterface;

    int idPerfil = LoginActivity.idPerfil;

    List<Perfil> listPerfil = new ArrayList<Perfil>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        routerInterface = APIUtil.getApiInterface();

        ivConfiguracao = requireActivity().findViewById(R.id.amvUserPerfil_Settings);
        tvNumeroSeguindo = getActivity().findViewById(R.id.tvUserPerfil_NumberFollowing);
        tvEventosPresenciados = getActivity().findViewById(R.id.tvUserPerfil_NumberWitnessedEvents);
//        actionMenuView = getActivity().findViewById(R.id.amvUserPerfil_Settings);
        tvNickname = getActivity().findViewById(R.id.tvUserPerfil_UserName);
        tvBiografia = getActivity().findViewById(R.id.tvUserPerfil_Biografia);
        ivFotoUsuario = getActivity().findViewById(R.id.ivUserPhotoRegister_Perfil);

        ivFotoUsuario.setClipToOutline(true);


        ivConfiguracao.setOnClickListener(view1 -> {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
        );

        Call<List<Perfil>> callPerfil = routerInterface.getPerfilPorId(idPerfil);
       callPerfil.enqueue(new Callback<List<Perfil>>() {
           @Override
           public void onResponse(Call<List<Perfil>> call, Response<List<Perfil>> response) {
               if (response.isSuccessful()){

                   listPerfil = response.body();

                   tvNickname.setText(listPerfil.get(0).getNicknamePerfil());
                   tvBiografia.setText(listPerfil.get(0).getBiografiaPerfil());
               }
           }

           @Override
           public void onFailure(Call<List<Perfil>> call, Throwable t) {

           }
       });

        Call<List<Evento>> call = routerInterface.getEventos();
        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {

                if (response.isSuccessful()) {
                    List<Evento> list = new ArrayList<Evento>();

                    list = response.body();

//
//                    RecyclerView recyclerView = getActivity().findViewById(R.id.rcUserPerfil_CardEvent);
//                    recyclerView.setAdapter(new PerfilUserFragment.EventoAdapter(list));
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });


//
//        Log.d("teste", "onCreateView: " + spConfiguracoes);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.settingsArray, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spConfiguracoes.setAdapter(adapter);

//        spConfiguracoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//
//                if (spConfiguracoes.getSelectedItemPosition() == 0){
//
//                    fragmentTransaction.replace(R.id.frameLUserPerfil_Frame, new UserEditPerfilFragment()).commit();
//
//                }
//                else if (spConfiguracoes.getSelectedItemPosition() == 1){
//
//
//                }
//                else if (spConfiguracoes.getSelectedItemPosition() == 2){
//                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity())
//                                    .setMessage("Você deseja sair da sua conta?")
//                                    .setPositiveButton("Sim", (dialog1, witch) -> {
//
//                                        startActivity(new Intent(getActivity(), LoginActivity.class));
//                                    })
//                                    .setNegativeButton("Não", (dialog1, witch) -> {
//
//                                    });
//                            alertDialog.show();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {


        return inflater.inflate(R.layout.fragment_user_perfil, container, false);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (item.getItemId()){
            case R.id.menu_edit:

                fragmentTransaction.replace(R.id.frameLUserPerfil_Frame, new UserEditPerfilFragment()).commit();
                return true;

            case R.id.menu_leave:

                fragmentTransaction.replace(R.id.frameLUserPerfil_Frame, new RequestVerificationFragment()).commit();
                return true;

            case R.id.menu_verification:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity())
                        .setMessage("Você deseja sair da sua conta?")
                        .setPositiveButton("Sim", (dialog1, witch) -> {

                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        })
                        .setNegativeButton("Não", (dialog1, witch) -> {

                        });
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

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