package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoEvento {
    @SerializedName("idTipoEvento")
    @Expose
    private int idTipoEvento;

    @SerializedName("tipo")
    @Expose
    private String tipo;

    public TipoEvento() {
    }

    public TipoEvento(int idTipoEvento, String tipo) {
        this.idTipoEvento = idTipoEvento;
        this.tipo = tipo;
    }

    public int getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(int idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
