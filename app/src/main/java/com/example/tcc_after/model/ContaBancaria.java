package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContaBancaria {

    /** CONTA BANCARIA **/
    @SerializedName("idContaEmpresa")
    @Expose
    private int idContaBancaria;

    @SerializedName("agencia")
    @Expose
    private int agenciaCB;

    @SerializedName("numeroConta")
    @Expose
    private int numeroCB;

    @SerializedName("digito")
    @Expose
    private int digitoCB;

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

    public ContaBancaria(int idContaBancaria, int agenciaCB, int numeroCB, int digitoCB, int idTipoCB, String nomeTipoCB, int idBancoContaCB, String nomeBancoCB) {
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

    public int getAgenciaCB() {
        return agenciaCB;
    }

    public void setAgenciaCB(int agenciaCB) {
        this.agenciaCB = agenciaCB;
    }

    public int getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(int numeroCB) {
        this.numeroCB = numeroCB;
    }

    public int getDigitoCB() {
        return digitoCB;
    }

    public void setDigitoCB(int digitoCB) {
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
