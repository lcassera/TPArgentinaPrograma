package ap.utnfrc.grupo13;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido() {
    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int GolesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = GolesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(Equipo equipo) {
        //if (equipo.equals(equipo1)){
        if ((equipo1.getNombre().equals(equipo.getNombre()) && (equipo1.getDescripcion().equals(equipo.getDescripcion())))) {
            if (golesEquipo1 > golesEquipo2) {
                return (ResultadoEnum.GANADOR);
            } else if (golesEquipo1 < golesEquipo2) {
                return (ResultadoEnum.PERDEDOR);
            } else {
                return (ResultadoEnum.EMPATE);
            }
        } else if ((equipo2.getNombre().equals(equipo.getNombre()) && (equipo2.getDescripcion().equals(equipo.getDescripcion())))) {
            if (golesEquipo2 > golesEquipo1) {
                return (ResultadoEnum.GANADOR);
            } else if (golesEquipo2 < golesEquipo1) {
                return (ResultadoEnum.PERDEDOR);
            } else {
                return (ResultadoEnum.EMPATE);
            }
        }
        else {
            return null;
        }

    }

    @Override
    public String toString()
    {
        return "Partido{" +
                "equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                ", golesEquipo1=" + golesEquipo1 +
                ", golesEquipo2=" + golesEquipo2 +
                '}';
    }
}
