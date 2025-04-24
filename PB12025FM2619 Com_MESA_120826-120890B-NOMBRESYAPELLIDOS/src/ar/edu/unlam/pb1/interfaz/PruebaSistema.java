package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Destino;
import ar.edu.unlam.pb1.dominio.GestionDeTraslado;
import ar.edu.unlam.pb1.dominio.Viaje;
import ar.edu.unlam.pb1.interfaz.enums.MenuPrincipal;

public class PruebaSistema {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String args[]) {

		MenuPrincipal opcion = null;
		double costoMinimo;
		double costoPorKm;
		String numeroGestion;
		boolean numeroGestionValido = false;

		/*
		 * Para iniciar el sistema, el usuario debe ingresar un número de gestión. Este
		 * número debe comenzar con el carácter especial #. El sistema deberá verificar
		 * que el número ingresado cumpla con esta condición. En caso contrario, se
		 * solicitará nuevamente hasta que el usuario ingrese un número de gestión
		 * válido.
		 * 
		 */

		do {
			mostrarMensaje("Ingrese numero de gestion:");
			numeroGestion = ingresarString();
			if(numeroGestion.startsWith("#")){
				numeroGestionValido = true;
			} else mostrarMensaje("Numero de gestion invalido. Debe comenzar con #");
		} while(!numeroGestionValido);
		
		
		mostrarMensaje("Ingrese el costo mínimo");
		costoMinimo = ingresarDecimal();

		mostrarMensaje("Ingrese el costo x km");
		costoPorKm = ingresarDecimal();
		
		GestionDeTraslado gestion = new GestionDeTraslado(numeroGestion, costoMinimo, costoPorKm);

		do {
			mostrarMenuPrincipal();
			opcion = ingresarOpcionDelMenuPrincipalValidada();
			switch (opcion) {
				case AGREGAR_DESTINO:

					/*
					 * Se debe agregar un nuevo destino para el traslado. Si el destino se agrega
					 * correctamente, el sistema deberá mostrar el mensaje:
					 * "Destino agregado correctamente". En caso de error, se deberá mostrar el
					 * mensaje: "No se pudo agregar el destino".
					 */
					if(agregarNuevoDestino(gestion)) {
						mostrarMensaje("Destino agregado correctamente.");
					} else mostrarMensaje("No se pudo agregar el destino.");

					break;
				case AGREGAR_VIAJE:
					/*
					 * Se debe agregar un viaje según el traslado determinado. Si la operación se
					 * realiza con éxito, el sistema deberá mostrar el mensaje:
					 * "El viaje se agregó correctamente". En caso de error, se deberá mostrar el
					 * mensaje: "No se pudo agregar el viaje".
					 */
					if(agregarViaje(gestion)) {
						mostrarMensaje("El viaje se agregó correctamente");
					} else mostrarMensaje("No se pudo agregar el viaje");
					break;
				case VER_RESUMEN:
					/*
					 * Una vez asignados los viajes a sus respectivos destinos, se deberá generar y
					 * mostrar un resumen de la información que se podra consultar en todo momento
					 * para vidualizar la informacion actual.
					 */
					verResumen(gestion);
					break;
				case SALIR:
					mostrarMensaje("Finalizando programa....");
					break;
				default:
					mostrarMensaje("Opción inválida");
			}
			// Definir la cndicion para que el programa funcione correctamente
		} while (opcion != MenuPrincipal.SALIR);
		mostrarMensaje("Programa terminado");
		teclado.close();

	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static String ingresarString() {
		return teclado.next();
	}

	private static double ingresarDecimal() {
		return teclado.nextDouble();
	}

