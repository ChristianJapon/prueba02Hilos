/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.Random;

/**
 *
 * @author japch
 */
public class Recepcion implements  Runnable{
        private Cliente cliente;
        private CuentaBancaria cuentaBancaria;
	private long initialTime;
public Recepcion(Cliente cliente, long initialTime,CuentaBancaria cuentaBancaria) {
		this.cliente = cliente;
		this.initialTime = initialTime;
                this.cuentaBancaria= cuentaBancaria;
	}
	@Override
	public void run() {
		try {
			tiempofilacaja();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\"La cajera " + Thread.currentThread().getName() 
				+ "\" COMIENZA recibe el dinero del " + this.cliente.getNombre()+" con valor de: "+cliente.cantidad);

		for (int i = 0; i < this.cliente.gettOperacional().length; i++) {
			// Se procesa el pedido en X segundos
			this.esperarXsegundos(cliente.gettOperacional()[i]);
			System.out.println("Procesando la accion" + (i + 1) + " del " + this.cliente.getNombre() 
				+ " en un tiempo de: " + cliente.gettOperacional()[i] + "seg");
		}
                System.out.println("\"La cajera " + Thread.currentThread().getName() + "\" HA TERMINADO DE PROCESAR " 
				+ this.cliente.getNombre());}/* + " EN EL TIEMPO: "
				+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg"+" valor saldo: "+cuentaBancaria.getSaldo() );*/
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	public void tiempofilacaja() throws InterruptedException {
		  Random r = new Random();
		    int Low = 2;
		    int High = 5;
		    int Result = r.nextInt(High-Low) + Low;
		        System.out.println("Sale de la cola: "+this.cliente.getNombre());
		        Thread.sleep(Result*100);
		        System.out.println("Llega al mostrador "+this.cliente.getNombre()+" Luego de "+Result+" segundos");}
	
	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
}
