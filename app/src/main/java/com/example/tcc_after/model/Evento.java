package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.util.Date;

public class Evento {


    /** EVENTO **/

    @SerializedName("idEvento")
    @Expose
    private int idEvento;

    @SerializedName("titulo")
    @Expose
    private String tituloEvento;

    @SerializedName("descricao")
    @Expose
    private String descricaoEvento;

    @SerializedName("capa")
    @Expose
    private String capaEvento;

    @SerializedName("dataInicio")
    @Expose
    private Date dataInicioEvento;

    @SerializedName("dataFim")
    @Expose
    private Date dataFimEvento;

    @SerializedName("horaInicio")
    @Expose
    private Time horaInicioEvento;

    @SerializedName("horaFim")
    @Expose
    private Time horaFimEvento;

    @SerializedName("taxaAbsorvida")
    @Expose
    private boolean taxaAbsorvidaEvento;

    /** CATEGORIA **/

    @SerializedName("idCategoria")
    @Expose
    private int idCategoriaEvento;

    @SerializedName("nomeCategoria")
    @Expose
    private String nomeCategoriaEvento;

    /** TIPO EVENTO **/

    @SerializedName("idTipoEvento")
    @Expose
    private int idTipoEvento;

    @SerializedName("tipo")
    @Expose
    private String tipoEvento;

    /** FAIXA ETARIA **/

    @SerializedName("idFaixaEtaria")
    @Expose
    private int idFaixaEtariaEvento;

    @SerializedName("idade")
    @Expose
    private int idadeEvento;

    @SerializedName("idAssunto")
    @Expose
    private int idAssuntoEvento;

    @SerializedName("assunto")
    @Expose
    private int assuntoEvento;

    @SerializedName("idCategoria")
    @Expose
    private int idCategoriaevento;

    @SerializedName("categoria")
    @Expose
    private int categoriaevento;


    public Evento() {
    }


}
