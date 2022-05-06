package com.example.tcc_after.model.evento;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assunto {

    @SerializedName("idAssunto")
    @Expose
    private int idAssuntoEvento;

    @SerializedName("nomeAssunto")
    @Expose
    private String assuntoEvento;

    public Assunto() {
    }


    public Assunto(int idAssuntoEvento, String assuntoEvento) {
        this.idAssuntoEvento = idAssuntoEvento;
        this.assuntoEvento = assuntoEvento;
    }

    public int getIdAssuntoEvento() {
        return idAssuntoEvento;
    }

    public void setIdAssuntoEvento(int idAssuntoEvento) {
        this.idAssuntoEvento = idAssuntoEvento;
    }

    public String getAssuntoEvento() {
        return assuntoEvento;
    }

    public void setAssuntoEvento(String assuntoEvento) {
        this.assuntoEvento = assuntoEvento;
    }


}
