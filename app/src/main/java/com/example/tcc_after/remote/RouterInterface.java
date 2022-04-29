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
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RouterInterface {

    //* ROTAS DE USUARIO

    @GET("/usuarioComum/acharPerfilUsuario/{idUsuarioComum}")
    Call<List<UsuarioComum>> getUsuarioComumId(@Path("idUsuarioComum") int idUsuarioComum);

    @GET("/usuarioComum/listarPerfilUsuarios/")
    Call<UsuarioComum> getUsuarioComum();

    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

//    @PUT;

    @DELETE("/usuarioComum/deletarUsuario/{idUsuarioComum}")
    Call<UsuarioComum> delUsuarioComum(@Path("idUsuarioComum") int idUsuarioComum);


        /** ROTAS DE VERIFICAÇÃO DO USUARIO **/

        @POST("/verificacaoUsuario/cadastrarVerificacao/1/")
        Call<VerificacaoUsuario> addVerificacaoUsuario(@Body VerificacaoUsuario verificacaoUsuario);

        @GET("/verificacaoUsuario/listarVerificacoes/")
        Call<VerificacaoUsuario> getVerificacaoUsuario();
//!FAZER
//        @GET("/verificacaoUsuario/listarVerificacoes/{idVerificacaoUsuario}")
//        Call<VerificacaoUsuario> getVerificacaoUsuarioId();


    //* ROTAS DE EMPRESA

    @GET("/empresa/listarEmpresas/")
    Call<Empresa> getEmpresa();

    //!FAZER
//    @GET("/empresa/listarEmpresas/{idEmpresa}/")
//    Call<Empresa> getEmpresaId(@Path("idEmpresa") int idEmpresa);

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
