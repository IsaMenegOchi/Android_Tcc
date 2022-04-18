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



}
