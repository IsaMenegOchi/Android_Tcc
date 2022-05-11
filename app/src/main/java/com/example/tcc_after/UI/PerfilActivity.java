package com.example.tcc_after.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tcc_after.R;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PerfilActivity extends AppCompatActivity {

    private TextView nomeUsuario, biografiaUsuario;
    RouterInterface routerInterface;

    List<UsuarioComum> list = new ArrayList<UsuarioComum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nomeUsuario = findViewById(R.id.tvUserPerfil_UserName);
        biografiaUsuario = findViewById(R.id.tvUserPerfil_Biografia);

        routerInterface = APIUtil.getApiInterface();

    //!ARRUMAR ID DO USUARIO COMUM
        //executa a chama para a rota de listagem de livros
        Call<List<UsuarioComum>> getUsuarioComumId = routerInterface.getUsuarioComumId(1);

        getUsuarioComumId.enqueue(new Callback<List<UsuarioComum>>() {
            @Override
            public void onResponse(Call<List<UsuarioComum>> call, Response<List<UsuarioComum>> response) {
                if(response.isSuccessful()){

                    list = response.body();

                    biografiaUsuario.setText(list.get(0).getBiografia());
                    nomeUsuario.setText(list.get(0).getNicknameUsuario());
                }
            }

            @Override
            public void onFailure(Call<List<UsuarioComum>> call, Throwable t) {

            }
        });


    }
}