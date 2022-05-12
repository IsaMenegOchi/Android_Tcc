package com.example.tcc_after.remote;

import com.example.tcc_after.model.Banco;
import com.example.tcc_after.model.evento.Assunto;
import com.example.tcc_after.model.evento.Categoria;
import com.example.tcc_after.model.ContaBancaria;
import com.example.tcc_after.model.Empresa;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.Ingresso;
import com.example.tcc_after.model.Lote;
import com.example.tcc_after.model.evento.FaixaEtaria;
import com.example.tcc_after.model.evento.TipoDeConta;
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


    //* ROTAS DE PERFIL
    @DELETE("/perfil/deletarPerfil/{idPerfil}")
    Call<Evento> deletarPerfil(@Path("idPerfil") int idPerfil);

    //* ROTAS DE USUARIO

    //? CADASTRO
    @POST("perfil/cadastrarPerfilUsuarioComumEndereco/")
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

    //? LISTAGEM POR ID
    @GET("/perfil/acharPerfil/{idUsuarioComum}")
    Call<List<UsuarioComum>> getUsuarioComumId(@Path("idUsuarioComum") int idUsuarioComum);

    //? LISTAGEM DE TODOS
    @GET("/usuarioComum/listarPerfilUsuarios/")
    Call<List<UsuarioComum>> getUsuariosComuns();

    //? EDIÇÃO
    @PUT("/perfil/editarPerfilUsuarioComum/{idPerfil}")
    Call<UsuarioComum> updateUsuarioComum(@Path("idPerfil") int idPerfilUsuarioComum, @Body UsuarioComum usuarioComum);

    //? DELEÇÃO
    @DELETE("/usuarioComum/deletarUsuario/{idUsuarioComum}")
    Call<UsuarioComum> delUsuarioComum(@Path("idUsuarioComum") int idUsuarioComum);


        //* ROTAS DE VERIFICAÇÃO DO USUARIO

        //? CADASTRO
        @POST("/verificacaoUsuario/cadastrarVerificacao/{idUsuarioComum}/")
        Call<VerificacaoUsuario> addVerificacaoUsuario(@Path("idUsuarioComum") int idUsuarioComum, @Body VerificacaoUsuario verificacaoUsuario);

        //? LISTAGEM DE TODOS
        @GET("/verificacaoUsuario/listarVerificacoes/")
        Call<List<VerificacaoUsuario>> getVerificacaoUsuario();

        //? LISTAGEM POR ID
        @GET("/verificacaoUsuario/acharVerificacaoPorId/{idVerificacaoUsuario}")
        Call<List<VerificacaoUsuario>> getVerificacaoUsuarioId(@Path("idVerificacaoUsuario") int idVerificacaoUsuario);

        @PUT("/verificacaoUsuario/responderVerificacao/{idVerificacaoUsuario}")
        Call<VerificacaoUsuario> updateVerificacaoUsuario(@Path("idVerificacaoUsuario") int idVerificacaoUsuario, @Body VerificacaoUsuario verificacaoUsuario);


    //* ROTAS DE EMPRESA

    //? CADASTRO
    @POST("perfil/cadastrarPerfilEmpresa/")
    Call<Empresa> addEmpresa(@Body Empresa empresa);

    //? LISTAGEM
    @GET("/empresa/listarEmpresas/")
    Call<List<Empresa>> getEmpresa();

    //? EDIÇÃO
    @PUT("/perfil/editarPerfilEmpresa/{idPerfil}")
    Call<Empresa> updateEmpresa(@Path("idPerfil") int idPerfil, @Body Empresa empresa);


        //* ROTAS DE CONTA BANCARIA DA EMPRESA
        //? CADASTRO
        @POST("/contaEmpresa/cadastrarContaCompleta/{idEmpresa}/")
        Call<ContaBancaria> addContaBancaria(@Path("idEmpresa") int idEmpresa, @Body ContaBancaria contaBancaria);

        //? LISTAGEM
        @GET("/contaEmpresa/listarContasPorIdEmpresa/{idEmpresa}/")
        Call<List<ContaBancaria>> getContasBancarias(@Path("idEmpresa") int idEmpresa);

            @GET("/bancoConta/listarBancoConta/")
            Call<List<Banco>> getBancos();

            @GET("/tipoConta/listarTiposConta/")
            Call<List<TipoDeConta>> getTiposConta();


        /** ROTAS DE VERIFICAÇÃO DA EMPRESA **/

