package co.com.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
  private String nombreDelProducto;
  private Long CantidadDelProducto;
  private LocalDate FechaDeUltimaVenta;

  /**
   * @param nombreDelProducto
   * @param cantidadDelProducto
   * @param fechaDeUltimaVenta
   */
  public RelatorioDeVenta(String nombreDelProducto, Long cantidadDelProducto, LocalDate fechaDeUltimaVenta) {
    this.nombreDelProducto = nombreDelProducto;
    CantidadDelProducto = cantidadDelProducto;
    FechaDeUltimaVenta = fechaDeUltimaVenta;
  }

  /**
   * @return the nombreDelProducto
   */
  public String getNombreDelProducto() {
    return nombreDelProducto;
  }

  /**
   * @param nombreDelProducto the nombreDelProducto to set
   */
  public void setNombreDelProducto(String nombreDelProducto) {
    this.nombreDelProducto = nombreDelProducto;
  }

  /**
   * @return the cantidadDelProducto
   */
  public Long getCantidadDelProducto() {
    return CantidadDelProducto;
  }

  /**
   * @param cantidadDelProducto the cantidadDelProducto to set
   */
  public void setCantidadDelProducto(Long cantidadDelProducto) {
    CantidadDelProducto = cantidadDelProducto;
  }

  /**
   * @return the fechaDeUltimaVenta
   */
  public LocalDate getFechaDeUltimaVenta() {
    return FechaDeUltimaVenta;
  }

  /**
   * @param fechaDeUltimaVenta the fechaDeUltimaVenta to set
   */
  public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
    FechaDeUltimaVenta = fechaDeUltimaVenta;
  }

  @Override
  public String toString() {

    return " Relatorio De Venta [\n Nombre Del Producto: " + this.nombreDelProducto + "\n Cantidad De Producto: "
        + this.CantidadDelProducto + "\n Fecha De Ultima Venta: " + this.FechaDeUltimaVenta + "\n]";
  }

}
