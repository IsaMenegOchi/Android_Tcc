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




    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(int tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public int getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(int descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public int getCapaEvento() {
        return capaEvento;
    }

    public void setCapaEvento(int capaEvento) {
        this.capaEvento = capaEvento;
    }

    public int getDataInicioEvento() {
        return dataInicioEvento;
    }

    public void setDataInicioEvento(int dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    public int getDataFimEvento() {
        return dataFimEvento;
    }

    public void setDataFimEvento(int dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    public int getHoraInicioEvento() {
        return horaInicioEvento;
    }

    public void setHoraInicioEvento(int horaInicioEvento) {
        this.horaInicioEvento = horaInicioEvento;
    }

    public int getHoraFimEvento() {
        return horaFimEvento;
    }

    public void setHoraFimEvento(int horaFimEvento) {
        this.horaFimEvento = horaFimEvento;
    }

    public int getTaxaAbsorvidaEvento() {
        return taxaAbsorvidaEvento;
    }

    public void setTaxaAbsorvidaEvento(int taxaAbsorvidaEvento) {
        this.taxaAbsorvidaEvento = taxaAbsorvidaEvento;
    }

    public int getIdCategoriaEvento() {
        return idCategoriaEvento;
    }

    public void setIdCategoriaEvento(int idCategoriaEvento) {
        this.idCategoriaEvento = idCategoriaEvento;
    }

    public int getNomeCategoriaEvento() {
        return nomeCategoriaEvento;
    }

    public void setNomeCategoriaEvento(int nomeCategoriaEvento) {
        this.nomeCategoriaEvento = nomeCategoriaEvento;
    }

    public int getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(int idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public int getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getIdFaixaEtariaEvento() {
        return idFaixaEtariaEvento;
    }

    public void setIdFaixaEtariaEvento(int idFaixaEtariaEvento) {
        this.idFaixaEtariaEvento = idFaixaEtariaEvento;
    }

    public int getIdadeEvento() {
        return idadeEvento;
    }

    public void setIdadeEvento(int idadeEvento) {
        this.idadeEvento = idadeEvento;
    }
}
