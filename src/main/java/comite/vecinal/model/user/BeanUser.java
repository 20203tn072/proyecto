package comite.vecinal.model.user;

import comite.vecinal.model.colonia.BeanColonia;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;

public class BeanUser {
    private long idUser;
    private String nombre;
    private String lastname;
    private String password;
    private String email;
    private int status;
    private BeanMunicipio idMunicipio;
    private BeanRole idRole;

    public BeanUser() {
    }

    public BeanUser(long idUser, String nombre, String lastname, String password, String email, int status, BeanMunicipio idMunicipio, BeanRole idRole) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.status = status;
        this.idMunicipio = idMunicipio;
        this.idRole = idRole;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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

    public BeanMunicipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(BeanMunicipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public BeanRole getIdRole() {
        return idRole;
    }

    public void setIdRole(BeanRole idRole) {
        this.idRole = idRole;
    }
}
