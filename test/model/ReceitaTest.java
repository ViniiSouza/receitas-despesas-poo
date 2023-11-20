/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author crist
 */
public class ReceitaTest {
    
    public ReceitaTest() {
    }

    @Test
    public void testGetTipoTransacoesValidasReceitas() {
        Receita r = new Receita(110, TipoTransacao.getTipoTransacaoPorCodigo("SALARIO"), LocalDate.MAX);
        LinkedList<TipoTransacao> tiposValidos = r.getTipoTransacoesValidas();

        List<String> tiposEsperados = Arrays.asList("SALARIO", "DECIMO_TERCEIRO", "OUTRAS", "FERIAS");
        for (TipoTransacao tipo : tiposValidos) {
            assertTrue("Tipo inválido: " + tipo.getCodigo(), tiposEsperados.contains(tipo.getCodigo()));
        }
    }
}
