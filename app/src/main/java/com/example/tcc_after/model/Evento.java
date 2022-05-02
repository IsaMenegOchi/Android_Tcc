package com.example.tcc_after.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Evento {


    /** EVENTO **/

    @SerializedName("idEvento")
    @Expose
    private int idEvento;

    @SerializedName("titulo")
    @Expose
    private String tituloEvento;

    @SerializedName("descricao")
    @Expose
    private String descricaoEvento;

    @SerializedName("capa")
    @Expose
    private String capaEvento;

    @SerializedName("dataInicio")
    @Expose
    private Date dataInicioEvento;

    @SerializedName("dataFim")
    @Expose
    private Date dataFimEvento;

    @SerializedName("horaInicio")
    @Expose
    private LocalTime horaInicioEvento;

    @SerializedName("horaFim")
    @Expose
    private LocalTime horaFimEvento;


    /** CATEGORIA **/

    @SerializedName("idCategoria")
    @Expose
    private int idCategoriaEvento;

    @SerializedName("nomeCategoria")
    @Expose
    private String categoriaEvento;

    /** TIPO EVENTO **/

    @SerializedName("idTipoEvento")
    @Expose
    private int idTipoEvento;

    @SerializedName("tipo")
    @Expose
    private String tipoEvento;

    /** FAIXA ETARIA **/

    @SerializedName("idFaixaEtaria")
    @Expose
    private int idFaixaEtariaEvento;

    @SerializedName("idade")
    @Expose
    private int faixaEtariaEvento;

    /** ASSUNTO EVENTO **/

    @SerializedName("idAssunto")
    @Expose
    private int idAssuntoEvento;

    @SerializedName("assunto")
    @Expose
    private String assuntoEvento;


    /** CATEGORIA EVENTO **/
    @SerializedName("idImagensEvento")
    @Expose
    private int idImagensEvento;

    @SerializedName("imagem")
    @Expose
    private String imagensEvento;

    /** CATEGORIA EVENTO **/
    @SerializedName("idCelebridade")
    @Expose
    private int idCelebridadeEvento;

    @SerializedName("nickname")
    @Expose
    private String nicknameCelEvento;

    /** CATEGORIA EVENTO **/

    @SerializedName("idEnderecoEvento")
    @Expose
    private int idEnderecoEvento;

    @SerializedName("cep")
    @Expose
    private String cepEvento;

    @SerializedName("logradouro")
    @Expose
    private String logradouroEvento;

    @SerializedName("complemento")
    @Expose
    private String complementoEvento;

    @SerializedName("bairro")
    @Expose
    private String bairroEvento;

    @SerializedName("cidade")
    @Expose
    private String cidadeEvento;

    @SerializedName("estado")
    @Expose
    private String estadoEvento;

    /** CONTA BANCARIA **/

    @SerializedName("idContaEmpresa")
    @Expose
    private int idContaEmpresaEvento;

    @SerializedName("numeroConta")
    @Expose
    private String numeroContaEvento;

    /** EMPRESA **/

    @SerializedName("idEmpresa")
    @Expose
    private int idEmpresaEvento;

    @SerializedName("nickname")
    @Expose
    private String nicknameEmpresaEvento;

    @SerializedName("imagemPerfil")
    @Expose
    private String imagemPerfilEmpresaEvento;



    public Evento() {
    }

    public Evento(int idEvento, String tituloEvento, String descricaoEvento, String capaEvento,
                  Date dataInicioEvento, Date dataFimEvento, LocalTime horaInicioEvento, LocalTime horaFimEvento,
                  int idCategoriaEvento, String categoriaEvento, int idTipoEvento, String tipoEvento,
                  int idFaixaEtariaEvento, int faixaEtariaEvento, int idAssuntoEvento, String assuntoEvento,
                  int idImagensEvento, String imagensEvento, int idCelebridadeEvento, String nicknameCelEvento,
                  int idEnderecoEvento, String cepEvento, String logradouroEvento, String complementoEvento,
                  String bairroEvento, String cidadeEvento, String estadoEvento, int idContaEmpresaEvento,
                  String numeroContaEvento, int idEmpresaEvento, String nicknameEmpresaEvento, String imagemPerfilEmpresaEvento) {
        this.idEvento = idEvento;
        this.tituloEvento = tituloEvento;
        this.descricaoEvento = descricaoEvento;
        this.capaEvento = capaEvento;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.horaInicioEvento = horaInicioEvento;
        this.horaFimEvento = horaFimEvento;
        this.idCategoriaEvento = idCategoriaEvento;
        this.categoriaEvento = categoriaEvento;
        this.idTipoEvento = idTipoEvento;
        this.tipoEvento = tipoEvento;
        this.idFaixaEtariaEvento = idFaixaEtariaEvento;
        this.faixaEtariaEvento = faixaEtariaEvento;
        this.idAssuntoEvento = idAssuntoEvento;
        this.assuntoEvento = assuntoEvento;
        this.idImagensEvento = idImagensEvento;
        this.imagensEvento = imagensEvento;
        this.idCelebridadeEvento = idCelebridadeEvento;
        this.nicknameCelEvento = nicknameCelEvento;
        this.idEnderecoEvento = idEnderecoEvento;
        this.cepEvento = cepEvento;
        this.logradouroEvento = logradouroEvento;
        this.complementoEvento = complementoEvento;
        this.bairroEvento = bairroEvento;
        this.cidadeEvento = cidadeEvento;
        this.estadoEvento = estadoEvento;
        this.idContaEmpresaEvento = idContaEmpresaEvento;
        this.numeroContaEvento = numeroContaEvento;
        this.idEmpresaEvento = idEmpresaEvento;
        this.nicknameEmpresaEvento = nicknameEmpresaEvento;
        this.imagemPerfilEmpresaEvento = imagemPerfilEmpresaEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getCapaEvento() {
        return capaEvento;
    }

    public void setCapaEvento(String capaEvento) {
        this.capaEvento = capaEvento;
    }

    public Date getDataInicioEvento() {
        return dataInicioEvento;
    }

    public void setDataInicioEvento(Date dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    public Date getDataFimEvento() {
        return dataFimEvento;
    }

    public void setDataFimEvento(Date dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    public LocalTime getHoraInicioEvento() {
        return horaInicioEvento;
    }

    public void setHoraInicioEvento(LocalTime horaInicioEvento) {
        this.horaInicioEvento = horaInicioEvento;
    }

    public LocalTime getHoraFimEvento() {
        return horaFimEvento;
    }

    public void setHoraFimEvento(LocalTime horaFimEvento) {
        this.horaFimEvento = horaFimEvento;
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

    public int getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(int idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getIdFaixaEtariaEvento() {
        return idFaixaEtariaEvento;
    }

    public void setIdFaixaEtariaEvento(int idFaixaEtariaEvento) {
        this.idFaixaEtariaEvento = idFaixaEtariaEvento;
    }

    public int getFaixaEtariaEvento() {
        return faixaEtariaEvento;
    }

    public void setFaixaEtariaEvento(int faixaEtariaEvento) {
        this.faixaEtariaEvento = faixaEtariaEvento;
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

    public int getIdImagensEvento() {
        return idImagensEvento;
    }

    public void setIdImagensEvento(int idImagensEvento) {
        this.idImagensEvento = idImagensEvento;
    }

    public String getImagensEvento() {
        return imagensEvento;
    }

    public void setImagensEvento(String imagensEvento) {
        this.imagensEvento = imagensEvento;
    }

    public int getIdCelebridadeEvento() {
        return idCelebridadeEvento;
    }

    public void setIdCelebridadeEvento(int idCelebridadeEvento) {
        this.idCelebridadeEvento = idCelebridadeEvento;
    }

    public String getNicknameCelEvento() {
        return nicknameCelEvento;
    }

    public void setNicknameCelEvento(String nicknameCelEvento) {
        this.nicknameCelEvento = nicknameCelEvento;
    }

    public int getIdEnderecoEvento() {
        return idEnderecoEvento;
    }

    public void setIdEnderecoEvento(int idEnderecoEvento) {
        this.idEnderecoEvento = idEnderecoEvento;
    }

    public String getCepEvento() {
        return cepEvento;
    }

    public void setCepEvento(String cepEvento) {
        this.cepEvento = cepEvento;
    }

    public String getLogradouroEvento() {
        return logradouroEvento;
    }

    public void setLogradouroEvento(String logradouroEvento) {
        this.logradouroEvento = logradouroEvento;
    }

    public String getComplementoEvento() {
        return complementoEvento;
    }

    public void setComplementoEvento(String complementoEvento) {
        this.complementoEvento = complementoEvento;
    }

    public String getBairroEvento() {
        return bairroEvento;
    }

    public void setBairroEvento(String bairroEvento) {
        this.bairroEvento = bairroEvento;
    }

    public String getCidadeEvento() {
        return cidadeEvento;
    }

    public void setCidadeEvento(String cidadeEvento) {
        this.cidadeEvento = cidadeEvento;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public int getIdContaEmpresaEvento() {
        return idContaEmpresaEvento;
    }

    public void setIdContaEmpresaEvento(int idContaEmpresaEvento) {
        this.idContaEmpresaEvento = idContaEmpresaEvento;
    }

    public String getNumeroContaEvento() {
        return numeroContaEvento;
    }

    public void setNumeroContaEvento(String numeroContaEvento) {
        this.numeroContaEvento = numeroContaEvento;
    }

    public int getIdEmpresaEvento() {
        return idEmpresaEvento;
    }

    public void setIdEmpresaEvento(int idEmpresaEvento) {
        this.idEmpresaEvento = idEmpresaEvento;
    }

    public String getNicknameEmpresaEvento() {
        return nicknameEmpresaEvento;
    }

    public void setNicknameEmpresaEvento(String nicknameEmpresaEvento) {
        this.nicknameEmpresaEvento = nicknameEmpresaEvento;
    }

    public String getImagemPerfilEmpresaEvento() {
        return imagemPerfilEmpresaEvento;
    }

    public void setImagemPerfilEmpresaEvento(String imagemPerfilEmpresaEvento) {
        this.imagemPerfilEmpresaEvento = imagemPerfilEmpresaEvento;
    }
}