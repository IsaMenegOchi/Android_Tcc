package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evento {


    /** EVENTO **/

    @SerializedName("idEvento")
    @Expose
    private int idEvento;

    @SerializedName("titulo")
    @Expose
    private int tituloEvento;

    @SerializedName("descricao")
    @Expose
    private int descricaoEvento;

    @SerializedName("capa")
    @Expose
    private int capaEvento;

    @SerializedName("dataInicio")
    @Expose
    private int dataInicioEvento;

    @SerializedName("dataFim")
    @Expose
    private int dataFimEvento;

    @SerializedName("horaInicio")
    @Expose
    private int horaInicioEvento;

    @SerializedName("horaFim")
    @Expose
    private int horaFimEvento;

    @SerializedName("taxaAbsorvida")
    @Expose
    private int taxaAbsorvidaEvento;

    /** CATEGORIA **/

    @SerializedName("idCategoria")
    @Expose
    private int idCategoriaEvento;

    @SerializedName("nomeCategoria")
    @Expose
    private int nomeCategoriaEvento;

    /** TIPO EVENTO **/

    @SerializedName("idTipoEvento")
    @Expose
    private int idTipoEvento;

    @SerializedName("tipo")
    @Expose
    private int tipoEvento;

    /** FAIXA ETARIA **/

    @SerializedName("idFaixaEtaria")
    @Expose
    private int idFaixaEtariaEvento;

    @SerializedName("idade")
    @Expose
    private int idadeEvento;

}
