package br.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.tienda.dao.CategoriaDao;
import br.com.alura.tienda.dao.ClienteDao;
import br.com.alura.tienda.dao.PedidoDao;
import br.com.alura.tienda.dao.ProductoDao;
import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Cliente;
import br.com.alura.tienda.modelo.ItemsPedido;
import br.com.alura.tienda.modelo.Pedido;
import br.com.alura.tienda.modelo.Producto;
import br.com.alura.tienda.util.JPAUtil;

public class RegistroDePedido {

  public static void main(String[] args) {
    // * Registro de Productos
    registrarProducto("CELULARES", "Samsung Galaxy S21", "ASD", new BigDecimal("123"));
    registrarProducto("CELULARES", "Samsung Galaxy S11", "ASD", new BigDecimal("123"));
    registrarProducto("CELULARES", "Samsung Galaxy S31", "ASD", new BigDecimal("123"));

    // * EM y DAO's

    EntityManager em = JPAUtil.getEntityManager();

    ProductoDao productoDao = new ProductoDao(em);

    PedidoDao pedidoDao = new PedidoDao(em);
    ClienteDao clienteDao = new ClienteDao(em);
    // * Cliente y Pedidos

    Cliente cliente = new Cliente("Juan", "asd123");
    Pedido pedido = new Pedido(cliente);
    Producto producto = productoDao.consultaPorId(1l);

    pedido.agregarItems(new ItemsPedido(12, producto, pedido));

    // * Guardando Pedido y Cliente
    em.getTransaction().begin();
    clienteDao.guardar(cliente);
    pedidoDao.guardar(pedido);
    em.getTransaction().commit();
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
