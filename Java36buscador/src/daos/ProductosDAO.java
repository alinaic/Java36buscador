package daos;

import java.util.List;

import modelo.Categoria;
import modelo.Producto;

public interface ProductosDAO {

	void registrarProducto(Producto p);

	List<Producto> obtenerProductos(int desde, int cuantos, String busqueda);
	
	
	
	
	// lo suyo es que el siguiente metodo estuviese en un interfaz
	// llamado CategoriasDao

	List<Categoria> obtenerCategoria();

	int obtenerTotalProductos(String busqueda);
}
