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
public class Receita extends Transacao{
    public Receita(double saldo, Categoria categoria, LocalDate data) {
        super(saldo, categoria, data, TipoTransacao.RECEITA);
    }

    @Override
    public LinkedList<Categoria> getCategoriasValidas() {
        return new LinkedList<>(Arrays.asList(new Categoria("RECEBIMENTO_SALARIO", "Recebimento de Salário"), new Categoria("DECIMO_TERCEIRO", "Décimo Terceiro"),
                                                new Categoria("FERIAS", "Férias"), new Categoria("OUTRAS_RECEITAS", "Outras Receitas")));
    }
}
