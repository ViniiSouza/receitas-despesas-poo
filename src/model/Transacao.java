/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author crist
 */
public abstract class Transacao {
    private double valor;
    private TipoTransacao tipoTransacao;
    private LocalDate data;
    private CategoriaTransacao categoria;

    public Transacao(double valor, TipoTransacao categoria, LocalDate data, CategoriaTransacao tipoTransacao) {
        if (!getTipoTransacoesValidas().stream().anyMatch(item -> item.getCodigo().equals(categoria.getCodigo()))) {
            throw new IllegalArgumentException("O tipo de transação fornecido não é válido!");
        }
        this.valor = valor;
        this.tipoTransacao = categoria;
        this.data = data;
        this.categoria = tipoTransacao;
    }
    
    public abstract LinkedList<TipoTransacao> getTipoTransacoesValidas();

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getData() {
        return data;
    }

    public CategoriaTransacao getCategoria() {
        return categoria;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public double getValor() {
        return valor;
    }

    protected void setValor(double valor) {
        this.valor = valor;
    }

}
