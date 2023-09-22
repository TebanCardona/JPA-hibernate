package co.com.alura.tienda.modelo;

import javax.persistence.Embedded;
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

  @Embedded
  private DatosPersonales datosPersonales;

  public Cliente() {

  }

  public Cliente(String name, String dni) {
    datosPersonales = new DatosPersonales(name, dni);
  }

  public String getNombre() {
    return datosPersonales.getNombre();
  }

  public void setNombre(String nombre) {
    datosPersonales.setNombre(nombre);
  }

  /**
   * @return the dni
   */
  public String getDni() {
    return datosPersonales.getDni();
  }

  /**
   * @param dni the dni to set
   */
  public void setDni(String dni) {
    datosPersonales.setDni(dni);
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

}
