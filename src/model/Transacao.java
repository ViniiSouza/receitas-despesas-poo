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

    /**
     * Cria um objeto Transacao, fazendo a validação se o tipo transação informado é válido para a categoria da transação
     * @param valor Valor da transação
     * @param tipo Tipo da transação
     * @param data Data da transação
     * @param categoriaTransacao Categoria da transação (receita ou despesa)
     */
    public Transacao(double valor, TipoTransacao tipo, LocalDate data, CategoriaTransacao categoriaTransacao) {
        if (!getTipoTransacoesValidas().stream().anyMatch(item -> item.getCodigo().equals(tipo.getCodigo()))) {
            throw new IllegalArgumentException("O tipo de transação fornecido não é válido!");
        }
        
        if(valor <= 0){
            throw new IllegalArgumentException("O valor fornecido não é válido!");
        }
        
        this.valor = valor;
        this.tipoTransacao = tipo;
        this.data = data;
        this.categoria = categoriaTransacao;
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
