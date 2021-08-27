package comite.vecinal.model.user;

import comite.vecinal.model.departamento.BeanDepartamento;
import comite.vecinal.model.incidente.BeanIncidente;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import comite.vecinal.service.ConnectionMySQL;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUser {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoUser.class);

    public List<BeanUser> findAll(){
        List<BeanUser> listUsers = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN incidentes AS P ON U.idincidente = P.id INNER JOIN deps AS R ON U.iddep = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findEnlace}");
            rs = cstm.executeQuery();

            while(rs.next()){

                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                BeanUser user = new BeanUser();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                municipio.setId(rs.getInt("idMun"));
                municipio.setNombre(rs.getString("nombreMun"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));
                user.setIdMunicipio(municipio);
                user.setIdRole(role);

                listUsers.add(user);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listUsers;
    }

    public List<BeanUser> findEnlace(){
        List<BeanUser> listUsers = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN incidentes AS P ON U.idincidente = P.id INNER JOIN deps AS R ON U.iddep = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findEnlace}");
            rs = cstm.executeQuery();

            while(rs.next()){

                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                BeanUser user = new BeanUser();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                municipio.setId(rs.getInt("idMun"));
                municipio.setNombre(rs.getString("nombreMun"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));
                user.setIdMunicipio(municipio);
                user.setIdRole(role);

                listUsers.add(user);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listUsers;
    }


    public BeanUser findById(long idUser){
        BeanUser user = null;
        try {
            // SELECT * FROM usuario AS U INNER JOIN municipio AS M ON U.idMunicipio = M.IdMun INNER JOIN roles AS R ON U.idRoles = R.idRole;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM usuario AS U INNER JOIN municipio AS M ON U.idMunicipio = M.IdMun INNER JOIN roles AS R ON U.idRoles = R.idRole WHERE U.idUser = ?");
            cstm.setLong(1, idUser);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                user = new BeanUser();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                municipio.setId(rs.getInt("idMun"));
                municipio.setNombre(rs.getString("nombreMun"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));

                user.setIdMunicipio(municipio);
                user.setIdRole(role);


            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return user;
    }

    public boolean create(BeanUser user){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?,?,?)}");
            cstm.setString(1, user.getNombre());
            cstm.setString(2, user.getLastname());
            cstm.setString(3, user.getPassword());
            cstm.setString(4, user.getEmail());
            cstm.setLong(5, user.getIdRole().getIdRole());
            cstm.setLong(6, user.getIdMunicipio().getId());

            cstm.execute();
            flag = true;
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanUser user){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?,?,?)}");
            cstm.setString(1, user.getNombre());
            cstm.setString(2, user.getLastname());
            cstm.setString(3, user.getPassword());
            cstm.setString(4, user.getEmail());
            cstm.setInt(5, user.getIdRole().getIdRole());
            cstm.setLong(6, user.getIdMunicipio().getId());
            cstm.setLong(7, user.getIdUser());

            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(long idUser){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?)}");
            cstm.setLong(1, idUser);
            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean createSession(String email, String password, int idRol){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM usuario WHERE email = ? AND password = ? AND idRoles = ?");
            cstm.setString(1, email);
            cstm.setString(2, password);
            cstm.setInt(3,idRol);
            rs = cstm.executeQuery();

            if(rs.next()){
                flag = true;
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un problema" + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return flag;
    }

}
