package co.com.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "electronicos")
public class Electronico extends Producto {
  private String marca;
  private String modelo;

  /**
   * 
   */
  public Electronico() {
  }

  /**
   * @param marca
   * @param modelo
   */
  public Electronico(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  /**
   * @return the marca
   */
  public String getMarca() {
    return marca;
  }

  /**
   * @param marca the marca to set
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * @return the modelo
   */
  public String getModelo() {
    return modelo;
  }

  /**
   * @param modelo the modelo to set
   */
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

}
