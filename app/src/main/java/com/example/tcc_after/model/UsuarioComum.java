package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UsuarioComum {

    /** TRANSFORMANDO ATRIBUTOS EM JSON**/
    @SerializedName("idUsuario")
    @Expose
    private int idUsuario;

    @SerializedName("nomeCompletoUsuario")
    @Expose
    private String nomeCompletoUsuario;

    @SerializedName("nicknameUsuario")
    @Expose
    private String nicknameUsuario;

    @SerializedName("emailUsuario")
    @Expose
    private String emailUsuario;

    @SerializedName("senhaUsuario")
    @Expose
    private String senhaUsuario;

    @SerializedName("fotoPerfilUsuario")
    @Expose
    private String fotoPerfilUsuario;

    @SerializedName("fotoDeFundoUsuario")
    @Expose
    private String fotoDeFundoUsuario;

    @SerializedName("dataNascUsuario")
    @Expose
    private Date dataNascUsuario;

    @SerializedName("biografiaUsuario")
    @Expose
    private String biografiaUsuario;


    /** CRIAÇÃO DOS CONSTRUTORES **/

    // Construtor dos construtores vazios
    public UsuarioComum() {
    }

    //Criação dos construtores com comandos
    public UsuarioComum(int idUsuario, String nomeCompletoUsuario, String nicknameUsuario,
                        String emailUsuario, String senhaUsuario, String fotoPerfilUsuario,
                        String fotoDeFundoUsuario, Date dataNascUsuario, String biografiaUsuario) {

        this.idUsuario = idUsuario;
        this.nomeCompletoUsuario = nomeCompletoUsuario;
        this.nicknameUsuario = nicknameUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.fotoPerfilUsuario = fotoPerfilUsuario;
        this.fotoDeFundoUsuario = fotoDeFundoUsuario;
        this.dataNascUsuario = dataNascUsuario;
        this.biografiaUsuario = biografiaUsuario;
    }

    /** CRIACAO DE GETTERS E SETTERS **/

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompletoUsuario() {
        return nomeCompletoUsuario;
    }

    public void setNomeCompletoUsuario(String nomeCompletoUsuario) {
        this.nomeCompletoUsuario = nomeCompletoUsuario;
    }

    public String getNicknameUsuario() {
        return nicknameUsuario;
    }

    public void setNicknameUsuario(String nicknameUsuario) {
        this.nicknameUsuario = nicknameUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getFotoPerfilUsuario() {
        return fotoPerfilUsuario;
    }

    public void setFotoPerfilUsuario(String fotoPerfilUsuario) {
        this.fotoPerfilUsuario = fotoPerfilUsuario;
    }

    public String getFotoDeFundoUsuario() {
        return fotoDeFundoUsuario;
    }

    public void setFotoDeFundoUsuario(String fotoDeFundoUsuario) {
        this.fotoDeFundoUsuario = fotoDeFundoUsuario;
    }

    public Date getDatanascUsuario() {
        return dataNascUsuario;
    }

    public void setDatanascUsuario(Date datanascUsuario) {
        this.dataNascUsuario = datanascUsuario;
    }

    public String getBiografiaUsuario() {
        return biografiaUsuario;
    }

    public void setBiografiaUsuario(String biografiaUsuario) {
        this.biografiaUsuario = biografiaUsuario;
    }
}

