package br.com.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate fecha = LocalDate.now();
  private BigDecimal valorTotal = new BigDecimal(0);

  @ManyToOne
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<ItemsPedido> items = new ArrayList<>();

  /**
   * @param cliente
   */
  public Pedido(Cliente cliente) {
    this.cliente = cliente;
  }

  public Pedido(String name) {

  }

  public void agregarItems(ItemsPedido item) {
    item.setPedido(this);
    this.items.add(item);
    this.valorTotal = this.valorTotal.add(item.getValor());
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @return the fecha
   */
  public LocalDate getFecha() {
    return fecha;
  }

  /**
   * @param fecha the fecha to set
   */
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  /**
   * @return the valorTotal
   */
  public BigDecimal getValorTotal() {
    return valorTotal;
  }

  /**
   * @param valorTotal the valorTotal to set
   */
  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  /**
   * @return the cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * @param cliente the cliente to set
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
