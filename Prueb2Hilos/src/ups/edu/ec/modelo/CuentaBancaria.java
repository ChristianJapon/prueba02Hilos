/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

/**
 *
 * @author japch
 */
public class CuentaBancaria {
    
    private int saldo;
    private int saldoInicial;

    public CuentaBancaria(int saldo){
        this.saldoInicial=saldo;
        this.saldo=saldo;
    }
    public synchronized void hacerMovimiento(int cantidad){
        this.saldo = this.saldo+cantidad;
    }
    public boolean esSimulacionCorrecta(){
        if (this.saldo==this.saldoInicial) return true;
        return false;
    }
    public int getSaldo(){
        return this.saldo;
    }
    
}
