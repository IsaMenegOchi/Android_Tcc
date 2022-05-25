package com.example.tcc_after.remote;

import com.example.tcc_after.model.Celebridade;
import com.example.tcc_after.model.Perfil;
import com.example.tcc_after.model.empresa.Banco;
import com.example.tcc_after.model.evento.Assunto;
import com.example.tcc_after.model.evento.Categoria;
import com.example.tcc_after.model.empresa.ContaBancaria;
import com.example.tcc_after.model.empresa.Empresa;
import com.example.tcc_after.model.evento.Evento;
import com.example.tcc_after.model.evento.Ingresso;
import com.example.tcc_after.model.evento.Lote;
import com.example.tcc_after.model.evento.FaixaEtaria;
import com.example.tcc_after.model.empresa.TipoDeConta;
import com.example.tcc_after.model.evento.TipoEvento;
import com.example.tcc_after.model.usuarioComum.UsuarioComum;
import com.example.tcc_after.model.usuarioComum.VerificacaoUsuario;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RouterInterface {


    //* ROTAS DE PERFIL
//    @DELETE("/perfil/deletarPerfil/{idPerfil}")
//    Call<Empresa> deletarPerfil(@Path("idPerfil") int idPerfil);

    @GET("/perfil/acharPerfil/{idPerfil}")
    Call<List<Perfil>> getPerfilPorId (@Path("idPerfil") int idPerfil);

    @GET("/perfil/acharPerfil/{idUsuarioComum}")
    Call<List<UsuarioComum>> getPerfilUsuarioComumId(@Path("idUsuarioComum") int idUsuarioComum);

    //* ROTAS DE USUARIO

    //? CADASTRO
    @POST("perfil/cadastrarPerfilUsuarioComumEndereco")
    Call<UsuarioComum> addUsuarioComum(@Body UsuarioComum usuarioComum);

    @FormUrlEncoded
    @POST("/perfil/cadastrarUsuarioComumEnderecoMobile")
    Call<String> addFotosUsuarioComum(
            @Field("nickname") String nickname,
            @Field("email") String email,
            @Field("senha") String senha,
            @Field("cep") String cep,
            @Field("estado") String estado,
            @Field("cidade") String cidade,
            @Field("biografia") String biografia,
            @Field("dataNasc") String dataNasc,
            @Field("nome") String nome,
            @Field("imagemPerfil") String imagemPerfil,
            @Field("imagemFundo") String imagemFundo
    );

    //? LISTAGEM POR ID
    @GET("/usuarioComum/acharPerfilUsuario/{idUsuarioComum}")
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

    @GET("/empresa/acharEmpresaPorId/{idEmpresa}")
    Call<List<Empresa>> getEmpresaPorId(@Path("idEmpresa") int idEmpresa);
    //? EDIÇÃO
    @PUT("/perfil/editarPerfilEmpresa/{idPerfil}")
    Call<Empresa> updateEmpresa(@Path("idPerfil") int idPerfil, @Body Empresa empresa);


        //* ROTAS DE CONTA BANCARIA DA EMPRESA
        //? CADASTRO
        @POST("/contaEmpresa/cadastrarContaCompleta/{idEmpresa}/")
        Call<ContaBancaria> addContaBancaria(@Path("idEmpresa") int idEmpresa, @Body ContaBancaria contaBancaria);

        //? LISTAGEM
        @GET("/contaEmpresa/listarContasPorIdEmpresa/{idEmpresa}/")
        Call<List<ContaBancaria>> getContaBancariaPorId(@Path("idEmpresa") int idEmpresa);

        //! CRIAR EDICAO DE CONTA BANCARIA

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

            @GET("/assunto/listarPorCategoria/{idCategoria}")
            Call<List<Assunto>> getAssuntoPorCategoria(@Path("idCategoria") int idCategoria);

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

    //*celebridade

    //? LISTAGEM DE TODOS
    @GET("/celebridade/listarCelebridades")
    Call<List<Celebridade>> getCelebridades();



}
