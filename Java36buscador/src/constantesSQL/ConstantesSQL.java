package constantesSQL;

public class ConstantesSQL {
public static final String SQL_INSERCION_PRODUCTOS = 
"insert into tabla_productos(nombre, precio, id_categorias) " + "values(?,?,?)";
public static final String SQL_SELECION_PRODUCTOS = "SELECT tabla_productos.id, tabla_productos.nombre, tabla_productos.precio, tabla_productos.id,tabla_categorias.nombre as nombre_categoria FROM tabla_productos,tabla_categorias WHERE tabla_productos.id_categorias = tabla_categorias.id and tabla_productos.nombre like ? order by tabla_productos.id desc limit ?,? ";
public static final String SQL_SELECCION_CATEGORIAS = "select * from tabla_categorias";
public static final String SQL_CANTIDAD_TOTAL_PRODUCTOS = "SELECT count(id) as total FROM tabla_productos where tabla_productos.nombre like ?";
}
