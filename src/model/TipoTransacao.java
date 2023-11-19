/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public static TipoTransacao getTipoTransacaoPorDescricao(String descricao) {
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
    
    public static TipoTransacao getTipoTransacaoPorCodigo(String codigo) {
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
