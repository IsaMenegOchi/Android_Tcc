package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Empresa {

    @SerializedName("idEmpresa")
    @Expose
    private int idEmpresa;

    @SerializedName("cnpj")
    @Expose
    private int cnpjEmpresa;

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

}