//        @POST("perfil/cadastrarPerfilEmpresa/")
        //realiza uma requisicao para a rota acima pelo metodo addUsuario
//        Call<VerificacaoEmpresa> addVerificacaoEmpresa(@Body VerificacaoEmpresa verificacaoEmpresa);

    //* ROTAS DE EVENTO

        //? CADASTRO
        @POST("/evento/cadastrarEventoEndereco/{idEmpresa}")
        Call<Evento> addEvento(@Path("idEmpresa") int idEmpresa, @Body Evento evento);

        //? LISTAGEM DE TODOS
        @GET("/evento/listarEvento")
        Call<List<Evento>> getEventos();

        //? LISTAGEM POR ID DO EVENTO
        @GET("/evento/acharEventoIdEvento/{idEvento}")
        Call<List<Evento>> getEventoIdEvento(@Path("idEvento") int idEvento);

        //? LISTAGEM POR ID DA EMPRESA
        @GET("/evento/acharEventoPorId/{idEmpresa}")
        Call<List<Evento>> getEventoIdEmpresa(@Path("idEmpresa") int idEmpresa);

        //? EDIÇÃO
        @PUT("/evento/editarEvento/{idEvento}")
        Call<Evento> updateEvento(@Path("idEvento") int idEvento);

        //? DELEÇÃO
        @DELETE("/evento/deletarEvento/{idEvento}")
        Call<Evento> deleteEvento(@Path("idEvento") int idEvento);

            //* CATEGORIA
            //? LISTAGEM DE TODOS
            @GET("/categoria/listarCategorias")
            Call<List<Categoria>> getCategorias();

            //* ASSUNTOS
            //? LISTAGEM DE TODOS
            @GET("/assunto/listarAssuntos")
            Call<List<Assunto>> getAssuntos();

            //* TIPOS DE EVENTOS
            //? LISTAGEM DE TODOS
            @GET("/tipoEvento/listarTipoEvento")
            Call<List<TipoEvento>> getTiposEvento();

            //* FAIXA ETÁRIA
            //? LISTAGEM DE TODOS
            @GET("/faixaEtaria/listarFaixaEtaria")
            Call<List<FaixaEtaria>> getFaixasEtaria();


            //*ROTAS DE LOTE

            //? CADASTRO
            @POST("lote/cadastrarLote/{idEmpresa}/")
            Call<Lote> addLote(@Path("idEmpresa")int idEmpresa, @Body Lote lote);

            //? LISTAGEM DE TODOS
            @GET("/lote/listarLote")
            Call<List<Lote>> getLote();

            //? EDIÇÃO
            @PUT("/lote/editarLote/{idLote}")
            Call<Lote> updateLote(@Path("idLote") int idLote, @Body Lote lote);

            //?DELEÇÃO
            @DELETE("/lote/deletarLote/{idLote}")
            Call<Lote> deleteLote(@Path("idLote") int idLote);


            //*ROTAS DE INGRESSO

            //? CADASTRO
            @POST("variedadeIngresso/cadastrarVariedadeIngresso/")
            Call<Ingresso> addIngresso(@Body Ingresso ingresso);

            //? LISTAGEM DE TODOS
            @GET("/variedadeIngresso/listarVariedadeIngresso")
            Call<List<Ingresso>> getIngresso();

            //? EDICÃO
            @PUT("/variedadeIngresso/editarVariedadeIngresso/{idVariedadeIngressoLote}")
            Call<Ingresso> updateIngresso(@Path("idVariedadeIngressoLote") int idVariedadeIngressoLote, @Body Ingresso ingresso);

            //? DELEÇÃO
            @DELETE("/variedadeIngresso/deletarVariedadeIngresso/{idVariedadeIngressoLote}")
            Call<Ingresso> deleteIngresso(@Path("idVariedadeIngressoLote") int idVariedadeIngressoLote);

    //*Fim das rodas de evento
}
