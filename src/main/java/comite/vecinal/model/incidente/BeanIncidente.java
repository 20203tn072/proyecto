package comite.vecinal.model.incidente;

import comite.vecinal.model.departamento.BeanDepartamento;
import comite.vecinal.model.userEnlace.BeanEnlace;

public class BeanIncidente {
    private long idIncidente;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private int status;
    private BeanDepartamento idDepartamento;
    private BeanEnlace idEnlace;

    public BeanIncidente() {
    }

    public BeanIncidente(long idIncidente, String nombre, String descripcion, String fechaInicio, String fechaFin, int status, BeanDepartamento idDepartamento, BeanEnlace idEnlace) {
        this.idIncidente = idIncidente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.status = status;
        this.idDepartamento = idDepartamento;
        this.idEnlace = idEnlace;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BeanDepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(BeanDepartamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public BeanEnlace getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(BeanEnlace idEnlace) {
        this.idEnlace = idEnlace;
    }
}
