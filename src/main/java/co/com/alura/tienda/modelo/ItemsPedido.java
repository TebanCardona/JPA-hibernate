package co.com.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items_pedido")
public class ItemsPedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int cantidad;
  private BigDecimal precioUnitario;

  @ManyToOne(fetch = FetchType.LAZY)
  private Producto producto;
  @ManyToOne(fetch = FetchType.LAZY)
  private Pedido pedido;

  /**
   * @param cantidad
   * @param producto
   * @param pedido
   */
  public ItemsPedido(int cantidad, Producto producto, Pedido pedido) {
    this.cantidad = cantidad;
    this.producto = producto;
    this.pedido = pedido;
    this.precioUnitario = producto.getPrecio();
  }

  /**
   * 
   */
  public ItemsPedido() {
  }

  /**
   * @return the cantidad
   */
  public int getCantidad() {
    return cantidad;
  }

  /**
   * @param cantidad the cantidad to set
   */
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  /**
   * @return the precioUnitario
   */
  public BigDecimal getPrecioUnitario() {
    return precioUnitario;
  }

  /**
   * @param precioUnitario the precioUnitario to set
   */
  public void setPrecioUnitario(BigDecimal precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  /**
   * @return the producto
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * @param producto the producto to set
   */
  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  /**
   * @return the pedido
   */
  public Pedido getPedido() {
    return pedido;
  }

  /**
   * @param pedido the pedido to set
   */
  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public BigDecimal getValor() {
    return this.precioUnitario.multiply(new BigDecimal(cantidad));
  }

}
