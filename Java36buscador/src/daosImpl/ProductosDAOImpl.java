package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilidades.GestorArchivos;
import constantesSQL.ConstantesSQL;
import modelo.Categoria;
import modelo.Producto;
import daos.GenericDAO;
import daos.ProductosDAO;

public class ProductosDAOImpl extends GenericDAO implements ProductosDAO{

	@Override
	public void registrarProducto(Producto p) {
		conectar();
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.SQL_INSERCION_PRODUCTOS, Statement.RETURN_GENERATED_KEYS);
		
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setLong(3, p.getIdCategoria());
			ps.execute();
			
			//una vez insertado el registro vamos a pedir un id que se ha autogenerado
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				int idGenerado = rs.getInt(1);
				System.out.println("id generado en bd: " + idGenerado);
				
				// guardar  la imagen del producto en una carpeta nombrada
				// con el mismo id generado
				GestorArchivos.guardarArchivo(p.getImagenSubida(), idGenerado + ".jpg");
			}
			ps.close();
		
		} catch (SQLException e) {
			System.out.println("error en la sql o similar");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		desconectar();
		
	}

	@Override
	public List<Producto> obtenerProductos(int desde, int cuantos, String busqueda) {
		conectar();
		List<Producto> productos = new ArrayList<Producto>();
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.SQL_SELECION_PRODUCTOS);
			ps.setString(1, "%"+busqueda+"%");
			ps.setInt(2, desde);
			ps.setInt(3, cuantos);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Producto p = new Producto();
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setId(rs.getLong("id"));
				p.setRutaImagen(GestorArchivos.rutaArchivo(rs.getInt("id")));
				Categoria c = new Categoria();
				c.setNombre(rs.getString("nombre_categoria"));
				p.setCategoria(c);
				productos.add(p);
			}// end while
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("posiblemente la sql esta mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return productos;
	}

	@Override
	public List<Categoria> obtenerCategoria() {
		conectar();
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.SQL_SELECCION_CATEGORIAS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Categoria c = new Categoria();
				c.setNombre(rs.getString("nombre"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setId(rs.getLong("id"));
				categorias.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la SQL ESTA MAL");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return categorias;
	}

	@Override
	public int obtenerTotalProductos(String busqueda) {
		conectar();
		int total = 0;
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.SQL_CANTIDAD_TOTAL_PRODUCTOS);
		ps.setString(1, "%"+busqueda+"%");
			ResultSet rs = ps.executeQuery();
		if(rs.next()){
			total = rs.getInt("total");
			
		}
		
		rs.close();
		ps.close();
		} catch (SQLException e) {
			System.out.println("la sql puede estar mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return total;
	}

}
