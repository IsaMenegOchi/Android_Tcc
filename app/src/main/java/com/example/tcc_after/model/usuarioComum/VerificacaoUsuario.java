package com.example.tcc_after.model.usuarioComum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerificacaoUsuario {

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


    public VerificacaoUsuario() {
    }

    public VerificacaoUsuario(int idVerificacaoUsuario, String verFicknameUsuario, boolean verStatusUsuario, String verNomeUsuario, String verArquivoDocUsuario, String verJustifivativaSUsuario, String getVerJustifivativaRUsuario) {
        this.idVerificacaoUsuario = idVerificacaoUsuario;
        this.verNicknameUsuario = verFicknameUsuario;
        this.verStatusUsuario = verStatusUsuario;
        this.verNomeUsuario = verNomeUsuario;
        this.verArquivoDocUsuario = verArquivoDocUsuario;
        this.verJustifivativaSUsuario = verJustifivativaSUsuario;
        this.getVerJustifivativaRUsuario = getVerJustifivativaRUsuario;
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
