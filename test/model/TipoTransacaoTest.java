/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author crist
 */
public class TipoTransacaoTest {
    
    public TipoTransacaoTest() {
    }

    @Test (expected=IllegalArgumentException.class)
    public void testRetornoTransacaoPorCodigoInexistente() {
        TipoTransacao.getTipoTransacaoPorCodigo("teste");
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void testRetornoTransacaoPorDescricaoInexistente() {
        TipoTransacao.getTipoTransacaoPorDescricao("Aleatorio");
    }
    
    @Test 
    public void testRetornoTransacaoPorCodigo() {
        String codigo = "ALIMENTACAO";
        TipoTransacao tipo = TipoTransacao.getTipoTransacaoPorCodigo(codigo);
        
        assertNotNull(tipo);
        assertEquals(codigo, tipo.getCodigo());
    }
    
    @Test 
    public void testRetornoTransacaoPorDescricao() {
        String codigo = "OUTRAS";
        TipoTransacao tipo = TipoTransacao.getTipoTransacaoPorDescricao(codigo);
        
        assertNotNull(tipo);
        assertEquals(codigo, tipo.getCodigo());
    }
}
