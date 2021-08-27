package comite.vecinal.model.userEnlace;

import comite.vecinal.model.colonia.BeanColonia;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import comite.vecinal.model.user.BeanUser;
import comite.vecinal.model.user.DaoUser;
import comite.vecinal.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUserEnlace {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoUserEnlace.class);

    public List<BeanUserEnlace> findAll(){
        List<BeanUserEnlace> listUsers2 = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN incidentes AS P ON U.idincidente = P.id INNER JOIN deps AS R ON U.iddep = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findComite}");
            rs = cstm.executeQuery();

            while(rs.next()){

                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                BeanUserEnlace user = new BeanUserEnlace();
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
                user.setColonia(rs.getString("colonia"));
                user.setIdMunicipio(municipio);
                user.setIdRole(role);
                /*
                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));
                user.setColonia(rs.getString("colonia"));
                */

                user.setIdRole(role);

                listUsers2.add(user);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listUsers2;
    }

    public List<BeanUserEnlace> findEnlace(){
        List<BeanUserEnlace> listUsers2 = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN incidentes AS P ON U.idincidente = P.id INNER JOIN deps AS R ON U.iddep = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findEnlace2}");
            rs = cstm.executeQuery();

            while(rs.next()){

                BeanRole role = new BeanRole();
                BeanUserEnlace user = new BeanUserEnlace();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));
                user.setColonia(rs.getString("colonia"));

                user.setIdRole(role);

                listUsers2.add(user);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listUsers2;
    }


    public BeanUserEnlace findById(long idUser){
        BeanUserEnlace user = null;
        try {
            // SELECT * FROM usuario AS U INNER JOIN municipio AS M ON U.idMunicipio = M.IdMun INNER JOIN roles AS R ON U.idRoles = R.idRole;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{SELECT * FROM usuario AS U INNER JOIN municipio AS M ON U.idMunicipio = M.IdMun INNER JOIN roles AS R ON U.idRoles = R.idRole WHERE U.idUser = ?;}");
            cstm.setLong(1, idUser);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                user = new BeanUserEnlace();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                municipio.setId(rs.getInt("idMun"));
                municipio.setNombre(rs.getString("nombreMun"));

                user.setIdUser(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setColonia(rs.getString("colonia"));

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

    public boolean create(BeanUserEnlace user){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_createComite(?,?,?,?,?,?,?)}");
            cstm.setString(1, user.getNombre());
            cstm.setString(2, user.getLastname());
            cstm.setString(3, user.getPassword());
            cstm.setString(4, user.getEmail());
            cstm.setLong(5, user.getIdRole().getIdRole());
            cstm.setLong(6, user.getIdMunicipio().getId());
            cstm.setString(7, user.getColonia());

            cstm.execute();
            flag = true;
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanUserEnlace user){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_updateComite(?,?,?,?,?,?,?,?)}");
            cstm.setString(1, user.getNombre());
            cstm.setString(2, user.getLastname());
            cstm.setString(3, user.getPassword());
            cstm.setString(4, user.getEmail());
            cstm.setLong(5, user.getIdRole().getIdRole());
            cstm.setLong(6, user.getIdMunicipio().getId());
            cstm.setString(7, user.getColonia());
            cstm.setLong(8, user.getIdUser());

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
}
