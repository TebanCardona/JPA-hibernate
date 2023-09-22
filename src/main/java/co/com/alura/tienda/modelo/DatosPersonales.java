package co.com.alura.tienda.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DatosPersonales implements Serializable {
  private String nombre;
  private String dni;

  public DatosPersonales() {
  }

  /**
   * @param nombre
   * @param dni
   */
  public DatosPersonales(String nombre, String dni) {
    this.nombre = nombre;
    this.dni = dni;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
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

}
