/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author crist
 */
public class Receita extends Transacao{
    private TipoReceita tipoReceita;

    public Receita(TipoReceita tipoReceita, double saldo, Categoria categoria, LocalDate data) {
        super(saldo, categoria, data);
        this.tipoReceita = tipoReceita;
    }
   
    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
    
}
