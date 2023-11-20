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
public class DespesaTest {

    public DespesaTest() {
    }

    @Test
    public void testGetTipoTransacoesValidasDespesas() {
        Despesa d = new Despesa(110, TipoTransacao.getTipoTransacaoPorCodigo("ALIMENTACAO"), LocalDate.MAX);
        LinkedList<TipoTransacao> tiposValidos = d.getTipoTransacoesValidas();
        
        List<String> tiposEsperados = Arrays.asList("ALIMENTACAO", "TRANSPORTE", "RESIDENCIA", "SAUDE", "EDUCACAO", "ENTRETENIMENTO", "OUTRAS");
        for (TipoTransacao tipo : tiposValidos) {
            assertTrue("Tipo inválido: " + tipo.getCodigo(), tiposEsperados.contains(tipo.getCodigo()));
        }
    }
}
