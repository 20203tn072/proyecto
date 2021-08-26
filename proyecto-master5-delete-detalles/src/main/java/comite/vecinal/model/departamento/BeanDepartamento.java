package comite.vecinal.model.departamento;

public class BeanDepartamento {
    private long idDepartamento;
    private String nombre;

    public BeanDepartamento() {
    }

    public BeanDepartamento(long idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
