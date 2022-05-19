package com.example.tcc_after.UI.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.tcc_after.model.empresa.ContaBancaria;
import com.example.tcc_after.model.empresa.Empresa;
import com.example.tcc_after.remote.APIUtil;
import com.example.tcc_after.remote.RouterInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserEditPerfilActivity extends AppCompatActivity {

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_perfil);

        routerInterface = APIUtil.getApiInterface();
        Call<List<Empresa>> getEmpresaPorId = routerInterface.getEmpresaPorId(idEmpresa);
        getEmpresaPorId.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {

                if (response.isSuccessful()){
                    listEmpresa = response.body();
                    Log.d("teste", "onResponse: " + response);

                    int idEmpresa = listEmpresa.get(0).getIdEmpresa();
                    cnpj.setText(listEmpresa.get(0).getCnpjEmpresa());
                    nickname.setText(listEmpresa.get(0).getPerfil().getNicknamePerfil());
                    biografia.setText(listEmpresa.get(0).getPerfil().getBiografiaPerfil());
                    senha.setText(listEmpresa.get(0).getPerfil().getSenhaPerfil());
                    email.setText(listEmpresa.get(0).getPerfil().getEmailPerfil());

                    Call<List<ContaBancaria>> getContaBancariaPorId = routerInterface.getContaBancariaPorId(idEmpresa);
                    getContaBancariaPorId.enqueue(new Callback<List<ContaBancaria>>() {
    }
}