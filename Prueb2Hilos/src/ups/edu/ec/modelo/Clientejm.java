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
public class Clientejm {
	private String nombre;
	private int[] tOperacional;

	public Clientejm() {
	}

	public Clientejm(String nombre, int[] tOperacional) {
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

}
