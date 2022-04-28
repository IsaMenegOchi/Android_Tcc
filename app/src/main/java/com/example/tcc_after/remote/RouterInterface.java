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

    /** ROTAS DE USUARIO **/

    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

        /** ROTAS DE VERIFICAÇÃO DO USUARIO **/

        @POST("/verificacaoUsuario/cadastrarVerificacao/1/")
        Call<VerificacaoUsuario> addVerificacaoUsuario(@Body VerificacaoUsuario verificacaoUsuario);


    /** ROTAS DE EMPRESA **/

    @POST("perfil/cadastrarPerfilEmpresa/")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<Empresa> addEmpresa(@Body Empresa empresa);

        /** ROTAS DE CONTA BANCARIA DA EMPRESA **/

        @POST("/contaEmpresa/cadastrarContaCompleta/1/")
//        realiza uma requisicao para a rota acima pelo metodo addUsuario
        Call<ContaBancaria> addContaBancaria(@Body ContaBancaria contaBancaria);


        /** ROTAS DE VERIFICAÇÃO DA EMPRESA **/

//        @POST("perfil/cadastrarPerfilEmpresa/")
        //realiza uma requisicao para a rota acima pelo metodo addUsuario
//        Call<VerificacaoEmpresa> addVerificacaoEmpresa(@Body VerificacaoEmpresa verificacaoEmpresa);

    /** ROTAS DE EVENTO **/

    @POST("evento/cadastrarEvento/:tblEmpresaIdEmpresa/")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<Evento> addEvento(@Body Evento evento);

        @POST("evento/cadastrarEvento/:tblEmpresaIdEmpresa/")
            //realiza uma requisicao para a rota acima pelo metodo addUsuario
        Call<Lote> addLote(@Body Lote lote);

        @POST("evento/cadastrarEvento/:tblEmpresaIdEmpresa/")
            //realiza uma requisicao para a rota acima pelo metodo addUsuario
        Call<Ingresso> addIngresso(@Body Ingresso ingresso);

}
