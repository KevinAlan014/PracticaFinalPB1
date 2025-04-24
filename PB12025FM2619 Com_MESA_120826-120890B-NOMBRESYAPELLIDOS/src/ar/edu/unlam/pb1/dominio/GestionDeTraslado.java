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
	private Destino[] destinos; 
	private Viaje[] viajes;
	private int countDestinos = 0;
	private int countViajes = 0;

	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el
	 * correcto funcionamiento
	 * 
	 * @param nombre - Este es el nombre del sistema
	 * @param minimo - Este es el costo minimo de viaje
	 * @param nombre - Este es el costo por Km
	 */
	
	public GestionDeTraslado(String numeroDeGestion, double costoMinimo, double costoPorKm) {
		this.numeroDeGestion = numeroDeGestion;
		this.costoMinimo = costoMinimo;
		this.costoPorKm = costoPorKm;
		this.destinos = new Destino[20];
		this.viajes = new Viaje[50];
	}
	
	/***
	 * Agrega una nuevo destino
	 * 
	 * @param destino
	 * @return true si se pudo agregar o false en caso contrario Se debera buscar si
	 *         ya se ha ingresado con anterioridad y contemplar esta situacion
	 */
	public boolean agregarDestino(Destino destino) {
		if(countDestinos >= destinos.length) return false;
		
		for(int i = 0; i < countDestinos; i++) {
			if (destinos[i].getCodigo() == destino.getCodigo()) return false;
		}
		
		destinos[countDestinos++] = destino;
		
		return true;

	}

	/***
	 * Buscar un destino
	 * 
	 * @param codigo del destino buscado
	 * @return Destino (null si no existe)
	 */
	public Destino buscarDestino(int codigo) {
		for (int i = 0; i < countDestinos; i++) {
			if(destinos[i].getCodigo() == codigo) return destinos[i];
		}
		return null;
	}

	/****
	 * Agrega un nuevo viaje. Asigna el costo antes de agregarlo
	 * 
	 * @param viaje Viaje
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarViaje(Viaje viaje) {
		if (countViajes >= viajes.length) return false;

		if (buscarDestino(viaje.getDestino().getCodigo()) == null) return false;

		viajes[countViajes++] = viaje;

		return true;
	}

	/***
	 * Calcula el costo del viaje
	 * 
	 * @return double
	 */
	public double calcularCostoDelViaje(Viaje viaje) {
		double costo = Math.max(costoMinimo, viaje.getDestino().getDistancia() * costoPorKm);
		return costo * (1 - viaje.getPorcentajeDescuento() /100);
	}

	/****
	 * Calcula el importe total de todos los viajes
	 * 
	 * @return importe total
	 */
	public double calcularImporteTotal() {
		double total = 0;
		
		for(int i = 0; i < countViajes; i++) {
			total += calcularCostoDelViaje(viajes[i]);
		}
		
		return total;
	}

	/***
	 * Calcula el importe promedio de los viajes
	 * 
	 * @return importe promedio
	 */
	public double calcularImportePromedio() {
		if (countViajes == 0) return 0;
		return calcularImporteTotal() / countViajes;
	}

	/***
	 * Obtener viajes ordenados por costo ascendente
	 * 
	 * @return Viaje[]
	 */
	public Viaje[] obtenerViajesOrdenadosPorCostoAscendente() {
		Viaje copia [] = new Viaje[countViajes];
		for(int i = 0; i < countViajes; i++) {
			copia[i] = viajes[i];
		}
		
		for(int i = 0; i < copia.length; i++) {
			for(int j = 0; j < copia.length -1 - i; i++) {
				double costoActual = calcularCostoDelViaje(copia[j]);
				double costoSiguiente = calcularCostoDelViaje(copia[j + 1]);
				if(costoActual > costoSiguiente) {
					Viaje temp = copia[j];
					copia[j] = copia[j + 1];
					copia[j + 1] = temp;
				}
			}
		}
		return copia;
	}

	/****
	 * Devuelve en formato String un resumen de los viajes realizados Ordenados por
	 * costo de forma ascendente
	 * 
	 * @return Listado de las ventas realizadas
	 */
	public String toString() {
        StringBuilder sb = new StringBuilder();
        Viaje[] ordenados = obtenerViajesOrdenadosPorCostoAscendente();
        for (Viaje v : ordenados) {
            double costo = calcularCostoDelViaje(v);
            sb.append(String.format("Destino %d - %s | Pasajero: %s | Costo: %.2f\n",
                v.getDestino().getCodigo(),
                v.getDestino().getCiudad(),
                v.getNombre(),
                costo));
        }
        sb.append(String.format("Total: %.2f | Promedio: %.2f",
            calcularImporteTotal(),
            calcularImportePromedio()));
        return sb.toString();
	}

	/*
	 * Debe determinar el viaje de mayor precio y devolver todos los datos del
	 * destino y el valor del viaje hallado
	 */
	public String viajeDeMayorPrecio() {
		if (countViajes == 0) return "No hay viajes";
		Viaje max = viajes[0];
		double maxCosto = calcularCostoDelViaje(max);
        for (int i = 1; i < countViajes; i++) {
            double c = calcularCostoDelViaje(viajes[i]);
            if (c > maxCosto) {
                max = viajes[i];
                maxCosto = c;
            }
        }
        return String.format("Destino %d (%s) - Pasajero: %s | Costo: %.2f",
            max.getDestino().getCodigo(),
            max.getDestino().getCiudad(),
            max.getNombre(),
            maxCosto);
	}
	
	
	public String obtenerDestinosDisponibles() {
	    if (countDestinos == 0) {
	        return "No hay destinos registrados aún.";
	    }
	    StringBuilder sb = new StringBuilder();
	    sb.append("Destinos disponibles:\n");
	    for (int i = 0; i < countDestinos; i++) {
	        Destino d = destinos[i];
	        sb.append(String.format("  Código: %d — Ciudad: %s — Distancia: %.1f km%n",
	                                d.getCodigo(), d.getCiudad(), d.getDistancia()));
	    }
	    return sb.toString();
	}

}
