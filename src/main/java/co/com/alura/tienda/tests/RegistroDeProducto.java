package co.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import co.com.alura.tienda.dao.CategoriaDao;
import co.com.alura.tienda.dao.ProductoDao;
import co.com.alura.tienda.modelo.Categoria;
import co.com.alura.tienda.modelo.Producto;
import co.com.alura.tienda.util.JPAUtil;

public class RegistroDeProducto {

  public static void main(String[] args) {
    registrarProducto("CELULARES", "Samsung Galaxy S21", "ASD", new BigDecimal("123"));
    registrarProducto("CELULARES", "Samsung Galaxy S11", "ASD", new BigDecimal("123"));
    registrarProducto("CELULARES", "Samsung Galaxy S31", "ASD", new BigDecimal("123"));
    EntityManager em = JPAUtil.getEntityManager();
    ProductoDao productoDao = new ProductoDao(em);
    var asd = productoDao.consultaPorPrecio("Samsung Galaxy S21");
    System.out.println(asd);
    var nombre = productoDao.consultarTodos();
    nombre.forEach(prod -> System.out.println(prod.getNombre()));
  }

  private static void registrarProducto(String categoryName, String productName, String description,
      BigDecimal precio) {
    Categoria categoria = new Categoria(categoryName);
    Producto producto = new Producto(productName, description, precio, categoria);
    EntityManager em = JPAUtil.getEntityManager();
    CategoriaDao categoriaDao = new CategoriaDao(em);
    ProductoDao productoDao = new ProductoDao(em);
    em.getTransaction().begin();

    categoriaDao.guardar(categoria);
    productoDao.guardar(producto);

    em.getTransaction().commit();
    em.close();
    // V1
    /*
     * em.persist(celulares);
     * celulares.setNombre("LAPTOPS");
     * em.getTransaction().commit();
     * em.close();
     * 
     * celulares.setNombre("PANTALLAS");
     */
    // V2
    /*
     * em.persist(celulares);
     * celulares.setNombre("LAPTOPS");
     * em.flush();
     * em.clear();
     * 
     * celulares = em.merge(celulares);
     * celulares.setNombre("PANTALLAS");
     * em.flush();
     * em.remove(celulares);
     */

    // V3
    /*
     * em.persist(celulares);
     * celulares.setNombre("LAPTOPS");
     * em.flush();
     * em.clear();
     * 
     * celulares = em.merge(celulares);
     * celulares.setNombre("PANTALLAS");
     * em.flush();
     * //em.clear();
     * em.remove(celulares);
     * em.flush();
     */
  }
}
