package ar.edu.unlam.pb1.interfaz.enums;

public enum MenuPrincipal {
	AGREGAR_DESTINO("Agregar destino"),AGREGAR_VIAJE("Agregar viaje"),VER_RESUMEN("Ver resumen"),SALIR("Salir");
	
	private String descripcion;

	MenuPrincipal(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
}
