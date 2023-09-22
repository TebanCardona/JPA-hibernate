package co.com.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import co.com.alura.tienda.modelo.Pedido;
import co.com.alura.tienda.vo.RelatorioDeVenta;

public class PedidoDao {
  private EntityManager em;

  public PedidoDao(EntityManager em) {
    this.em = em;
  }

  public void guardar(Pedido pedido) {
    this.em.persist(pedido);
  }

  public Pedido consultaPorId(Long id) {
    return em.find(Pedido.class, id);
  }

  public List<Pedido> consultarTodos() {
    String jqpl = "SELECT p FROM Pedido AS P";
    return em.createQuery(jqpl, Pedido.class).getResultList();
  }

  public List<Pedido> consultaPorNombre(String name) {
    String jqpl = "SELECT p FROM Pedido AS p WHERE p.cliente.nombre=:name";
    return em.createQuery(jqpl, Pedido.class).setParameter("name", name).getResultList();
  }

  public BigDecimal valorTatalVendido() {
    String jqpl = "SELECT SUM(p, valorTotal) FROM Pedido AS p";
    return em.createQuery(jqpl, BigDecimal.class).getSingleResult();
  }

  /*
   * V1
   * public List<Object[]> relatorioDeVentas() {
   * String jqpl = "SELECT producto.nombre "
   * + "SUM(item.cantidad), "
   * + "MAX(pedido.fecha) "
   * + "FROM Pedido pedido "
   * + "JOIN pedido.items item "
   * + "JOIN item.producto producto "
   * + "GROUP BY producto.nombre "
   * + "ORDER BY item.cantidad DESC";
   * return em.createQuery(jqpl, Object[].class).getResultList();
   * }
   */

  // * V2
  public List<RelatorioDeVenta> relatorioDeVentas() {
    String jqpl = "SELECT new co.com.alura.tienda.vo.RelatorioDeVenta(producto.nombre, "
        + "SUM(item.cantidad), "
        + "MAX(pedido.fecha)) "
        + "FROM Pedido pedido "
        + "JOIN pedido.items item "
        + "JOIN item.producto producto "
        + "GROUP BY producto.nombre "
        + "ORDER BY item.cantidad DESC";
    return em.createQuery(jqpl, RelatorioDeVenta.class).getResultList();
  }

  public Pedido nombreCliente(Long id) {
    String jqpl = "SELECT p FROM Pedido as p JOIN FETCH p.cliente WHERE p.id=:id";
    return em.createQuery(jqpl, Pedido.class).setParameter("id", id).getSingleResult();
  }
}
