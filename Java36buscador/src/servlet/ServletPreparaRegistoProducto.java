package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;


@WebServlet("/ServletPreparaRegistoProducto")
public class ServletPreparaRegistoProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosDAO dao = new ProductosDAOImpl();
		List<Categoria> categorias = dao.obtenerCategoria();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("registroProducto.jsp").forward(request, response);
		
		
	}

}
