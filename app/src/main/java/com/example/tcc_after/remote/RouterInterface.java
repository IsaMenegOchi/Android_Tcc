package com.example.tcc_after.remote;

import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.model.Empresa;
import com.example.tcc_after.model.Evento;
import com.example.tcc_after.model.UsuarioComum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RouterInterface {

    /** ROTAS DE USUARIO **/

    //Pegar o verbo http e colocar o caminho
    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

        /** ROTAS DE VERIFICAÇÃO DO USUARIO **/

    //        @POST("/verificacaoUsuario/cadastrarVerificacao/:tblUsuarioComumIdUsuarioComum/")
        //realiza uma requisicao para a rota acima pelo metodo addUsuario
    //        Call<VerificacaoUsuario> addVerificacaoUsuario(@Body VerificacaoUsuario verificacaoUsuario);

    /** ROTAS DE EMPRESA **/

    @POST("perfil/cadastrarPerfilEmpresa/")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<Empresa> addEmpresa(@Body Empresa empresa);

        /** ROTAS DE CONTA BANCARIA DA EMPRESA **/

        @POST("/bancoConta/cadastrarBancoConta/")
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

}
