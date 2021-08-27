package comite.vecinal.model.incidente;

import comite.vecinal.model.departamento.BeanDepartamento;
import comite.vecinal.model.user.BeanUser;

public class BeanIncidente {
    private long idIncidente;
    private String nombre;
    private String descripcion;
    private int status;
    private BeanUser idUser;
    private BeanDepartamento idDepartamento;

    public BeanIncidente() {
    }

    public BeanIncidente(long idIncidente, String nombre, String descripcion, int status, BeanUser idUser, BeanDepartamento idDepartamento) {
        this.idIncidente = idIncidente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.status = status;
        this.idUser = idUser;
        this.idDepartamento = idDepartamento;
    }

    public long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(long idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BeanUser getIdUser() {
        return idUser;
    }

    public void setIdUser(BeanUser idUser) {
        this.idUser = idUser;
    }

    public BeanDepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(BeanDepartamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
