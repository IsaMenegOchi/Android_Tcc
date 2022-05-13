package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingresso {

    @SerializedName("idVariedadeIngressoLote")
    @Expose
    private int idIngresso;

    @SerializedName("quantidade")
    @Expose
    private int qtdIngresso;

    @SerializedName("descricao")
    @Expose
    private String descricaoIngresso;

    @SerializedName("valor")
    @Expose
    private Float valor;

    @SerializedName("tituloIngresso")
    @Expose
    private String titulo;

    @SerializedName("tblLoteIdLote")
    @Expose
    private int idLoteIngresso;

    public Ingresso() {
    }

    public Ingresso(int idIngresso, int qtdIngresso, String descricaoIngresso, Float valor, String titulo, int idLoteIngresso) {
        this.idIngresso = idIngresso;
        this.qtdIngresso = qtdIngresso;
        this.descricaoIngresso = descricaoIngresso;
        this.valor = valor;
        this.titulo = titulo;
        this.idLoteIngresso = idLoteIngresso;
    }


    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public int getQtdIngresso() {
        return qtdIngresso;
    }

    public void setQtdIngresso(int qtdIngresso) {
        this.qtdIngresso = qtdIngresso;
    }

    public String getDescricaoIngresso() {
        return descricaoIngresso;
    }

    public void setDescricaoIngresso(String descricaoIngresso) {
        this.descricaoIngresso = descricaoIngresso;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdLoteIngresso() {
        return idLoteIngresso;
    }

    public void setIdLoteIngresso(int idLoteIngresso) {
        this.idLoteIngresso = idLoteIngresso;
    }
}
