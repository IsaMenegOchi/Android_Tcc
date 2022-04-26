package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.util.Date;

public class Lote {

    @SerializedName("idLote")
    @Expose
    private int idLote;

    @SerializedName("qtdEstoque")
    @Expose
    private int qtdEstoque;

    @SerializedName("maxDeCompraPorUsuario")
    @Expose
    private int maxDeCompraUsuario;

    @SerializedName("dataInicio")
    @Expose
    private Date dataInicioVenda;

    @SerializedName("horaInicio")
    @Expose
    private Time horaInicioVenda;

    @SerializedName("dataFim")
    @Expose
    private Date dataFimVenda;

    @SerializedName("horaFim")
    @Expose
    private Time horaFimVenda;

    @SerializedName("taxaAbsovida")
    @Expose
    private Boolean taxaAbsorvida;

    //ADICIONANDO TIPO INGRESSO A MODEL
    @SerializedName("idTipoIngresso")
    @Expose
    private int idTipoIngresso;

    @SerializedName("tipoIngresso")
    @Expose
    private String tipoIngresso;


    @SerializedName("idEvento")
    @Expose
    private int idEventoLote;

    public Lote() {
    }

    public Lote(int idLote, int qtdEstoque, int maxDeCompraUsuario, Date dataInicioVenda, Time horaInicioVenda, Date dataFimVenda, Time horaFimVenda, Boolean taxaAbsorvida, int idTipoIngresso, String tipoIngresso, int idEventoLote) {
        this.idLote = idLote;
        this.qtdEstoque = qtdEstoque;
        this.maxDeCompraUsuario = maxDeCompraUsuario;
        this.dataInicioVenda = dataInicioVenda;
        this.horaInicioVenda = horaInicioVenda;
        this.dataFimVenda = dataFimVenda;
        this.horaFimVenda = horaFimVenda;
        this.taxaAbsorvida = taxaAbsorvida;
        this.idTipoIngresso = idTipoIngresso;
        this.tipoIngresso = tipoIngresso;
        this.idEventoLote = idEventoLote;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getMaxDeCompraUsuario() {
        return maxDeCompraUsuario;
    }

    public void setMaxDeCompraUsuario(int maxDeCompraUsuario) {
        this.maxDeCompraUsuario = maxDeCompraUsuario;
    }

    public Date getDataInicioVenda() {
        return dataInicioVenda;
    }

    public void setDataInicioVenda(Date dataInicioVenda) {
        this.dataInicioVenda = dataInicioVenda;
    }

    public Time getHoraInicioVenda() {
        return horaInicioVenda;
    }

    public void setHoraInicioVenda(Time horaInicioVenda) {
        this.horaInicioVenda = horaInicioVenda;
    }

    public Date getDataFimVenda() {
        return dataFimVenda;
    }

    public void setDataFimVenda(Date dataFimVenda) {
        this.dataFimVenda = dataFimVenda;
    }

    public Time getHoraFimVenda() {
        return horaFimVenda;
    }

    public void setHoraFimVenda(Time horaFimVenda) {
        this.horaFimVenda = horaFimVenda;
    }

    public Boolean getTaxaAbsorvida() {
        return taxaAbsorvida;
    }

    public void setTaxaAbsorvida(Boolean taxaAbsorvida) {
        this.taxaAbsorvida = taxaAbsorvida;
    }

    public int getIdTipoIngresso() {
        return idTipoIngresso;
    }

    public void setIdTipoIngresso(int idTipoIngresso) {
        this.idTipoIngresso = idTipoIngresso;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public int getIdEventoLote() {
        return idEventoLote;
    }

    public void setIdEventoLote(int idEventoLote) {
        this.idEventoLote = idEventoLote;
    }
}
