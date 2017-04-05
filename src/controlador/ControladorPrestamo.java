package controlador;

import modelo.Libro;
import modelo.LibroModelo;
import modelo.PrestamoModelo;
import modelo.SocioModelo;
import vista.GestionPrestamo;
import vista.Principal;
import vista.RealizarPrestamo;

public class ControladorPrestamo {

	private PrestamoModelo prestamoModelo;
	private Principal principal;
	private GestionPrestamo gestionPrestamo;
	private RealizarPrestamo realizarPrestamo;
	private SocioModelo socioModelo;
	private LibroModelo libroModelo;
	
	public PrestamoModelo getPrestamoModelo() {
		return prestamoModelo;
	}
	public void setPrestamoModelo(PrestamoModelo prestamoModelo) {
		this.prestamoModelo = prestamoModelo;
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public GestionPrestamo getGestionPrestamo() {
		return gestionPrestamo;
	}
	public void setGestionPrestamo(GestionPrestamo gestionPrestamo) {
		this.gestionPrestamo = gestionPrestamo;
	}
	public RealizarPrestamo getRealizarPrestamo() {
		return realizarPrestamo;
	}
	public void setRealizarPrestamo(RealizarPrestamo realizarPrestamo) {
		this.realizarPrestamo = realizarPrestamo;
	}
	public SocioModelo getSocioModelo() {
		return socioModelo;
	}
	public void setSocioModelo(SocioModelo socioModelo) {
		this.socioModelo = socioModelo;
	}
	public LibroModelo getLibroModelo() {
		return libroModelo;
	}
	public void setLibroModelo(LibroModelo libroModelo) {
		this.libroModelo = libroModelo;
	}
	public void abrirVentanaGestionPrestamo() {
		this.gestionPrestamo.setVisible(true);
		
	}
	public void abrirVentanaRealizarPrestamo() {
		this.realizarPrestamo.setVisible(true);
		
	}
	public void realizarPrestamo(int idSocio, String titulo) {
		Libro libro = this.libroModelo.libroPorTitulo(titulo);
		//prestamo objetua sortu
		
		//prestamo objetua bete
		
		//prestamo modelori esan insert egiteko prestamoa pasata.
		
	}

}
