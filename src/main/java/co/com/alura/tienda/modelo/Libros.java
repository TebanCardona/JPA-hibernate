package co.com.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libros extends Producto {
  private String autor;
  private int paginas;

  /**
   * 
   */
  public Libros() {
  }

  /**
   * @param autor
   * @param paginas
   */
  public Libros(String autor, int paginas) {
    this.autor = autor;
    this.paginas = paginas;
  }

  /**
   * @return the autor
   */
  public String getAutor() {
    return autor;
  }

  /**
   * @param autor the autor to set
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * @return the paginas
   */
  public int getPaginas() {
    return paginas;
  }

  /**
   * @param paginas the paginas to set
   */
  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

}
