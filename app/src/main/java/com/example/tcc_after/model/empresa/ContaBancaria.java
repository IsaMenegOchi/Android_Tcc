package com.example.tcc_after.model.empresa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContaBancaria {

    /** CONTA BANCARIA **/
    @SerializedName("idContaEmpresa")
    @Expose
    private int idContaBancaria;

    @SerializedName("agencia")
    @Expose
    private String agenciaCB;

    @SerializedName("numeroConta")
    @Expose
    private String numeroCB;

    @SerializedName("digito")
    @Expose
    private String digitoCB;

    /** TIPO DE CONTA BANCARIA **/
    @SerializedName("idTipoConta")
    @Expose
    private int idTipoCB;

    @SerializedName("nomeTipo")
    @Expose
    private String nomeTipoCB;

    /** BANCO **/
    @SerializedName("idBancoConta")
    @Expose
    private int idBancoContaCB;

    @SerializedName("nomeBanco")
    @Expose
    private String nomeBancoCB;

    public ContaBancaria() {
    }

    public ContaBancaria(int idContaBancaria, String agenciaCB, String numeroCB, String digitoCB, int idTipoCB, String nomeTipoCB, int idBancoContaCB, String nomeBancoCB) {
        this.idContaBancaria = idContaBancaria;
        this.agenciaCB = agenciaCB;
        this.numeroCB = numeroCB;
        this.digitoCB = digitoCB;
        this.idTipoCB = idTipoCB;
        this.nomeTipoCB = nomeTipoCB;
        this.idBancoContaCB = idBancoContaCB;
        this.nomeBancoCB = nomeBancoCB;
    }


    public int getIdContaBancaria() {
        return idContaBancaria;
    }

    public void setIdContaBancaria(int idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }

    public String getAgenciaCB() {
        return agenciaCB;
    }

    public void setAgenciaCB(String agenciaCB) {
        this.agenciaCB = agenciaCB;
    }

    public String getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(String numeroCB) {
        this.numeroCB = numeroCB;
    }

    public String getDigitoCB() {
        return digitoCB;
    }

    public void setDigitoCB(String digitoCB) {
        this.digitoCB = digitoCB;
    }

    public int getIdTipoCB() {
        return idTipoCB;
    }

    public void setIdTipoCB(int idTipoCB) {
        this.idTipoCB = idTipoCB;
    }

    public String getNomeTipoCB() {
        return nomeTipoCB;
    }

    public void setNomeTipoCB(String nomeTipoCB) {
        this.nomeTipoCB = nomeTipoCB;
    }

    public int getIdBancoContaCB() {
        return idBancoContaCB;
    }

    public void setIdBancoContaCB(int idBancoContaCB) {
        this.idBancoContaCB = idBancoContaCB;
    }

    public String getNomeBancoCB() {
        return nomeBancoCB;
    }

    public void setNomeBancoCB(String nomeBancoCB) {
        this.nomeBancoCB = nomeBancoCB;
    }
}
