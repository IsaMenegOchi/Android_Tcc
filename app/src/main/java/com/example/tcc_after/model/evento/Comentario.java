package com.example.tcc_after.model.evento;

import com.example.tcc_after.model.Perfil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comentario {
    @SerializedName("idComentario")
    @Expose
    private int idComentario;

    @SerializedName("texto")
    @Expose
    private String textComentario;

    @SerializedName("tblPerfil")
    @Expose
    private Perfil perfil;

    @SerializedName("tblEvento")
    @Expose
    private Evento evento;


    public Comentario() {
    }

    public Comentario(int idComentario, String textComentario) {
        this.idComentario = idComentario;
        this.textComentario = textComentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getTextComentario() {
        return textComentario;
    }

    public void setTextComentario(String textComentario) {
        this.textComentario = textComentario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
