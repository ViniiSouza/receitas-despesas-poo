/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author crist
 */
public class Despesa extends Transacao{
    public Despesa(double saldo, Categoria categoria, LocalDate data) {
        super(saldo, categoria, data, TipoTransacao.DESPESA);
    }

    @Override
    public LinkedList<Categoria> getCategoriasValidas() {
        return new LinkedList<>(Arrays.asList(new Categoria("ALIMENTACAO", "Alimentação"),
                                                            new Categoria("TRANSPORTE", "Transporte"), new Categoria("RESIDENCIA", "Residência"),
                                                            new Categoria("SAUDE", "Saúde"), new Categoria("EDUCACAO", "Educação"),
                                                            new Categoria("ENTRETENIMENTO", "Entretenimento"), new Categoria("OUTRAS_DESPESAS", "Outras Despesas")));
    }
}
