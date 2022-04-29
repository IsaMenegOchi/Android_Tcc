package com.example.tcc_after.remote;

import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.model.Empresa;
import com.example.tcc_after.model.Evento;
import com.example.tcc_after.model.Ingresso;
import com.example.tcc_after.model.Lote;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.model.VerificacaoUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RouterInterface {

    //* ROTAS DE USUARIO

    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

        /** ROTAS DE VERIFICAÇÃO DO USUARIO **/

        @POST("/verificacaoUsuario/cadastrarVerificacao/1/")
        Call<VerificacaoUsuario> addVerificacaoUsuario(@Body VerificacaoUsuario verificacaoUsuario);


    //* ROTAS DE EMPRESA

    @POST("perfil/cadastrarPerfilEmpresa/")
    Call<Empresa> addEmpresa(@Body Empresa empresa);

        /** ROTAS DE CONTA BANCARIA DA EMPRESA **/
//        {idEmpresa}
        @POST("/contaEmpresa/cadastrarContaCompleta/1/")
        Call<ContaBancaria> addContaBancaria(@Body ContaBancaria contaBancaria);


        /** ROTAS DE VERIFICAÇÃO DA EMPRESA **/

//        @POST("perfil/cadastrarPerfilEmpresa/")
        //realiza uma requisicao para a rota acima pelo metodo addUsuario
//        Call<VerificacaoEmpresa> addVerificacaoEmpresa(@Body VerificacaoEmpresa verificacaoEmpresa);

    //* ROTAS DE EVENTO

    @POST("evento/cadastrarEvento/1/")
    Call<Evento> addEvento(@Body Evento evento);

        @POST("lote/cadastrarLote/:tblEventoIdEvento/")
        Call<Lote> addLote(@Body Lote lote);

        @POST("variedadeIngresso/cadastrarVariedadeIngresso/")
        Call<Ingresso> addIngresso(@Body Ingresso ingresso);

}
