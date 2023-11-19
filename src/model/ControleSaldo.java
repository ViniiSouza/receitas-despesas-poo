/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class ControleSaldo {
    
    //Item 3 - Calcular o saldo total com filtro por data (Rever se isso funciona, usei localDate mas pode usar Date)
    public static double calcularSaldoAteDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        var transacoes = ManipuladorArquivo.lerArquivo();
        var listaFiltrada = transacoes.stream().filter(item -> item.getData().isBefore(dataAtual) || item.getData().isEqual(dataAtual)).collect(Collectors.toList());
        LinkedList<Transacao> transacoesFiltradas = new LinkedList<>(listaFiltrada);
        double saldo = calcularSaldoTransacoes(transacoesFiltradas);
        return saldo;
    }
    
    //Item 4 - Calcular o salto total independente da data
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
    
    
    // Lista todas as receitas - Requisito numero 5
    public static LinkedList<Transacao> retornaTransacoesDeReceita(){
        var transacoes = ManipuladorArquivo.lerArquivo();
        var listaReceitas = transacoes.stream().filter(item -> item.getCategoria() == CategoriaTransacao.RECEITA).collect(Collectors.toList());
        
        return new LinkedList<>(listaReceitas);
    }
    
    // Lista todas as receitas - Requisito numero 6
    /*public ArrayList<Transacao> retornaTransacoesDeDespesa(){
        ArrayList<Transacao> tDespesa = new ArrayList<>();
        
        for(Transacao t : lista){
            if(t instanceof Despesa){
                tDespesa.add(t);
            }
        }
        
        return tDespesa;
    }
    
    public ArrayList<Despesa> retornaTransacoesDeDespesaFiltrada(TipoDespesa tipoFiltrado) {
        ArrayList<Despesa> tDespesaFiltrada = new ArrayList<>();

        for (Transacao t : lista) {
            if (t instanceof Despesa) {
                Despesa despesa = (Despesa) t;
                if (despesa.getTipoDespesa() == tipoFiltrado) {
                    tDespesaFiltrada.add(despesa);
                }
            }
        }

        return tDespesaFiltrada;
    }*/
    
    // Lista todas as receitas - Requisito numero 6, no caso na implementação temos que ver se o campo nao for utilizado filtro tem q informal null
//    public ArrayList<Despesa> retornaTransacoesDeDespesaFiltrada(TipoDespesa tipoFiltrado) {
//        ArrayList<Despesa> tDespesaFiltrada = new ArrayList<>();
//
//        for (Transacao t : lista) {
//         if (t instanceof Despesa) {
//              Despesa despesa = (Despesa) t;
//              if (tipoFiltrado == null || despesa.getTipoDespesa() == tipoFiltrado) {
//                   tDespesaFiltrada.add(despesa);
//               }
//            }
//        }
//
//        return tDespesaFiltrada;
//    } 
    
    //Requisito 7 - Lista todos as transações ordenadas por data e atualiza o saldo.
//    public ArrayList<Transacao> listaTodosOsLancamentosOrdenadosPorData(){
//        ArrayList<Transacao> transacoes = getItens();
//        
//        transacoes.sort((t1, t2) -> t1.getData().compareTo(t2.getData()));
//        calcularSaldoAteDataAtual();
//        
//        return transacoes;
//    }
    
    
}
