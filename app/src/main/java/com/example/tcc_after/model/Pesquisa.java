package com.example.tcc_after.model;

import com.example.tcc_after.model.empresa.ContaBancaria;
import com.example.tcc_after.model.empresa.Empresa;
import com.example.tcc_after.model.evento.Categoria;
import com.example.tcc_after.model.evento.Comentario;
import com.example.tcc_after.model.evento.EnderecoEvento;
import com.example.tcc_after.model.evento.FaixaEtaria;
import com.example.tcc_after.model.evento.Lote;
import com.example.tcc_after.model.evento.TipoEvento;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Pesquisa {

    @SerializedName("titulo")
    @Expose
    private String tituloPesquisa;

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
    private String horaInicioEvento;

    @SerializedName("horaFim")
    @Expose
    private String horaFimEvento;


    /** CATEGORIA **/

    @SerializedName("tblCategoriumIdCategoria")
    @Expose
    private int idCategoriaEvento;

    @SerializedName("nomeCategoria")
    @Expose
    private String categoriaEvento;

    @SerializedName("tblCategorium")
    @Expose
    private Categoria categoria;



    /** TIPO EVENTO **/

    @SerializedName("tblTipoEventoIdTipoEvento")
    @Expose
    private int idTipoEvento;

    @SerializedName("tipo")
    @Expose
    private String tipo;

    @SerializedName("tblTipoEvento")
    @Expose
    private TipoEvento tipoEvento;

    /** FAIXA ETARIA **/

    @SerializedName("tblFaixaEtariumIdFaixaEtaria")
    @Expose
    private int idFaixaEtariaEvento;

    @SerializedName("tblFaixaEtarium")
    @Expose
    private FaixaEtaria faixaEtaria;

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


    /** CAPA EVENTO **/
    @SerializedName("idImagensEvento")
    @Expose
    private int idImagensEvento;

    @SerializedName("imagem")
    @Expose
    private String imagensEvento;

    /** CELEBRIDADE EVENTO **/
    @SerializedName("idCelebridade")
    @Expose
    private int idCelebridadeEvento;


//    @SerializedName("nickname")
//    @Expose
//    private String nicknameCelEvento;

    /** ENDERECO EVENTO **/

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

    @SerializedName("numero")
    @Expose
    private String numeroEvento;

    @SerializedName("tblEnderecoEventos")
    @Expose
    private ArrayList<EnderecoEvento> enderecoEvento;


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

    @SerializedName("tblEmpresa")
    @Expose
    private Empresa empresa;



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

    public String getHoraInicioEvento() {
        return horaInicioEvento;
    }

    public void setHoraInicioEvento(String horaInicioEvento) {
        this.horaInicioEvento = horaInicioEvento;
    }

    public String getHoraFimEvento() {
        return horaFimEvento;
    }

    public void setHoraFimEvento(String horaFimEvento) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getIdFaixaEtariaEvento() {
        return idFaixaEtariaEvento;
    }

    public void setIdFaixaEtariaEvento(int idFaixaEtariaEvento) {
        this.idFaixaEtariaEvento = idFaixaEtariaEvento;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
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

    public String getNumeroEvento() {
        return numeroEvento;
    }

    public void setNumeroEvento(String numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    public ArrayList<EnderecoEvento> getEnderecoEvento() {
        return enderecoEvento;
    }

    public void setEnderecoEvento(ArrayList<EnderecoEvento> enderecoEvento) {
        this.enderecoEvento = enderecoEvento;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTituloPesquisa() {
        return tituloPesquisa;
    }

    public void setTituloPesquisa(String tituloPesquisa) {
        this.tituloPesquisa = tituloPesquisa;
    }
}
