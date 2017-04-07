package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamo {
	
	//-----Atributos
	
	private int id_libro;
	private int id_socio;
	private Date fecha;
	private boolean devuelto;
	private Libro libro;
	private Socio socio;

	//-----Constructores
	
	public Prestamo(int id_libro, int id_socio, Date fecha, boolean devuelto) {
		super();
		this.id_libro = id_libro;
		this.id_socio = id_socio;
		this.fecha = fecha;
		this.devuelto = devuelto;
	}
	
	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//-----Metodos
	
	public void mostrarInfo() {
	
		LibroModelo lm = new LibroModelo();
		SocioModelo sm = new SocioModelo();
		
		Libro libro = lm.select(this.id_libro);
		Socio socio  = sm.select(this.id_socio);
		
		System.out.println("Nombre de libro: " + libro.getTitulo());
		System.out.println("Nombre de socio: " + socio.getNombre());
		System.out.println("Fecha: " + this.fecha);
		System.out.println("Ha sido devuelto?: " + (this.devuelto?"Si":"No"));
		System.out.println("------------------------------");
	}
	
	//-----Getters y Setters
	
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_socio() {
		return id_socio;
	}

	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
