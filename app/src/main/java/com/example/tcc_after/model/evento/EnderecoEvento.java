package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EnderecoEvento {


    @SerializedName("idEnderecoEvento")
    @Expose
    private int idEnderecoEvento;

    @SerializedName("cep")
    @Expose
    private String cep;

    @SerializedName("logradouro")
    @Expose
    private String logradouro;

    @SerializedName("complemento")
    @Expose
    private String complemento;

    @SerializedName("bairro")
    @Expose
    private String bairro;

    @SerializedName("cidade")
    @Expose
    private String cidade;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("numero")
    @Expose
    private String numero;

    @SerializedName("tblEventoIdEvento")
    @Expose
    private Integer idEvento;

    public EnderecoEvento() {
    }

    public EnderecoEvento(int idEnderecoEvento, String cep, String logradouro, String complemento, String bairro, String cidade, String estado, String numero, Integer idEvento) {
        this.idEnderecoEvento = idEnderecoEvento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.idEvento = idEvento;
    }

    public int getIdEnderecoEvento() {
        return idEnderecoEvento;
    }

    public void setIdEnderecoEvento(int idEnderecoEvento) {
        this.idEnderecoEvento = idEnderecoEvento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
}
