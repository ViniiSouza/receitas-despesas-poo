/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author crist
 */
public class ManipuladorArquivoTest {

    public ManipuladorArquivoTest() {
    }

    @Before
    public void criaArquivo() {
        ManipuladorArquivo.setCAMINHO_ARQUIVO("./teste.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEscreverArquivoInexistente() {
        ManipuladorArquivo.setCAMINHO_ARQUIVO("x:/teste.csv");
        ManipuladorArquivo.escreverArquivo("Categoria;Tipo;Data;Valor\n"
                + "RECEITA;DECIMO_TERCEIRO;18/11/2023;1200.0\n"
                + "RECEITA;DECIMO_TERCEIRO;18/11/2523;1000.0");
    }

    @Test
    public void testEscreverArquivoCaminhoExistente() {
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
    public void testIncluirReceita() {
        ManipuladorArquivo.incluirTransacao(new Receita(10, TipoTransacao.getTipoTransacaoPorCodigo("FERIAS"), LocalDate.MAX));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncluirReceitaComTipoTransacaoInvalida() {
        ManipuladorArquivo.incluirTransacao(new Receita(110, TipoTransacao.getTipoTransacaoPorCodigo("dasdsa"), LocalDate.MAX));
    }

    @Test
    public void testIncluirDespesa() {
        ManipuladorArquivo.incluirTransacao(new Despesa(123, TipoTransacao.getTipoTransacaoPorCodigo("ENTRETENIMENTO"), LocalDate.MAX));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncluirDespesaComTipoTransacaoInvalida() {
        ManipuladorArquivo.incluirTransacao(new Despesa(312, TipoTransacao.getTipoTransacaoPorCodigo("SALARIO"), LocalDate.MAX));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncluirTransacaoComValorNegativo() {
        ManipuladorArquivo.incluirTransacao(new Despesa(-10, TipoTransacao.getTipoTransacaoPorCodigo("SALARIO"), LocalDate.MAX));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncluirTransacaoComValorZerado() {
        ManipuladorArquivo.incluirTransacao(new Despesa(0, TipoTransacao.getTipoTransacaoPorCodigo("SALARIO"), LocalDate.MAX));
    }

    @Test
    public void testLerCaminhoComListaVazia() {
        ManipuladorArquivo.setCAMINHO_ARQUIVO("x:/teste.csv");
        int quantidadeTransacoes = ManipuladorArquivo.lerArquivo().size();
        assertEquals(0, quantidadeTransacoes, 0.0001);
    }
}
