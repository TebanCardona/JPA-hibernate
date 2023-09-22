package co.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import co.com.alura.tienda.dao.CategoriaDao;
import co.com.alura.tienda.dao.ClienteDao;
import co.com.alura.tienda.dao.PedidoDao;
import co.com.alura.tienda.dao.ProductoDao;
import co.com.alura.tienda.modelo.Categoria;
import co.com.alura.tienda.modelo.CategoriaId;
import co.com.alura.tienda.modelo.Cliente;
import co.com.alura.tienda.modelo.ItemsPedido;
import co.com.alura.tienda.modelo.Pedido;
import co.com.alura.tienda.modelo.Producto;
import co.com.alura.tienda.util.JPAUtil;

public class PruebaDeDesempenno {
  public static void main(String[] args) {
    registrarProducto("CELULARES", "Samsung Galaxy S21", "ASD", new BigDecimal("123"));
    EntityManager em = JPAUtil.getEntityManager();
    // * Categoria

    Categoria find = em.find(Categoria.class, new CategoriaId("CELULARES", "123"));
    System.out.println(find.getNombre());
    // * Pedido Con Cliente

    PedidoDao pedidoDao = new PedidoDao(em);
    Pedido pedido = pedidoDao.nombreCliente(1l);

    em.close();

    System.out.println(pedido.getCliente().getNombre());

  }

  private static void registrarProducto(String categoryName, String productName, String description,
      BigDecimal precio) {
    Categoria categoria = new Categoria(categoryName, "123");
    Producto producto = new Producto(productName, description, precio, categoria);
    EntityManager em = JPAUtil.getEntityManager();
    CategoriaDao categoriaDao = new CategoriaDao(em);
    ProductoDao productoDao = new ProductoDao(em);
    em.getTransaction().begin();

    categoriaDao.guardar(categoria);
    productoDao.guardar(producto);

    em.getTransaction().commit();

    PedidoDao pedidoDao = new PedidoDao(em);
    ClienteDao clienteDao = new ClienteDao(em);
    // * Cliente y Pedidos

    Cliente cliente = new Cliente("Juan", "asd123");
    Pedido pedido = new Pedido(cliente);

    pedido.agregarItems(new ItemsPedido(12, producto, pedido));

    // * Guardando Pedido y Cliente
    em.getTransaction().begin();
    clienteDao.guardar(cliente);
    pedidoDao.guardar(pedido);
    em.getTransaction().commit();
    em.close();
  }
}
