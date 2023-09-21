package br.com.alura.tienda.dao;

import javax.persistence.EntityManager;

import br.com.alura.tienda.modelo.Pedido;

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
}
