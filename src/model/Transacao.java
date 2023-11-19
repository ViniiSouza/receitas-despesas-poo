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
    private Categoria categoria;
    private LocalDate data;
    private TipoTransacao tipoTransacao;

    public Transacao(double valor, Categoria categoria, LocalDate data, TipoTransacao tipoTransacao) {
        if (!getCategoriasValidas().stream().anyMatch(item -> item.getCodigo().equals(categoria.getCodigo()))) {
            throw new IllegalArgumentException("A categoria fornecida não é válida!");
        }
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.tipoTransacao = tipoTransacao;
    }
    
    public abstract LinkedList<Categoria> getCategoriasValidas();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
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
