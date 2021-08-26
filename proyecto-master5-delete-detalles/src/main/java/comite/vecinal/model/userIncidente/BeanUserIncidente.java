package comite.vecinal.model.userIncidente;

public class BeanUserIncidente {
    private long id;
    private String nombre;
    private long idMunicipio;

    public BeanUserIncidente() {
    }

    public BeanUserIncidente(long id, String nombre, long idMunicipio) {
        this.id = id;
        this.nombre = nombre;
        this.idMunicipio = idMunicipio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
