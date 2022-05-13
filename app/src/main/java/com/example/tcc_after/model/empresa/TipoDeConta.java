package com.example.tcc_after.model.empresa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoDeConta {

    @SerializedName("idTipoConta")
    @Expose
    private int idTipoConta;

    @SerializedName("nomeTipo")
    @Expose
    private String nomeTipo;


    public TipoDeConta() {
    }

    public TipoDeConta(int idTipoConta, String nomeTipo) {
        this.idTipoConta = idTipoConta;
        this.nomeTipo = nomeTipo;
    }

    public int getIdTipoConta() {
        return idTipoConta;
    }

    public void setIdTipoConta(int idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }
}
