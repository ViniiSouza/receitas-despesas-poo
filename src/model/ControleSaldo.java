/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class ControleSaldo {
    private ArrayList<Transacao> lista = new ArrayList<>();

    //Item 1 e 2, aqui você inclui a transação que vai ser ou uma receita ou uma despesa
    public void incluirTransacao(Transacao transacoes)
    {
        lista.add(transacoes);
    }
    
    //Item 3 - Calcular o saldo total com filtro por data (Rever se isso funciona, usei localDate mas pode usar Date)
    public static double calcularSaldoAteDataAtual() {
        double saldo = 0;
        LocalDate dataAtual = LocalDate.now();
        var transacoes = ManipuladorArquivo.lerArquivo();

        for (Transacao transacao : transacoes) {
            // Verifica se a transação ocorreu até a data de hoje
            if (transacao.getData().isBefore(dataAtual)) {
                var valorTransacao = transacao.getValor();
                if (transacao.getTipoTransacao() == TipoTransacao.DESPESA)
                    saldo -= valorTransacao;
                else
                    saldo += valorTransacao;
            }
        }

        return saldo;
    }
    
    //Item 4 - Calcular o salto total independente da data
    public double calcularTotalSaldo()
    {
        double valorTotal = 0;
        
        for(Transacao transacao : lista)
        {
            valorTotal += transacao.getValor();
        }
        
        return valorTotal;
    }
    
    
    // Lista todas as receitas - Requisito numero 5
    public ArrayList<Transacao> retornaTransacoesDeReceita(){
        ArrayList<Transacao> tReceita = new ArrayList<>();
        
        for(Transacao t : lista){
            if(t instanceof Receita){
                tReceita.add(t);
            }
        }
        return tReceita;
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
    public ArrayList<Transacao> listaTodosOsLancamentosOrdenadosPorData(){
        ArrayList<Transacao> transacoes = getItens();
        
        transacoes.sort((t1, t2) -> t1.getData().compareTo(t2.getData()));
        calcularSaldoAteDataAtual();
        
        return transacoes;
    }
    
    //retorna todas as receitas
    public ArrayList<Transacao> getItens() {
        return lista;
    }
    
    
}
