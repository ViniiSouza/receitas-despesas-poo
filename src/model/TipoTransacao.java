package model;

/**
 *
 * @author crist
 */
public class TipoTransacao {
    private String codigo;
    private String descricao;
    
    public TipoTransacao(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * Valida a descrição informada e atribui para o tipo correspondente
     * @param descricao Descrição do tipo de transação
     * @return O tipo de transação correspondente
     * @throws IllegalArgumentException caso a descrição não seja válida
     */
    public static TipoTransacao getTipoTransacaoPorDescricao(String descricao) throws IllegalArgumentException {
        switch (descricao.toLowerCase()) {
            case "recebimento de salário":
                return new TipoTransacao("SALARIO", "Recebimento de Salário");
            case "décimo terceiro":
                return new TipoTransacao("DECIMO_TERCEIRO", "Décimo Terceiro");
            case "férias":
                return new TipoTransacao("FERIAS", "Férias");
            case "outras":
                return new TipoTransacao("OUTRAS", "Outras");
            case "alimentação":
                return new TipoTransacao("ALIMENTACAO", "Alimentação");
            case "transporte":
                return new TipoTransacao("TRANSPORTE", "Transporte");
            case "residência":
                return new TipoTransacao("RESIDENCIA", "Residência");
            case "saúde":
                return new TipoTransacao("SAUDE", "Saúde");
            case "educação":
                return new TipoTransacao("EDUCACAO", "Educação");
            case "entretenimento":
                return new TipoTransacao("ENTRETENIMENTO", "Entretenimento");
            default:
                throw new IllegalArgumentException("O tipo de receita fornecido é inválido!");
        }
    }
    
    /**
     * Valida o código informado e atribui para o tipo correspondente
     * @param codigo Código do tipo de transação
     * @return O tipo de transação correspondente
     * @throws IllegalArgumentException caso o código não seja válido
     */
    public static TipoTransacao getTipoTransacaoPorCodigo(String codigo) throws IllegalArgumentException {
        switch (codigo) {
            case "ALIMENTACAO":
                return new TipoTransacao("ALIMENTACAO", "Alimentação");
            case "TRANSPORTE":
                return new TipoTransacao("TRANSPORTE", "Transporte");
            case "RESIDENCIA":
                return new TipoTransacao("RESIDENCIA", "Residência");
            case "SAUDE":
                return new TipoTransacao("SAUDE", "Saúde");
            case "EDUCACAO":
                return new TipoTransacao("EDUCACAO", "Educação");
            case "ENTRETENIMENTO":
                return new TipoTransacao("ENTRETENIMENTO", "Entretenimento");
            case "SALARIO":
                return new TipoTransacao("SALARIO", "Recebimento de Salário");
            case "DECIMO_TERCEIRO":
                return new TipoTransacao("DECIMO_TERCEIRO", "Décimo Terceiro");
            case "FERIAS":
                return new TipoTransacao("FERIAS", "Férias");
            case "OUTRAS":
                return new TipoTransacao("OUTRAS", "Outras");
            default:
                throw new IllegalArgumentException("O tipo de receita fornecido é inválido!");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
