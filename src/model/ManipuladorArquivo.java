package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @author Vinícius
 */
public class ManipuladorArquivo {
    private static final String CAMINHO_ARQUIVO = "C:/Windows/Temp/ReceitaDespesaArquivo.csv";
    private static final String COLUNAS = "Categoria;Tipo;Data;Valor";
    private static LinkedList<Transacao> transacoes;

    private static void escreverArquivo(String conteudo) throws IllegalArgumentException {
        try(BufferedWriter writer  = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            writer.write(conteudo);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao escrever no arquivo");
        }
    }
    
    // 1) Incluir receitas. Uma receita deve ser categorizável e deve ser possível informar a data em que a receita ocorreu (ou vai ocorrer);
    public static void incluirTransacao(Transacao transacao) throws IllegalArgumentException {
        transacoes = lerArquivo();
        transacoes.add(transacao);
        String conteudoArquivo = COLUNAS;
        for (var item : transacoes) {
            conteudoArquivo += String.format("\n%s;%s;%s;%s",
                    item.getCategoria().toString(),
                    item.getTipoTransacao().getCodigo(),
                    item.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    Double.toString(item.getValor()));
        }
        
        escreverArquivo(conteudoArquivo);
    }
    
    public static LinkedList<Transacao> lerArquivo() throws IllegalArgumentException {
        
        LinkedList<Transacao> transacoes = new LinkedList<>();
        
        if (!new File(CAMINHO_ARQUIVO).exists()) {
            return(transacoes);
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            var cabecalho = true;
            while ((linha = reader.readLine()) != null) {
                if (cabecalho) {
                    cabecalho = false;
                    continue;
                }
                var item = linha.split(";");
                var categoria = CategoriaTransacao.valueOf(item[0]);
                var tipo = TipoTransacao.getTipoTransacaoPorCodigo(item[1]);
                LocalDate data = LocalDate.parse(item[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                var saldo = Double.parseDouble(item[3]);
                if (categoria == CategoriaTransacao.DESPESA) {
                    var despesa = new Despesa(saldo, tipo, data);
                    transacoes.add(despesa);
                } else {
                    var receita = new Receita(saldo, tipo, data);
                    transacoes.add(receita);
                }
            }
        } catch (IOException e){
            throw new IllegalArgumentException("Erro de leitura de arquivo!");
        }
        
        return transacoes;
    }
}
