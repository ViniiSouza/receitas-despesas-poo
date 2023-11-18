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
public class Despesa extends Transacao{
    private TipoDespesa tipoDespesa;

    public Despesa(TipoDespesa tipoDespesa, double saldo, Categoria categoria, LocalDate data) {
        super(saldo, categoria, data);
        this.tipoDespesa = tipoDespesa;
    }

    

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    
}
