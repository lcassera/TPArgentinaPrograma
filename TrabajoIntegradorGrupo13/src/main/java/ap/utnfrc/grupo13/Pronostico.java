package ap.utnfrc.grupo13;

public class Pronostico {
  private Partido partido;
  private Equipo equipo;
  private ResultadoEnum resultado;

  //esta es una linea de prueba


  public Pronostico() {
  }

  public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
    this.partido = partido;
    this.equipo = equipo;
    this.resultado = resultado;
  }

  public Partido getPartido() {
    return partido;
  }

  public void setPartido(Partido partido) {
    this.partido = partido;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
  }

  public ResultadoEnum getResultado() {
    return resultado;
  }

  public void setResultado(ResultadoEnum resultado) {
    this.resultado = resultado;
  }
public int puntos(){
    if (resultado.equals(partido.resultado(equipo))) {
      return 1;
    }
    return 0;
}

  @Override
  public String toString() {
    return "Pronostico{" +
            "partido=" + partido +
            ", equipo=" + equipo +
            ", resultado=" + resultado +
            '}';
  }
}
