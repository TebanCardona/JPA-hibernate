package co.com.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import co.com.alura.tienda.modelo.Producto;

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
    String jqpl = "SELECT P FROM Producto AS P";
    return em.createQuery(jqpl, Producto.class).getResultList();
  }

  public List<Producto> consultaPorNombre(String nombre) {
    String jqpl = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
    return em.createQuery(jqpl, Producto.class).setParameter("nombre", nombre).getResultList();
  }

  public List<Producto> consultaPorNombreCat(String nombre) {
    String jqpl = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:nombre";
    return em.createQuery(jqpl, Producto.class).setParameter("nombre", nombre).getResultList();
  }

  public BigDecimal consultaPorPrecio(String name) {
    return em.createNamedQuery("Producto.consultaPorPrecio", BigDecimal.class).setParameter("nombre", name)
        .getSingleResult();
  }

  /*
   * V1
   * public List<Producto> consultarPorParametro(String nombre, BigDecimal precio,
   * LocalDate fecha) {
   * StringBuilder jqpl = new
   * StringBuilder("SELECT p FROM Producto p WHERE 1=1 ");
   * if (nombre != null && !nombre.trim().isEmpty()) {
   * jqpl.append("AND p.nombre=:nombre ");
   * } else if (precio != null && !precio.equals(new BigDecimal(0))) {
   * jqpl.append("AND p.precio=:precio ");
   * } else if (fecha != null) {
   * jqpl.append("AND p.fechaDeRegistro=:fecha");
   * }
   * TypedQuery<Producto> query = em.createQuery(jqpl.toString(), Producto.class);
   * if (nombre != null && !nombre.trim().isEmpty()) {
   * query.setParameter("nombre", nombre);
   * } else if (precio != null && !precio.equals(new BigDecimal(0))) {
   * query.setParameter("precio", precio);
   * 
   * } else if (fecha != null) {
   * query.setParameter("fechaDeRegistro", fecha);
   * }
   * return query.getResultList();
   * }
   * 
   */
  public List<Producto> consultarPorParametro(String nombre, BigDecimal precio, LocalDate fecha) {

    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Producto> query = builder.createQuery(Producto.class);

    Root<Producto> from = query.from(Producto.class);
    Predicate filter = builder.and();

    if (nombre != null && !nombre.trim().isEmpty()) {
      filter = builder.and(filter, builder.equal(from.get("nombre"), nombre));

    } else if (precio != null && !precio.equals(new BigDecimal(0))) {
      filter = builder.and(filter, builder.equal(from.get("precio"), precio));

    } else if (fecha != null) {
      filter = builder.and(filter, builder.equal(from.get("fechaDeRegistro"), fecha));

    }

    query.where(filter);
    return em.createQuery(query).getResultList();
  }
}
