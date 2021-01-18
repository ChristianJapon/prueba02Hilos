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
public class Cliente implements Runnable{
    
    CuentaBancaria cuentaBancaria;
    int cantidad;
    private String nombre;
    private int[] tOperacional;

    public Cliente(CuentaBancaria cuenta, int cantidad,String nombre, int[] tOperacional) {
        this.cuentaBancaria = cuenta;
        this.cantidad = cantidad;
        this.nombre = nombre;
	this.tOperacional = tOperacional;
    }
public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] gettOperacional() {
		return tOperacional;
	}

	public void settOperacional(int[] carroCompra) {
		this.tOperacional = carroCompra;
	}
   
    @Override
    public void run() {
        /* verifiacion de preocesos
        */
        for (int i=0; i<100; i++){
            cuentaBancaria.hacerMovimiento(cantidad);
        }
    }
    
    	

    
}
