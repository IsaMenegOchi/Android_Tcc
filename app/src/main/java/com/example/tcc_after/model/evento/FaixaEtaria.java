package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FaixaEtaria {

    @SerializedName("idFaixaEtaria")
    @Expose
    private int idFaixaEtaria;

    @SerializedName("idade")
    @Expose
    private String idadeFaixaEtaria;

    public FaixaEtaria() {
    }

    public FaixaEtaria(int idFaixaEtaria, String idadeFaixaEtaria) {
        this.idFaixaEtaria = idFaixaEtaria;
        this.idadeFaixaEtaria = idadeFaixaEtaria;
    }

    public int getIdFaixaEtaria() {
        return idFaixaEtaria;
    }

    public void setIdFaixaEtaria(int idFaixaEtaria) {
        this.idFaixaEtaria = idFaixaEtaria;
    }

    public String getIdadeFaixaEtaria() {
        return idadeFaixaEtaria;
    }

    public void setIdadeFaixaEtaria(String idadeFaixaEtaria) {
        this.idadeFaixaEtaria = idadeFaixaEtaria;
    }
}
