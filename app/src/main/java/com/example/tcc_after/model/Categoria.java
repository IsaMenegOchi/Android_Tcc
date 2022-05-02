package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categoria {

    @SerializedName("idCategoria")
    @Expose
    private int idCategoriaEvento;

    @SerializedName("nomeCategoria")
    @Expose
    private String categoriaEvento;
}
