package ar.edu.unlam.pb1.dominio;

public class Viaje {

	/*
	 * Definir todos los atributos, setters y getters necesarios ademas de los
	 * emetodos que considere para que la aplicacion funcione de manera correcta
	 */
	
	Destino destino;
	String nombre;
	double porcentajeDescuento;
	int id;

	/****
	 * Constructor de la clase
	 * 
	 * @param destino
	 * @param nombre                del pasajero
	 * @param porcentajeDeDescuento (valor entre 0 y 100)
	 */
	
	public Viaje(Destino destino, String nombre, double porcentajeDescuento, int id) {
		this.destino = destino;
		this.nombre = nombre;
		this.porcentajeDescuento = porcentajeDescuento;
		this.id = id;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
			
			this.porcentajeDescuento = 0;
			
		} else this.porcentajeDescuento = porcentajeDescuento;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
