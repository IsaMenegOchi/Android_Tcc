package com.example.tcc_after.uiFragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

                if (response.isSuccessful()){
                    List<Evento> list = new ArrayList<Evento>();
                    List<String> eventos = new ArrayList<String>();

                    list = response.body();

                    for(int i = 0; i < list.size(); i++){
//                        eventos.add(list.get(i));
                    }
                    RecyclerView recyclerView = getActivity().findViewById(R.id.rcFeed_CardEvent);
                    recyclerView.setAdapter(new adapterEvento());

                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });

        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    private class EventoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Evento> evento;

        public EventoAdapter(List<Evento> eventos){
            this.evento = eventos;
        }

        //cria a view holder
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EventoAdapter.EventoViewAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_livro, parent, false));
        }

        //passsa os dados para a view holder
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


                ((LivroAdapter.LivroViewHolder) holder).setLivroData(livro); }

        }
        //conta a quantidade de livros
        @Override
        public int getItemCount() {
            return itens.size();
        }


        public int getItemViewType(int position){
            return itens.get(position).getType();
        }


        /** CALSSE DE VIEWHOLDER DA RECYCLERVIEW **/
        //classe que monta a estrutura efetivamente de acorod com os dados que vem do banco de dados
        //ela infla todos os cards que precisa
        //classe que herda uma outra classe
        //precisamos chamar a classe construtora da view holder
        class LivroViewHolder extends RecyclerView.ViewHolder{

            /** ATRIBUTOS DA CLASS LIVROVIEWHOLDER **/
            private TextView tvTituloLivro, tvDescricaoLivro;
            private int cod_livro;

            //View itemView - elementos de view (et, tv, btn)
            //o item_conteiner entre na no itemView
            public LivroViewHolder(@NonNull View itemView) {
                //estamos chamando o mestoto construtor de quem foi herdado
                super(itemView);

                tvTituloLivro = itemView.findViewById(R.id.tvItemContainerLivro_Titulo);
                tvDescricaoLivro = itemView.findViewById(R.id.tvItemContainerLivro_Descricao);

                /** AÇÃO DE CLIQUE PARA EDITAR LIVRO E EXCLUIR LIVRO **/

                itemView.setOnClickListener(view -> {

                    /**
                     * Onde vai abrir
                     * A mensagem que queremos - set message
                     * Confirmr a acao - set posive button
                     *     Parametros:
                     *          1 - titulo
                     *          2 - acao a ser executada
                     * Negar a acao - set negatice button
                     *      Parametros:
                     *          1 - titulo
                     *          2 - acao a ser executada
                     **/
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(FeedLivro.this)
                            .setMessage("O que você deseja fazer?")
                            .setPositiveButton("Editar", (dialog1, witch)->{

                                Intent intent = new Intent(FeedLivro.this, AlterarLivro.class);
                                intent.putExtra("cod_livro", cod_livro);
                                startActivity(intent);
                            })
                            .setNegativeButton("Excluir", (dialog1, witch)->{

                                routerInterfeace = APIUtil.getAPIInterface();
                                Call<Livro> call = routerInterfeace.delLivro(cod_livro);
                                call.enqueue(new Callback<Livro>() {
                                    @Override
                                    public void onResponse(Call<Livro> call, Response<Livro> response) {
                                        Toast.makeText(FeedLivro.this, "Você exclui um livro", Toast.LENGTH_SHORT).show();
                                        recreate();
//                                        finish();
//                                        overridePendingTransition(0,0);
//                                        startActivity(getIntent());
//                                        overridePendingTransition(0, 0);
                                    }

                                    @Override
                                    public void onFailure(Call<Livro> call, Throwable t) {
                                        Toast.makeText(FeedLivro.this, "Nem foi nega", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            })
                            ;
                    alertDialog.show();
                });

            }//fim do construtor da classe livroviewholder

            /** MÉTODO QUE CARREGA OS CALORES NOS ELEMENTOS DE TEXTVIEW
             * tvTituloLivro
             * tvDescricaoLivro
             * **/

            public void setLivroData(Livro livro){
                tvTituloLivro.setText(livro.getTitulo());
                tvDescricaoLivro.setText(livro.getDescricao());
                //precisamodo cod livro para informar qual estamos editando
                cod_livro = livro.getCod_livro();
            }
        }//fim da classe livroViewHolder

    }

}