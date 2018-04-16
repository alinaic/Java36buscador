package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;
import modelo.Producto;

@WebServlet("/ServletRegistroProducto")
@MultipartConfig
public class ServletRegistroProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// que no se nos olvide marcar este servlet como @MultipartConfig
		// asi indicamos a java que este servlet va a recibir archivos
		String nombre = request.getParameter("campoNombre");
		String precio = request.getParameter("campoPrecio");
		String idCategoria = request.getParameter("campoIdCategoria");
		Part imagen = request.getPart("campoImagen");
		//falta parte de validacion
		
		
		//creamos una carpeta 
		File directorioSubidas = new File("subidas");
		if(!directorioSubidas.exists()){
			directorioSubidas.mkdir();
		}
		// del archivo subido abro un flujo de datos para leerlo
		//InputStream fis = imagen.getInputStream();
		//y escribirlo en la siguiente ruta fija
		//FileOutputStream fos = new FileOutputStream("subidas/subida.jpg");
		//byte[] leido =new byte [1024];
		//recordar ejercicio lectura escritura archivo binario
		//while(fis.read(leido) != -1){
			//fos.write(leido);
		//}
		//fis.close();
		//fos.close();
		//File archivoSubido = new File("subidas/subida.jpg");
		//if(archivoSubido.exists()){
			//System.out.println("archivo subido correctamente");
			//System.out.println("archivo ubicado en: " + archivoSubido.getAbsolutePath());
		//}else{
			//System.out.println("error en la ruta o la subida de archivo");
		//}
		Producto productoAregistrar = new Producto(nombre, Double.parseDouble(precio), imagen, Long.parseLong(idCategoria));
		ProductosDAO dao = new ProductosDAOImpl();
		dao.registrarProducto(productoAregistrar);
		System.out.println("producto registrado ok");
		
	} // end doPost

}
