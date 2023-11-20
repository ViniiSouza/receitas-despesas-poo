/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

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
        TipoTransacao.getTipoTransacaoPorCodigo("ALIMENTACAO");
        
    }
    
    @Test 
    public void testRetornoTransacaoPorDescricao() {
        TipoTransacao.getTipoTransacaoPorDescricao("outras");
    }
}
