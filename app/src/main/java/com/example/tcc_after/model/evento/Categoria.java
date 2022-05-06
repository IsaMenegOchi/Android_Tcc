package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categoria {

    @SerializedName("idCategoria")
    @Expose
    private int idCategoriaEvento;

    @SerializedName("nomeCategoria")
    @Expose
    private String categoriaEvento;

    public Categoria() {
    }

    public Categoria(int idCategoriaEvento, String categoriaEvento) {
        this.idCategoriaEvento = idCategoriaEvento;
        this.categoriaEvento = categoriaEvento;
    }

    public int getIdCategoriaEvento() {
        return idCategoriaEvento;
    }

    public void setIdCategoriaEvento(int idCategoriaEvento) {
        this.idCategoriaEvento = idCategoriaEvento;
    }

    public String getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(String categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }
}
