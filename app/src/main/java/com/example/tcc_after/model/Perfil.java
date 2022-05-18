package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perfil {

    @SerializedName("idPerfil")
    @Expose
    private int idPerfil;

    @SerializedName("nickname")
    @Expose
    private String nicknamePerfil;

    @SerializedName("email")
    @Expose
    private String emailPerfil;

    @SerializedName("senha")
    @Expose
    private String senhaPerfil;

    @SerializedName("imagemPerfil")
    @Expose
    private String imagemPerfil;

    @SerializedName("imagemFundo")
    @Expose
    private String imagemFundoPerfil;

    @SerializedName("biografia")
    @Expose
    private String biografiaPerfil;

    public Perfil() {
    }

    public Perfil(int idPerfil, String nicknamePerfil, String emailPerfil, String senhaPerfil, String imagemPerfil, String imagemFundoPerfil, String biografiaPerfil) {
        this.idPerfil = idPerfil;
        this.nicknamePerfil = nicknamePerfil;
        this.emailPerfil = emailPerfil;
        this.senhaPerfil = senhaPerfil;
        this.imagemPerfil = imagemPerfil;
        this.imagemFundoPerfil = imagemFundoPerfil;
        this.biografiaPerfil = biografiaPerfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNicknamePerfil() {
        return nicknamePerfil;
    }

    public void setNicknamePerfil(String nicknamePerfil) {
        this.nicknamePerfil = nicknamePerfil;
    }

    public String getEmailPerfil() {
        return emailPerfil;
    }

    public void setEmailPerfil(String emailPerfil) {
        this.emailPerfil = emailPerfil;
    }

    public String getSenhaPerfil() {
        return senhaPerfil;
    }

    public void setSenhaPerfil(String senhaPerfil) {
        this.senhaPerfil = senhaPerfil;
    }

    public String getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    public String getImagemFundoPerfil() {
        return imagemFundoPerfil;
    }

    public void setImagemFundoPerfil(String imagemFundoPerfil) {
        this.imagemFundoPerfil = imagemFundoPerfil;
    }

    public String getBiografiaPerfil() {
        return biografiaPerfil;
    }

    public void setBiografiaPerfil(String biografiaPerfil) {
        this.biografiaPerfil = biografiaPerfil;
    }
}
