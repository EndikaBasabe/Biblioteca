package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controlador.ControladorPrestamo;

public class PrestamoModelo extends Conector {


	private ControladorPrestamo controladorPrestamo;
	
	public ArrayList<Prestamo> select() {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo(rs.getInt("id_libro"), rs.getInt("id_socio"), rs.getDate("fecha"),
						rs.getBoolean("devuelto"));
				prestamos.add(prestamo);
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamos;

	}



	public Prestamo select(int id_libro, int id_socio, java.util.Date fecha) {
		try {
			SimpleDateFormat eus_format = new SimpleDateFormat("yyyy-MM-dd");
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos " + "where id_libro='" + id_libro + "' and "
					+ "id_socio='" + id_socio + "' and " + "fecha='" + eus_format.format(fecha) + "'");
			rs.next();
			Prestamo prestamo = new Prestamo(id_libro, id_socio, fecha, rs.getBoolean("devuelto"));
			return prestamo;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Prestamo> prestamosDeSocio(int id_socio) {
		ArrayList<Prestamo> prestamos_socio = new ArrayList<Prestamo>();

		try {

			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos where id_socio=" + id_socio);
			while (rs.next()) {
				Prestamo prestamo = new Prestamo(rs.getInt("id_libro"), rs.getInt("id_socio"), rs.getDate("fecha"),
						rs.getBoolean("devuelto"));
				prestamos_socio.add(prestamo);
			}
			return prestamos_socio;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Prestamo prestamo) {
		try {
			PreparedStatement ps;
			ps = this.conexion.prepareStatement(
					"insert into " + "prestamos (id_libro,id_socio,fecha,devuelto)" + " values(?,?,?,?)");

			ps.setInt(1, prestamo.getId_libro()); // Rellena el primer ?
			ps.setInt(2, prestamo.getId_socio()); // Rellena el segundo ?
			java.sql.Date fecha_sql = new java.sql.Date(prestamo.getFecha().getTime());
			ps.setDate(3, fecha_sql); // Rellena el tercer ?
			ps.setBoolean(4, false); // Rellena el cuarto ?
			// Al insertar un nuevo prestamo, nunca est� devuelto, por eso siempre es false
			ps.execute();
			
			/* De la otra manera, sin un prepared statement
			 * Statement st = this.conexion.createStatement();
			 * st.execute("INSERT INTO `libros`(`titulo`, `autor`, `num_pag`)
			 * VALUES ('" + libro.getTitulo()+"', '"
			 * +libro.getAutor()+"','"+libro.getNum_pag()+ "')");
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}


	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}



	public ArrayList<Prestamo> selectPrestamosDeSocio(int idSocio) {
		
		try{
			PreparedStatement pst;
			pst = this.conexion.prepareStatement("select libros.*,prestamos.*, from prestamos join libros on prestamos.id_libro = libros.id where prestamos.idSocio = ?");
			
			pst.setInt(1, idSocio);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
				
				Libro libro = new Libro();
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNum_pag(rs.getInt("num_pag"));
				
				Socio socio = new Socio();
				
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				socio.setDni(rs.getString("dni"));
				
				Prestamo prestamo = new Prestamo();
				
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				prestamo.setLibro(libro);
				prestamo.setSocio(socio);
				
				prestamos.add(prestamo);
				
				return prestamos;
			}
		
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
