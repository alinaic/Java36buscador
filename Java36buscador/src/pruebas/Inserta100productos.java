package pruebas;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;
import modelo.Producto;

public class Inserta100productos {

	public static void main(String[] args) {
		Producto p = new Producto();
		ProductosDAO dao = new ProductosDAOImpl();
		for (int i = 0; i<100; i++){
			p.setNombre("producto"+i);
			p.setPrecio(i);
			p.setIdCategoria(1);
			dao.registrarProducto(p);
		}//for
	}//main

}
