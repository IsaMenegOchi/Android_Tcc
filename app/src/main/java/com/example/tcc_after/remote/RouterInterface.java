package com.example.tcc_after.remote;

import com.example.tcc_after.model.evento.Assunto;
import com.example.tcc_after.model.evento.Categoria;
import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.model.Empresa;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.Ingresso;
import com.example.tcc_after.model.Lote;
import com.example.tcc_after.model.evento.FaixaEtaria;
import com.example.tcc_after.model.evento.TipoEvento;
import com.example.tcc_after.model.UsuarioComum;
import com.example.tcc_after.model.VerificacaoUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RouterInterface {

    //* ROTAS DE USUARIO

    @GET("/perfil/acharPerfil/{idUsuarioComum}")
    Call<List<UsuarioComum>> getUsuarioComumId(@Path("idUsuarioComum") int idUsuarioComum);

    @GET("/usuarioComum/listarPerfilUsuarios/")
    Call<List<UsuarioComum>> getUsuariosComuns();

    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

    @PUT("/usuarioComum/editarUsuario/{idUsuarioComum}")
    Call<UsuarioComum> updateUsuarioComum(@Path("idUsuarioComum") int idUsuariocomum, @Body UsuarioComum usuarioComum);

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
    Call<List<Empresa>> getEmpresa();

    @POST("perfil/cadastrarPerfilEmpresa/")
    Call<Empresa> addEmpresa(@Body Empresa empresa);

    @PUT("/evento/editarEvento/{idEvento}")
    Call<Empresa> updateEmpresa(@Path("idEvento") int idEvento, @Body Empresa empresa);


        /** ROTAS DE CONTA BANCARIA DA EMPRESA **/
//        {idEmpresa}
        @POST("/contaEmpresa/cadastrarContaCompleta/1/")
        Call<ContaBancaria> addContaBancaria(@Body ContaBancaria contaBancaria);

        @GET("/contaEmpresa/listarContasEmpresa")
        Call<List<ContaBancaria>> getContasBancarias();


        /** ROTAS DE VERIFICAÇÃO DA EMPRESA **/

//        @POST("perfil/cadastrarPerfilEmpresa/")
        //realiza uma requisicao para a rota acima pelo metodo addUsuario
//        Call<VerificacaoEmpresa> addVerificacaoEmpresa(@Body VerificacaoEmpresa verificacaoEmpresa);

    //* ROTAS DE EVENTO

        @POST("evento/cadastrarEventoEndereco/1")
        Call<Evento> addEvento(@Body Evento evento);

        @GET("/evento/listarEvento")
        Call<List<Evento>> getEventos();

        @GET("/evento/acharEventoIdEvento/{idEvento}")
        Call<List<Evento>> getEventoId(@Path("idEvento") int idEvento);

            @GET("/categoria/listarCategorias")
            Call<List<Categoria>> getCategorias();

            @GET("/assunto/listarAssuntos")
            Call<List<Assunto>> getAssuntos();

            @GET("/tipoEvento/listarTipoEvento")
            Call<List<TipoEvento>> getTiposEvento();

            @GET("/faixaEtaria/listarFaixaEtaria")
            Call<List<FaixaEtaria>> getFaixasEtaria();


            //*ROTAS DE LOTE

            @POST("lote/cadastrarLote/1/")
            Call<Lote> addLote(@Body Lote lote);

            //*ROTAS DE INGRESSO

            @POST("variedadeIngresso/cadastrarVariedadeIngresso/")
            Call<Ingresso> addIngresso(@Body Ingresso ingresso);

    //*Fim das rodas de evento
}
