package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IntermAssuntoEvento {

    @SerializedName("idIntermEventoAssunto")
    @Expose
    private int idIntermAssuntoEvento;

    @SerializedName("tblAssunto")
    @Expose
    private Assunto assunto;

    @SerializedName("tblEventoIdEvento")
    @Expose
    private Evento idEvento;

    public IntermAssuntoEvento() {
    }

    public int getIdIntermAssuntoEvento() {
        return idIntermAssuntoEvento;
    }

    public void setIdIntermAssuntoEvento(int idIntermAssuntoEvento) {
        this.idIntermAssuntoEvento = idIntermAssuntoEvento;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }
}
