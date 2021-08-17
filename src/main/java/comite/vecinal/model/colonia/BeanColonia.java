package comite.vecinal.model.colonia;

import comite.vecinal.model.municipio.BeanMunicipio;

public class BeanColonia {
    private long idColonia;
    private String nombre;
    private BeanMunicipio idMunicipio;

    public BeanColonia() {
    }

    public BeanColonia(long idColonia, String nombre, BeanMunicipio idMunicipio) {
        this.idColonia = idColonia;
        this.nombre = nombre;
        this.idMunicipio = idMunicipio;
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

    public BeanMunicipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(BeanMunicipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
