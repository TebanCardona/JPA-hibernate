package co.com.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.consultaPorPrecio", query = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String descripcion;
  private BigDecimal precio;
  private LocalDate fechaDeRegistro = LocalDate.now();

  @ManyToOne(fetch = FetchType.LAZY)
  private Categoria categoria;

  /**
   * @return the fechaDeRegistro
   */
  public LocalDate getFechaDeRegistro() {
    return fechaDeRegistro;
  }

  public Producto() {
    super();
  }

  public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {

    return "Producto: " + nombre;
  }

}
