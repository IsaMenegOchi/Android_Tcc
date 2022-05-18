package com.example.tcc_after.model.empresa;

import com.example.tcc_after.model.Perfil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Empresa {

    @SerializedName("idEmpresa")
    @Expose
    private int idEmpresa;

    @SerializedName("cnpj")
    @Expose
    private String cnpjEmpresa;

    @SerializedName("nickname")
    @Expose
    private String nicknameEmpresa;

    @SerializedName("email")
    @Expose
    private String emailEmpresa;

    @SerializedName("senha")
    @Expose
    private String senhaEmpresa;

    @SerializedName("imagemPerfil")
    @Expose
    private String imagemPerfilEmpresa;

    @SerializedName("imagemFundo")
    @Expose
    private String imagemFundoEmpresa;

    @SerializedName("biografia")
    @Expose
    private String biografiaEmpresa;

    @SerializedName("tblPerfil")
    @Expose
    private Perfil perfil;


    public Empresa() {
    }

    public Empresa(int idEmpresa, String cnpjEmpresa, String nicknameEmpresa, String emailEmpresa, String senhaEmpresa, String imagemPerfilEmpresa, String imagemFundoEmpresa, String biografiaEmpresa, Perfil perfil) {
        this.idEmpresa = idEmpresa;
        this.cnpjEmpresa = cnpjEmpresa;
        this.nicknameEmpresa = nicknameEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        this.imagemPerfilEmpresa = imagemPerfilEmpresa;
        this.imagemFundoEmpresa = imagemFundoEmpresa;
        this.biografiaEmpresa = biografiaEmpresa;
        this.perfil = perfil;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getNicknameEmpresa() {
        return nicknameEmpresa;
    }

    public void setNicknameEmpresa(String nicknameEmpresa) {
        this.nicknameEmpresa = nicknameEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
    }

    public String getImagemPerfilEmpresa() {
        return imagemPerfilEmpresa;
    }

    public void setImagemPerfilEmpresa(String imagemPerfilEmpresa) {
        this.imagemPerfilEmpresa = imagemPerfilEmpresa;
    }

    public String getImagemFundoEmpresa() {
        return imagemFundoEmpresa;
    }

    public void setImagemFundoEmpresa(String imagemFundoEmpresa) {
        this.imagemFundoEmpresa = imagemFundoEmpresa;
    }

    public String getBiografiaEmpresa() {
        return biografiaEmpresa;
    }

    public void setBiografiaEmpresa(String biografiaEmpresa) {
        this.biografiaEmpresa = biografiaEmpresa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
