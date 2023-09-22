package co.com.alura.tienda.dao;

import javax.persistence.EntityManager;

import co.com.alura.tienda.modelo.Cliente;

public class ClienteDao {
  private EntityManager em;

  public ClienteDao(EntityManager em) {
    this.em = em;
  }

  public void guardar(Cliente cliente) {
    this.em.persist(cliente);
  }

  public Cliente consultaPorId(Long id) {
    return em.find(Cliente.class, id);
  }
}
