package co.com.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String dni;

  public Cliente() {
    super();
  }

  public Cliente(String name, String dni) {
    this.nombre = name;
    this.dni = dni;

  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the dni
   */
  public String getDni() {
    return dni;
  }

  /**
   * @param dni the dni to set
   */
  public void setDni(String dni) {
    this.dni = dni;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

}
