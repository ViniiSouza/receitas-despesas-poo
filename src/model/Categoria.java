/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author crist
 */
public class Categoria {
    private String codigo;
    private String descricao;
    
    public Categoria(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public static Categoria getCategoriaPorDescricao(String descricao) {
        switch (descricao.toLowerCase()) {
            case "recebimento de salário":
                return new Categoria("RECEBIMENTO_SALARIO", "Recebimento de Salário");
            case "décimo terceiro":
                return new Categoria("DECIMO_TERCEIRO", "Décimo Terceiro");
            case "férias":
                return new Categoria("FERIAS", "Férias");
            case "outras receitas":
                return new Categoria("OUTRAS_RECEITAS", "Outras Receitas");
            // itens despesa
            case "alimentação":
                return new Categoria("ALIMENTACAO", "Alimentação");
            case "transporte":
                return new Categoria("TRANSPORTE", "Transporte");
            case "residência":
                return new Categoria("RESIDENCIA", "Residência");
            case "saúde":
                return new Categoria("SAUDE", "Saúde");
            case "educação":
                return new Categoria("EDUCACAO", "Educação");
            case "entretenimento":
                return new Categoria("ENTRETENIMENTO", "Entretenimento");
            case "outras despesas":
                return new Categoria("OUTRAS_DESPESAS", "Outras Despesas");
            default:
                throw new IllegalArgumentException("O tipo de receita fornecido é inválido!");
        }
    }
    
    public static Categoria getCategoriaPorCodigo(String codigo) {
        switch (codigo) {
            case "ALIMENTACAO":
                return new Categoria("ALIMENTACAO", "Alimentação");
            case "TRANSPORTE":
                return new Categoria("TRANSPORTE", "Transporte");
            case "RESIDENCIA":
                return new Categoria("RESIDENCIA", "Residência");
            case "SAUDE":
                return new Categoria("SAUDE", "Saúde");
            case "EDUCACAO":
                return new Categoria("EDUCACAO", "Educação");
            case "ENTRETENIMENTO":
                return new Categoria("ENTRETENIMENTO", "Entretenimento");
            case "OUTRAS_DESPESAS":
                return new Categoria("OUTRAS_DESPESAS", "Outras Despesas");
            case "RECEBIMENTO_SALARIO":
                return new Categoria("RECEBIMENTO_SALARIO", "Recebimento de Salário");
            case "DECIMO_TERCEIRO":
                return new Categoria("DECIMO_TERCEIRO", "Décimo Terceiro");
            case "FERIAS":
                return new Categoria("FERIAS", "Férias");
            case "OUTRAS_RECEITAS":
                return new Categoria("OUTRAS_RECEITAS", "Outras Receitas");
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
