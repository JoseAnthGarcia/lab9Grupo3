package Bean;

public class Partidos {

    private int idPartido;
    private String fecha;
    private int numeroJornada;
    private SeleccionesNacionales seleccionLocal;
    private SeleccionesNacionales seleccionVisitante;
    private Arbitros arbitro;


    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public SeleccionesNacionales getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(SeleccionesNacionales seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public SeleccionesNacionales getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(SeleccionesNacionales seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public Arbitros getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitros arbitro) {
        this.arbitro = arbitro;
    }
}
