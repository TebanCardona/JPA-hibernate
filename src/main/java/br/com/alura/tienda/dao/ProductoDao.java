package br.com.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.tienda.modelo.Producto;

public class ProductoDao {

  private EntityManager em;

  public ProductoDao(EntityManager em) {
    this.em = em;
  }

  public void guardar(Producto producto) {
    this.em.persist(producto);
  }

  public Producto consultaPorId(Long id) {
    return em.find(Producto.class, id);
  }

  public List<Producto> consultarTodos() {
    String query = "SELECT P FROM Producto AS P";
    return em.createQuery(query, Producto.class).getResultList();
  }

  public List<Producto> consultaPorNombre(String nombre) {
    String query = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
    return em.createQuery(query, Producto.class).setParameter("nombre", nombre).getResultList();
  }

  public List<Producto> consultaPorNombreCat(String nombre) {
    String query = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:nombre";
    return em.createQuery(query, Producto.class).setParameter("nombre", nombre).getResultList();
  }

  public BigDecimal consultPriceForName(String name) {
    String query = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
    return em.createQuery(query, BigDecimal.class).setParameter("name", name).getSingleResult();
  }
}
