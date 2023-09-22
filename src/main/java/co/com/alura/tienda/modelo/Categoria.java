package co.com.alura.tienda.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

  @EmbeddedId
  private CategoriaId categoriaId;

  public Categoria() {
  }

  public Categoria(String name, String password) {
    this.categoriaId = new CategoriaId(name, password);
  }

  public String getNombre() {
    return categoriaId.getName();
  }

  public void setNombre(String nombre) {
    this.categoriaId.setName(nombre);
  }

}
