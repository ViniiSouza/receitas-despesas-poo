/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author crist
 */
public class ControleSaldoTest {

    public ControleSaldoTest() {
    }

    @Before
    public void criaArquivo() {
        ManipuladorArquivo.setCAMINHO_ARQUIVO("./teste.csv");

        ManipuladorArquivo.escreverArquivo("Categoria;Tipo;Data;Valor\n"
                + "RECEITA;SALARIO;01/10/2023;2500.0\n"
                + "DESPESA;ALIMENTACAO;05/10/2023;28.0\n"
                + "DESPESA;RESIDENCIA;10/10/2023;750.0\n"
                + "DESPESA;ENTRETENIMENTO;14/10/2023;75.0\n"
                + "DESPESA;TRANSPORTE;25/10/2023;120.0\n"
                + "RECEITA;OUTRAS;01/11/2023;250.0\n"
                + "RECEITA;DECIMO_TERCEIRO;18/11/2023;1200.0\n"
                + "RECEITA;DECIMO_TERCEIRO;18/11/2523;1000.0");

    }

    @Test
    public void testCalcularSaldoAteDataAtual() {
        ManipuladorArquivo.setCAMINHO_ARQUIVO("./teste.csv");
        double saldo = ControleSaldo.calcularSaldoAteDataAtual();
        assertEquals(2977, saldo, 0.0001);
    }

    @Test
    public void testCalcularSaldoIndependenteDaData() {
        double saldo = ControleSaldo.calcularTotalSaldo();
        assertEquals(3977, saldo, 0.0001);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testCalcularSaldoTransacoesComListaVazia() {
        ManipuladorArquivo.setCAMINHO_ARQUIVO("./testeArquivoVazio.csv");
        ControleSaldo.calcularTotalSaldo();
    }

    @Test
    public void testRetornaTransacoesDeReceita() {
        int quantidadeDeReceitas = ControleSaldo.retornaTransacoesDeReceita().size();
        assertEquals(4, quantidadeDeReceitas, 0.0001);
    }

    @Test
    public void testRetornaTransacoesDeDespesa() {
        int quantidadeDeDespesas = ControleSaldo.retornaTransacoesDeReceita().size();
        assertEquals(4, quantidadeDeDespesas, 0.0001);
    }
}
