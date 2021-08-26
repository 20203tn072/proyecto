package comite.vecinal.model.incidente;

import comite.vecinal.model.departamento.BeanDepartamento;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import comite.vecinal.model.user.BeanUser;
import comite.vecinal.service.ConnectionMySQL;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoIncidente {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoIncidente.class);

    public List<BeanIncidente> findAll(){
        List<BeanIncidente> listIncidents = new ArrayList<>();
        try {
            con= ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll}");
            rs = cstm.executeQuery();

            while (rs.next()){
                BeanDepartamento departamento = new BeanDepartamento();
                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                BeanUser user = new BeanUser();
                BeanIncidente incidente = new BeanIncidente();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                municipio.setId(rs.getInt("idMun"));
                municipio.setNombre(rs.getString("nombreMun"));

                departamento.setIdDepartamento(rs.getInt("IdDepto"));
                departamento.setNombre(rs.getString("NombreDepto"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));

                incidente.setIdIncidente(rs.getInt("IdINcidente"));
                incidente.setNombre(rs.getString("Encabezado"));
                incidente.setDescripcion(rs.getString("Descripcion"));


                incidente.setIdUser(user);
                incidente.setIdDepartamento(departamento);

                listIncidents.add(incidente);

                /*--------------------------------------------------*/


            }

        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());

        }finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return listIncidents;
    }

    public boolean create(BeanIncidente incidente){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call in_create(?,?,?,?)}");
            cstm.setString(1, incidente.getNombre());
            cstm.setString(2, incidente.getDescripcion());
            cstm.setLong(3, incidente.getIdDepartamento().getIdDepartamento());
            cstm.setLong(4, incidente.getIdUser().getIdUser());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanIncidente incidente){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call in_update(?,?,?,?,?)}");
            cstm.setString(1, incidente.getNombre());
            cstm.setString(2, incidente.getDescripcion());
            cstm.setLong(3, incidente.getIdDepartamento().getIdDepartamento());
            cstm.setLong(4, incidente.getIdUser().getIdUser());
            cstm.setLong(5,incidente.getIdIncidente());
            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally {

        }
        return flag;
    }

    public boolean delete(long idIncidente){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm=con.prepareCall("{call in_delete(?)}");
            cstm.setLong(1,idIncidente);
            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

}