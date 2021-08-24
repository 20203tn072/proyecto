package comite.vecinal.model.userEnlace;

import comite.vecinal.model.colonia.BeanColonia;
import comite.vecinal.model.incidente.BeanIncidente;
import comite.vecinal.model.role.BeanRole;

public class BeanEnlace {
    private long idEnlace;
    private String nombre;
    private String lastname;
    private String password;
    private String email;
    private int status;
    private BeanColonia beanColonia;
    private BeanIncidente beanIncidente;
    private BeanRole beanRole;

    public BeanEnlace() {
    }

    public BeanEnlace(long idEnlace, String nombre, String lastname, String password, String email, int status, BeanColonia beanColonia, BeanIncidente beanIncidente, BeanRole beanRole) {
        this.idEnlace = idEnlace;
        this.nombre = nombre;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.status = status;
        this.beanColonia = beanColonia;
        this.beanIncidente = beanIncidente;
        this.beanRole = beanRole;
    }

    public long getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(long idEnlace) {
        this.idEnlace = idEnlace;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BeanColonia getBeanColonia() {
        return beanColonia;
    }

    public void setBeanColonia(BeanColonia beanColonia) {
        this.beanColonia = beanColonia;
    }

    public BeanIncidente getBeanIncidente() {
        return beanIncidente;
    }

    public void setBeanIncidente(BeanIncidente beanIncidente) {
        this.beanIncidente = beanIncidente;
    }

    public BeanRole getBeanRole() {
        return beanRole;
    }

    public void setBeanRole(BeanRole beanRole) {
        this.beanRole = beanRole;
    }
}
