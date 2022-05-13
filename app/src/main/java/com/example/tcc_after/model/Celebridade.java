package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Celebridade {

    @SerializedName("idCelebridade")
    @Expose
    private int idCelebridade;

    //? trazendo dados de tipo celebridade
    @SerializedName("idTipoCelebridade")
    @Expose
    private int idTipoCelebridade;

    @SerializedName("tipo")
    @Expose
    private String nomeTipoCelebridade;

    //? trazendo dados de verificacao usuario
    @SerializedName("idVerificacaoUsuario")
    @Expose
    private int idVerificacaoUsuario;

    @SerializedName("nickname")
    @Expose
    private String verNicknameUsuario;

    @SerializedName("status")
    @Expose
    private boolean verStatusUsuario;

    @SerializedName("nomeCompleto")
    @Expose
    private String verNomeUsuario;

    @SerializedName("arquivoDoc")
    @Expose
    private String verArquivoDocUsuario;

    @SerializedName("justificativaSolicitacao")
    @Expose
    private String verJustifivativaSUsuario;

    @SerializedName("justificativaResposta")
    @Expose
    private String getVerJustifivativaRUsuario;

    public Celebridade() {
    }

    public Celebridade(int idCelebridade, int idTipoCelebridade, String nomeTipoCelebridade, int idVerificacaoUsuario, String verNicknameUsuario, boolean verStatusUsuario, String verNomeUsuario, String verArquivoDocUsuario, String verJustifivativaSUsuario, String getVerJustifivativaRUsuario) {
        this.idCelebridade = idCelebridade;
        this.idTipoCelebridade = idTipoCelebridade;
        this.nomeTipoCelebridade = nomeTipoCelebridade;
        this.idVerificacaoUsuario = idVerificacaoUsuario;
        this.verNicknameUsuario = verNicknameUsuario;
        this.verStatusUsuario = verStatusUsuario;
        this.verNomeUsuario = verNomeUsuario;
        this.verArquivoDocUsuario = verArquivoDocUsuario;
        this.verJustifivativaSUsuario = verJustifivativaSUsuario;
        this.getVerJustifivativaRUsuario = getVerJustifivativaRUsuario;
    }

    public int getIdCelebridade() {
        return idCelebridade;
    }

    public void setIdCelebridade(int idCelebridade) {
        this.idCelebridade = idCelebridade;
    }

    public int getIdTipoCelebridade() {
        return idTipoCelebridade;
    }

    public void setIdTipoCelebridade(int idTipoCelebridade) {
        this.idTipoCelebridade = idTipoCelebridade;
    }

    public String getNomeTipoCelebridade() {
        return nomeTipoCelebridade;
    }

    public void setNomeTipoCelebridade(String nomeTipoCelebridade) {
        this.nomeTipoCelebridade = nomeTipoCelebridade;
    }

    public int getIdVerificacaoUsuario() {
        return idVerificacaoUsuario;
    }

    public void setIdVerificacaoUsuario(int idVerificacaoUsuario) {
        this.idVerificacaoUsuario = idVerificacaoUsuario;
    }

    public String getVerNicknameUsuario() {
        return verNicknameUsuario;
    }

    public void setVerNicknameUsuario(String verNicknameUsuario) {
        this.verNicknameUsuario = verNicknameUsuario;
    }

    public boolean isVerStatusUsuario() {
        return verStatusUsuario;
    }

    public void setVerStatusUsuario(boolean verStatusUsuario) {
        this.verStatusUsuario = verStatusUsuario;
    }

    public String getVerNomeUsuario() {
        return verNomeUsuario;
    }

    public void setVerNomeUsuario(String verNomeUsuario) {
        this.verNomeUsuario = verNomeUsuario;
    }

    public String getVerArquivoDocUsuario() {
        return verArquivoDocUsuario;
    }

    public void setVerArquivoDocUsuario(String verArquivoDocUsuario) {
        this.verArquivoDocUsuario = verArquivoDocUsuario;
    }

    public String getVerJustifivativaSUsuario() {
        return verJustifivativaSUsuario;
    }

    public void setVerJustifivativaSUsuario(String verJustifivativaSUsuario) {
        this.verJustifivativaSUsuario = verJustifivativaSUsuario;
    }

    public String getGetVerJustifivativaRUsuario() {
        return getVerJustifivativaRUsuario;
    }

    public void setGetVerJustifivativaRUsuario(String getVerJustifivativaRUsuario) {
        this.getVerJustifivativaRUsuario = getVerJustifivativaRUsuario;
    }
}
