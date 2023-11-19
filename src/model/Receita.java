package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author crist
 */
public class Receita extends Transacao{
    public Receita(double saldo, TipoTransacao tipo, LocalDate data) {
        super(saldo, tipo, data, CategoriaTransacao.RECEITA);
    }

    @Override
    public LinkedList<TipoTransacao> getTipoTransacoesValidas() {
        return new LinkedList<>(Arrays.asList(new TipoTransacao("SALARIO", "Recebimento de Salário"), new TipoTransacao("DECIMO_TERCEIRO", "Décimo Terceiro"),
                                                new TipoTransacao("FERIAS", "Férias"), new TipoTransacao("OUTRAS", "Outras")));
    }
}
