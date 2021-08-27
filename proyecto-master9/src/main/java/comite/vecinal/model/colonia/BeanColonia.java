package comite.vecinal.model.colonia;

import comite.vecinal.model.municipio.BeanMunicipio;

public class BeanColonia {
    private long idColonia;
    private String nombre;

    public BeanColonia() {
    }

    public BeanColonia(long idColonia, String nombre) {
        this.idColonia = idColonia;
        this.nombre = nombre;
    }

    public long getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(long idColonia) {
        this.idColonia = idColonia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
