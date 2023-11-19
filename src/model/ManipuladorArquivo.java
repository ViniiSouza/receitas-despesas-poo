/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private static final String COLUNAS = "TIPO,VALOR,CATEGORIA,DATA";
    
    
    private static void escreverArquivo(String conteudo) {
        try(BufferedWriter writer  = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            writer.write(conteudo);
        } catch (IOException e) {
            // tratar exceção
        }
    }
    
    public static void incluirTransacao(Transacao transacao) {
        var lista = lerArquivo();
        lista.add(transacao);
        String conteudoArquivo = COLUNAS;
        for (var item : lista) {
            conteudoArquivo += String.format("\n%s,%s,%s,%s",
                    item.getTipoTransacao().toString(),
                    Double.toString(item.getValor()),
                    item.getCategoria().getCodigo(),
                    item.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        
        escreverArquivo(conteudoArquivo);
    }
    
    public static LinkedList<Transacao> lerArquivo() {
        LinkedList<Transacao> lista = new LinkedList<>();
        
        if (!new File(CAMINHO_ARQUIVO).exists()) {
            return lista;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            var cabecalho = true;
            while ((linha = reader.readLine()) != null) {
                if (cabecalho) {
                    cabecalho = false;
                    continue;
                }
                var item = linha.split(",");
                var tipo = TipoTransacao.valueOf(item[0]);
                var saldo = Double.parseDouble(item[1]);
                var categoria = Categoria.getCategoriaPorCodigo(item[2]);
                LocalDate data = LocalDate.parse(item[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (tipo == TipoTransacao.DESPESA) {
                    var despesa = new Despesa(saldo, categoria, data);
                    lista.add(despesa);
                } else {
                    var receita = new Receita(saldo, categoria, data);
                    lista.add(receita);
                }
            }
        } catch (IOException e) {
            // tratar exceção
        }
        
        return lista;
    }
}
