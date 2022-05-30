package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comentario {
    @SerializedName("idComentario")
    @Expose
    private int idLote;

    @SerializedName("texto")
    @Expose
    private String textComentario;

    public Comentario() {
    }

    public Comentario(int idLote, String textComentario) {
        this.idLote = idLote;
        this.textComentario = textComentario;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public String getTextComentario() {
        return textComentario;
    }

    public void setTextComentario(String textComentario) {
        this.textComentario = textComentario;
    }
}
