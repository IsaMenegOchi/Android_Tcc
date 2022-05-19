package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Endereco {

    @SerializedName("idEndereco")
    @Expose
    private int idEndereco;


    @SerializedName("cep")
    @Expose
    private String cepEndereco;

    @SerializedName("cidade")
    @Expose
    private String cidadeEndereco;

    @SerializedName("estado")
    @Expose
    private String estadoEndereco;

    public Endereco() {
    }

    public Endereco(int idEndereco, String cepEndereco, String cidadeEndereco, String estadoEndereco) {
        this.idEndereco = idEndereco;
        this.cepEndereco = cepEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.estadoEndereco = estadoEndereco;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }
}
