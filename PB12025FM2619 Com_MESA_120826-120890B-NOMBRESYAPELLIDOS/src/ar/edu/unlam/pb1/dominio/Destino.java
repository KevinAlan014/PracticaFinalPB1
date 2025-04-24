package ar.edu.unlam.pb1.dominio;

public class Destino {

	/*
	 * Definir todos los atributos, setters y getters necesarios ademas de los
	 * emetodos que considere para que la aplicacion funcione de manera correcta
	 */
	/***
	 * Constructor de la clase
	 * 
	 * @param codigo
	 * @param ciudad
	 * @param distancia
	 */
	private int codigo;
	private String ciudad;
	private double distancia;
	
	public Destino() {
	
	}
	

	public Destino(int codigo, String ciudad, double distancia) {
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.distancia = distancia;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	
}
