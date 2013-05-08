package model;

import java.util.Date;

public class ModelNotas {
    
    private int cod;
    private String numNota;
    private String descricao;
    private Date dataLancamento;
    private Date dataEmissao;
    private Date dataVencimento;
    private float valor;
    private int totalParcelas;
    private int parcelaCorrente;
    private int statusPagamento;

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the numNota
     */
    public String getNumNota() {
        return numNota;
    }

    /**
     * @param numNota the numNota to set
     */
    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dataLancamento
     */
    public Date getDataLancamento() {
        return dataLancamento;
    }

    /**
     * @param dataLancamento the dataLancamento to set
     */
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the totalParcelas
     */
    public int getTotalParcelas() {
        return totalParcelas;
    }

    /**
     * @param totalParcelas the totalParcelas to set
     */
    public void setTotalParcelas(int totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    /**
     * @return the parcelaCorrente
     */
    public int getParcelaCorrente() {
        return parcelaCorrente;
    }

    /**
     * @param parcelaCorrente the parcelaCorrente to set
     */
    public void setParcelaCorrente(int parcelaCorrente) {
        this.parcelaCorrente = parcelaCorrente;
    }

    /**
     * @return the statusPagamento
     */
    public int getStatusPagamento() {
        return statusPagamento;
    }

    /**
     * @param statusPagamento the statusPagamento to set
     */
    public void setStatusPagamento(int statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    
}
