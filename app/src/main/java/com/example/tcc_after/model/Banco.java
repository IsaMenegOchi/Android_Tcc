package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banco {

    @SerializedName("idBancoConta")
    @Expose
    private int idBancoConta;

    @SerializedName("nomeBanco")
    @Expose
    private String nomeBanco;


    public Banco() {
    }

    public Banco(int idBancoConta, String nomeBanco) {
        this.idBancoConta = idBancoConta;
        this.nomeBanco = nomeBanco;
    }


    public int getIdBancoConta() {
        return idBancoConta;
    }

    public void setIdBancoConta(int idBancoConta) {
        this.idBancoConta = idBancoConta;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}
