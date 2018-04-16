package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;


@WebServlet("/ServletListadoProductos")
public class ServletListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//para el buscador
		String busqueda = request.getParameter("campoBusqueda");
		if(busqueda==null){
			busqueda="";
		}
		
		//para la paginacion:
		String desde = request.getParameter("desde");
		String cuantos = request.getParameter("cuantos");
		int desdeInt = 0;
		int cuantosInt = 10;
		if(desde!=null && cuantos!=null){
			desdeInt = Integer.parseInt(desde);
			cuantosInt = Integer.parseInt(cuantos);
		}
		
		//usar el dao
		ProductosDAO dao = new ProductosDAOImpl();
		System.out.println("desde: " + desdeInt + " cuantos: "+cuantosInt);
		List<Producto> productos = dao.obtenerProductos(desdeInt,cuantosInt,busqueda);
		
		//preparar las variables para la jsp
		request.setAttribute("productos", productos);
		request.setAttribute("productosTotales", dao.obtenerTotalProductos(busqueda));
		request.setAttribute("desdeSiguiente", desdeInt + 20);
		request.setAttribute("desdeAnterior", desdeInt - 20);
		request.getRequestDispatcher("listadoProductos.jsp").forward(request, response);
	}

}
