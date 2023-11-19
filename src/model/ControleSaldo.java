/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class ControleSaldo {
    
    // 3) Consultar o saldo que a pessoa tem disponível até a data atual;
    public static double calcularSaldoAteDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        var transacoes = ManipuladorArquivo.lerArquivo();
        var listaFiltrada = transacoes.stream().filter(item -> item.getData().isBefore(dataAtual) || item.getData().isEqual(dataAtual)).collect(Collectors.toList());
        LinkedList<Transacao> transacoesFiltradas = new LinkedList<>(listaFiltrada);
        double saldo = calcularSaldoTransacoes(transacoesFiltradas);
        return saldo;
    }
    
    // 4) Consultar o saldo que a pessoa terá disponível, independente do período;
    public static double calcularTotalSaldo()
    {
        var transacoes = ManipuladorArquivo.lerArquivo();
        double saldo = calcularSaldoTransacoes(transacoes);

        return saldo;
    }
    
    private static double calcularSaldoTransacoes(LinkedList<Transacao> transacoes) {
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
    public static LinkedList<Transacao> retornaTransacoesDeReceita(){
        var transacoes = ManipuladorArquivo.lerArquivo();
        var listaReceitas = transacoes.stream().filter(item -> item.getCategoria() == CategoriaTransacao.RECEITA).collect(Collectors.toList());
        
        return new LinkedList<>(listaReceitas);
    }
    
    // 6) Listar todas as despesas lançadas, possibilitando que o usuário filtre por tipo de despesa;
    public static LinkedList<Transacao> retornaTransacoesDeDespesa(TipoTransacao tipo){
        var transacoes = ManipuladorArquivo.lerArquivo();
        var despesas = transacoes.stream().filter(item -> item.getCategoria() == CategoriaTransacao.DESPESA && (tipo == null || item.getTipoTransacao().getCodigo().equals(tipo.getCodigo()))).collect(Collectors.toList());
        
        return new LinkedList<>(despesas);
    }
}
