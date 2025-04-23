package ar.edu.unlam.pb1.dominio;

public class GestionDeTraslado {

	/***
	 * Se deben agregar todos los atributos, setters y getters que se requieran para
	 * desarrollar la aplicacion.
	 */
	// La cantidad de destinos totales esta predeterminado en 20 y para los viajes
	// sera de 50.
	private String numeroDeGestion;
	private double costoMinimo;
	private double costoPorKm;

	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el
	 * correcto funcionamiento
	 * 
	 * @param nombre - Este es el nombre del sistema
	 * @param minimo - Este es el costo minimo de viaje
	 * @param nombre - Este es el costo por Km
	 */
	public GestionDeTraslado(String numeroDeGestion, double costoMinimo, double costoPorKm) {
	}

	/***
	 * Agrega una nuevo destino
	 * 
	 * @param destino
	 * @return true si se pudo agregar o false en caso contrario Se debera buscar si
	 *         ya se ha ingresado con anterioridad y contemplar esta situacion
	 */
	public boolean agregarDestino(Destino destino) {

		return false;

	}

	/***
	 * Buscar un destino
	 * 
	 * @param codigo del destino buscado
	 * @return Destino (null si no existe)
	 */
	public Destino buscarDestino(int codigo) {

		return null;
	}

	/****
	 * Agrega un nuevo viaje. Asigna el costo antes de agregarlo
	 * 
	 * @param viaje Viaje
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarViaje(Viaje viaje) {

		return false;
	}

	/***
	 * Calcula el costo del viaje
	 * 
	 * @return double
	 */
	public double calcularCostoDelViaje(Viaje viaje) {
		return 0;
	}

	/****
	 * Calcula el importe total de todos los viajes
	 * 
	 * @return importe total
	 */
	public double calcularImporteTotal() {
		return 0;
	}

	/***
	 * Calcula el importe promedio de los viajes
	 * 
	 * @return importe promedio
	 */
	public double calcularImportePromedio() {

		return 0;
	}

	/***
	 * Obtener viajes ordenados por costo ascendente
	 * 
	 * @return Viaje[]
	 */
	public Viaje[] obtenerViajesOrdenadosPorCostoAscendente() {

		return null;
	}

	/****
	 * Devuelve en formato String un resumen de los viajes realizados Ordenados por
	 * costo de forma ascendente
	 * 
	 * @return Listado de las ventas realizadas
	 */
	public String toString() {
		return "";
	}

	/*
	 * Debe determinar el viaje de mayor precio y devolver todos los datos del
	 * destino y el valor del viaje hallado
	 */
	public String viajeDeMayorPrecio() {

		return "";
	}
}
