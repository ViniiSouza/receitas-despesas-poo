/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class ControleSaldo {
    
    private static LinkedList<Transacao> transacoes;
    
    // 3) Consultar o saldo que a pessoa tem disponível até a data atual;
    /**
     * Busca transações no arquivo e realiza o cálculo do saldo com as transações até a data atual
     * @return O saldo calculado
     * @throws IllegalArgumentException caso ocorra um erro na leitura do arquivo
     */
    public static double calcularSaldoAteDataAtual() throws IllegalArgumentException {
        LocalDate dataAtual = LocalDate.now();
        transacoes = ManipuladorArquivo.lerArquivo();  
        var listaFiltrada = transacoes.stream().filter(item -> item.getData().isBefore(dataAtual) || item.getData().isEqual(dataAtual)).collect(Collectors.toList());
        LinkedList<Transacao> transacoesFiltradas = new LinkedList<>(listaFiltrada);
        double saldo = calcularSaldoTransacoes(transacoesFiltradas);
        return saldo;
    }
    
    // 4) Consultar o saldo que a pessoa terá disponível, independente do período;
    /**
     * Busca transações no arquivo e realiza o cálculo do saldo com todas as transações
     * @return O saldo calculado
     * @throws IllegalArgumentException caso ocorra um erro na leitura do arquivo
     */
    public static double calcularTotalSaldo() throws IllegalArgumentException
    {
        transacoes = ManipuladorArquivo.lerArquivo();

        double saldo = calcularSaldoTransacoes(transacoes);
        return saldo;
    }
    
    /**
     * Realiza o cálculo do saldo com base nas transações fornecidas
     * @param transacoes transações a se calcular
     * @return O saldo calculado
     * @throws IllegalArgumentException caso ocorra um erro na leitura do arquivo
     */
    private static double calcularSaldoTransacoes(LinkedList<Transacao> transacoes) throws IllegalArgumentException {
        if (transacoes == null || transacoes.isEmpty()) {
            throw new IllegalArgumentException("Lista de transações vazia ou nula.");
        }
        double saldo = 0;
        
        for (Transacao transacao : transacoes) {
            var valorTransacao = transacao.getValor();
            if (transacao.getCategoria() == CategoriaTransacao.DESPESA)
                saldo -= valorTransacao;
            else
                saldo += valorTransacao;
        }

        return saldo;
    }
    
    // 5) Listar todas as receitas lançadas;
    /**
     * Busca as transações e filtra apenas as de receita
     * @return A lista de transações do tipo receita
     * @throws IllegalArgumentException caso ocorra um erro na leitura do arquivo
     */
    public static LinkedList<Transacao> retornaTransacoesDeReceita() throws IllegalArgumentException{
        transacoes = ManipuladorArquivo.lerArquivo();
        var listaReceitas = transacoes.stream().filter(item -> item.getCategoria() == CategoriaTransacao.RECEITA).collect(Collectors.toList());
        
        return new LinkedList<>(listaReceitas);
    }
    
    // 6) Listar todas as despesas lançadas, possibilitando que o usuário filtre por tipo de despesa;
    /**
     * Busca as transações e filtra apenas as de despesa, caso seja fornecido um filtro de tipo, também é filtrado apenas pelo tipo
     * @param tipo Tipo de despesa (opcional)
     * @return A lista de transações filtrada
     * @throws IllegalArgumentException caso ocorra um erro na leitura do arquivo
     */
    public static LinkedList<Transacao> retornaTransacoesDeDespesa(TipoTransacao tipo) throws IllegalArgumentException{
        transacoes = ManipuladorArquivo.lerArquivo();
        var despesas = transacoes.stream().filter(item -> item.getCategoria() == CategoriaTransacao.DESPESA && (tipo == null || item.getTipoTransacao().getCodigo().equals(tipo.getCodigo()))).collect(Collectors.toList());
        
        return new LinkedList<>(despesas);
    }
}
