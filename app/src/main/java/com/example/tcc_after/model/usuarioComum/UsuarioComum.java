package com.example.tcc_after.model.usuarioComum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UsuarioComum {

    /** TRANSFORMANDO ATRIBUTOS EM JSON**/
    @SerializedName("idUsuarioComum")
    @Expose
    private int idUsuario;

    @SerializedName("idPerfil")
    @Expose
    private int idPerfil;

    @SerializedName("idEnderecoUsuario")
    @Expose
    private int idEnderecoUsuario;

    @SerializedName("nome")
    @Expose
    private String nomeCompletoUsuario;

    @SerializedName("nickname")
    @Expose
    private String nicknameUsuario;

    @SerializedName("email")
    @Expose
    private String emailUsuario;

    @SerializedName("senha")
    @Expose
    private String senhaUsuario;

    @SerializedName("imagemPerfil")
    @Expose
    private String imagemPerfilUsuario;

    @SerializedName("imagemFundo")
    @Expose
    private String imagemFundoUsuario;

    @SerializedName("dataNasc")
    @Expose
    private Date dataNascUsuario;

    @SerializedName("biografia")
    @Expose
    private String biografiaUsuario;

    @SerializedName("cep")
    @Expose
    private String cepUsuario;

    @SerializedName("cidade")
    @Expose
    private String cidadeUsuario;

    @SerializedName("estado")
    @Expose
    private String estadoUsuario;


    /** CRIAÇÃO DOS CONSTRUTORES **/

    // Construtor dos construtores vazios
    public UsuarioComum() {
    }

    //Criação dos construtores com comandos


    public UsuarioComum(int idUsuario, int idPerfil, int idEnderecoUsuario,
                        String nomeCompletoUsuario, String nicknameUsuario,
                        String emailUsuario, String senhaUsuario, String imagemPerfilUsuario,
                        String imagemFundoUsuario, Date dataNascUsuario, String biografia,
                        String cep, String cidade, String estado) {
        this.idUsuario = idUsuario;
        this.idPerfil = idPerfil;
        this.idEnderecoUsuario = idEnderecoUsuario;
        this.nomeCompletoUsuario = nomeCompletoUsuario;
        this.nicknameUsuario = nicknameUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.imagemPerfilUsuario = imagemPerfilUsuario;
        this.imagemFundoUsuario = imagemFundoUsuario;
        this.dataNascUsuario = dataNascUsuario;
        this.biografiaUsuario = biografia;
        this.cepUsuario = cep;
        this.cidadeUsuario = cidade;
        this.estadoUsuario = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
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

    public String getImagemPerfilUsuario() {
        return imagemPerfilUsuario;
    }

    public void setImagemPerfilUsuario(String imagemPerfilUsuario) {
        this.imagemPerfilUsuario = imagemPerfilUsuario;
    }

    public String getImagemFundoUsuario() {
        return imagemFundoUsuario;
    }

    public void setImagemFundoUsuario(String imagemFundoUsuario) {
        this.imagemFundoUsuario = imagemFundoUsuario;
    }

    public Date getDataNascUsuario() {
        return dataNascUsuario;
    }

    public void setDataNascUsuario(Date dataNascUsuario) {
        this.dataNascUsuario = dataNascUsuario;
    }

    public String getBiografia() {
        return biografiaUsuario;
    }

    public void setBiografia(String biografia) {
        this.biografiaUsuario = biografia;
    }

    public int getIdEnderecoUsuario() {
        return idEnderecoUsuario;
    }

    public void setIdEnderecoUsuario(int idEnderecoUsuario) {
        this.idEnderecoUsuario = idEnderecoUsuario;
    }

    public String getCep() {
        return cepUsuario;
    }

    public void setCep(String cep) {
        this.cepUsuario = cep;
    }

    public String getCidade() {
        return cidadeUsuario;
    }

    public void setCidade(String cidade) {
        this.cidadeUsuario = cidade;
    }

    public String getEstado() {
        return estadoUsuario;
    }

    public void setEstado(String estado) {
        this.estadoUsuario = estado;
    }
}

