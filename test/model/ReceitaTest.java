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
public class ReceitaTest {
    
    public ReceitaTest() {
    }

    @Test
    public void testGetTipoTransacoesValidasReceitas() {
        Receita r = new Receita(110, TipoTransacao.getTipoTransacaoPorCodigo("SALARIO"), LocalDate.MAX);
        int quantidadeTransacoesValidas = r.getTipoTransacoesValidas().size();
        assertEquals(4, quantidadeTransacoesValidas, 0.0001);
    }
}
