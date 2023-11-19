package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author crist
 */
public class Despesa extends Transacao{
    public Despesa(double saldo, TipoTransacao tipo, LocalDate data) {
        super(saldo, tipo, data, CategoriaTransacao.DESPESA);
    }

    @Override
    public LinkedList<TipoTransacao> getTipoTransacoesValidas() {
        return new LinkedList<>(Arrays.asList(new TipoTransacao("ALIMENTACAO", "Alimentação"),
                                                            new TipoTransacao("TRANSPORTE", "Transporte"), new TipoTransacao("RESIDENCIA", "Residência"),
                                                            new TipoTransacao("SAUDE", "Saúde"), new TipoTransacao("EDUCACAO", "Educação"),
                                                            new TipoTransacao("ENTRETENIMENTO", "Entretenimento"), new TipoTransacao("OUTRAS", "Outras")));
    }
}