	private static void mostrarMenuPrincipal() {
		mostrarMensaje("\n\t*****Bienvenido De viajes a destino *****\n");
		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			mostrarMensaje((i + 1) + ". " + MenuPrincipal.values()[i].getDescripcion());
		}
	}

	private static MenuPrincipal ingresarOpcionDelMenuPrincipalValidada() {
		/*
		 * El usuario debe ingresar una opción y el sistema deberá verificar que esté
		 * dentro del rango permitido. Si la opción ingresada no es válida, se
		 * solicitará nuevamente hasta que se ingrese una opción correcta.
		 */
		int opcionUser;
		MenuPrincipal[] opciones = MenuPrincipal.values();
		int opcionesMenu = opciones.length;
		
		do {
			mostrarMensaje("Ingrese una opcion (1- " + opcionesMenu + "):");
			opcionUser = ingresarEntero();
			if(opcionUser < 1 || opcionUser > opcionesMenu) mostrarMensaje("Opcion invalida. Debe Ingresar un numero entre 1 y " + opcionesMenu);
		} while (opcionUser < 1 || opcionUser > opcionesMenu);
		
		return opciones[opcionUser - 1];
	}

	private static boolean agregarNuevoDestino(GestionDeTraslado actual) {
		/*
		 * Se debe solicitar el código, la ciudad y la distancia para definir el destino
		 * correspondiente y agregarlo al sistema.
		 */
		mostrarMensaje("Ingrese el codigo");
		int codigo = ingresarEntero();
		mostrarMensaje("Ingrese la ciudad");
		String ciudad = ingresarString();
		mostrarMensaje("Ingrese la distancia");
		double distancia = ingresarDecimal();
		
		Destino nuevoDestino = new Destino(codigo, ciudad, distancia);
		
		return actual.agregarDestino(nuevoDestino);
	}

	private static int ingresarEntero() {
		return teclado.nextInt();
	}

	private static boolean agregarViaje(GestionDeTraslado actual) {
		/*
		 * Se debera ingresar el codigo de destino (-1 salir), verificar si el destino
		 * ya ha sido ingresado con anterioridad e informar por pantalla el mensaje de
		 * "Error. El destino [codigoDestino] ya se ha ingresado o no ha sido definido
		 * por el usuario.
		 */

		/*
		 * Si el destino no se encuentra registrado, solicitar el nombre del cliente y
		 * añadirle un numero aleatorio definido en el rango de 7 a 99. A continuacion
		 * Ingrese el porcentaje de descuento (0~100) y agregue el nuevo viaje
		 * solicitado.
		 */
		 
		System.out.println(actual.obtenerDestinosDisponibles());
	    mostrarMensaje("Código de destino para el viaje (-1 para cancelar):");
	    int codigo = ingresarEntero();
	    if (codigo == -1) return false;

	    Destino destino = actual.buscarDestino(codigo);
	    if (destino == null) {
	        mostrarMensaje("Error. El destino " + codigo + " no existe.");
	        return false;  // cortamos aquí
	    }

	    mostrarMensaje("Nombre del pasajero:");
	    String nombre = ingresarString();

	    mostrarMensaje("Ingrese el porcentaje de descuento (0–100):");
	    double descuento = ingresarDecimal();
	    if (descuento < 0 || descuento > 100) {
	        mostrarMensaje("Descuento inválido, se usará 0%.");
	        descuento = 0;
	    }

	    int idRandom = (int) (Math.random() * (99-7) + 7);

	    // Ahora sí creamos el viaje ya con todos los datos validados
	    Viaje nuevoViaje = new Viaje(destino, nombre, descuento, idRandom);

	    return actual.agregarViaje(nuevoViaje);

	}

	private static void verResumen(GestionDeTraslado actual) {

		/*
		 * Se debe imprimir un resumen de los viajes realizados, indicando:
		 * 
		 * El viaje con el mayor precio. 
		 * El importe total acumulado.
		 */
        System.out.println("------- RESUMEN -------");
        System.out.println(actual.toString());
        System.out.println("Viaje de mayor precio:");
        System.out.println(actual.viajeDeMayorPrecio());
        System.out.println("-----------------------");
	}
}
