package Bean;

public class SeleccionesNacionales {

    private int idSeleccionesNacionales;
    private String nombre;
    private String tecnico;
    private Estadios estadio;

    public int getIdSeleccionesNacionales() {
        return idSeleccionesNacionales;
    }

    public void setIdSeleccionesNacionales(int idSeleccionesNacionales) {
        this.idSeleccionesNacionales = idSeleccionesNacionales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Estadios getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadios estadio) {
        this.estadio = estadio;
    }
}

