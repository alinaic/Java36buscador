package modelo;

import javax.servlet.http.Part;

public class Producto {

	 private String nombre;
	 private double precio;
	 private long id;
	 
	 
	 private Part imagenSubida;
	 private String rutaImagen;
	 private long idCategoria;
	 private Categoria categoria;
	 
	 public Producto() {
		
	}


	public Producto(String nombre, double precio, Part imagenSubida,
			long idCategoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.imagenSubida = imagenSubida;
		this.idCategoria = idCategoria;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio
				+ ", imagenSubida=" + imagenSubida + "]";
	}
	 
}
