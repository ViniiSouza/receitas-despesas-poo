/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.time.LocalDate;
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
    public void testGetTipoTransacoesValidasDesepsas() {
        Despesa d = new Despesa(110, TipoTransacao.getTipoTransacaoPorCodigo("ALIMENTACAO"), LocalDate.MAX);
        int quantidadeTransacoesValidas = d.getTipoTransacoesValidas().size();
        assertEquals(7, quantidadeTransacoesValidas, 0.0001);
    }
}
