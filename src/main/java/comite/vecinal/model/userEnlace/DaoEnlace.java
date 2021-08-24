package comite.vecinal.model.userEnlace;

import comite.vecinal.model.colonia.BeanColonia;
import comite.vecinal.model.departamento.BeanDepartamento;
import comite.vecinal.model.incidente.BeanIncidente;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import comite.vecinal.model.userEnlace.BeanEnlace;
import comite.vecinal.model.userEnlace.DaoEnlace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import comite.vecinal.service.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEnlace {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoEnlace.class);

    public List<BeanEnlace> findAll(){
        List<BeanEnlace> listUsers2 = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN incidentes AS P ON U.idincidente = P.id INNER JOIN deps AS R ON U.iddep = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll2}");
            rs = cstm.executeQuery();

            while(rs.next()){
                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                BeanColonia colonia = new BeanColonia();
                BeanDepartamento departamento = new BeanDepartamento();
                BeanEnlace user = new BeanEnlace();
                BeanIncidente incidente = new BeanIncidente();

                role.setIdRole(rs.getInt("idRole"));
                role.setNameRole(rs.getString("nameRole"));

                municipio.setId(rs.getInt("idMun"));
                municipio.setNombre(rs.getString("nombreMun"));

                colonia.setIdColonia(rs.getInt("IdColonia"));
                colonia.setNombre(rs.getString("NombreCol"));

                departamento.setIdDepartamento(rs.getInt("IdDepto"));
                departamento.setNombre(rs.getString("NombreDepto"));

                incidente.setIdIncidente(rs.getInt("IdIncidente"));
                incidente.setNombre(rs.getString("Encabezado"));
                incidente.setDescripcion(rs.getString("Descripcion"));
                incidente.setFechaInicio(rs.getString("fecha_incidente"));
                incidente.setFechaFin(rs.getString("fecha_fin"));
                incidente.setStatus(rs.getInt("status"));

                user.setIdEnlace(rs.getLong("idUser"));
                user.setNombre(rs.getString("nombreUser"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));

                colonia.setIdMunicipio(municipio);

                incidente.setIdDepartamento(departamento);
                incidente.setIdEnlace(user);

                user.setBeanColonia(colonia);
                user.setBeanIncidente(incidente);
                user.setBeanRole(role);

                listUsers2.add(user);
                listUsers2.add(colonia);
                listUsers2.add(incidente);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listUsers2;
    }

    public BeanEnlace findById(long idUser){
        BeanEnlace user = null;
        try {
            // SELECT * FROM usuario AS U INNER JOIN municipio AS M ON U.idMunicipio = M.IdMun INNER JOIN roles AS R ON U.idRoles = R.idRole;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM usuario AS U INNER JOIN municipio AS M ON U.idMunicipio = M.IdMun INNER JOIN roles AS R ON U.idRoles = R.idRole WHERE U.idUser = ?");
            cstm.setLong(1, idUser);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanRole role = new BeanRole();
                BeanMunicipio municipio = new BeanMunicipio();
                user = new BeanEnlace();

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

    public boolean create(BeanEnlace user){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create2(?,?,?,?,?,?)}");
            cstm.setString(1, user.getNombre());
            cstm.setString(2, user.getLastname());
            cstm.setString(3, user.getPassword());
            cstm.setString(4, user.getEmail());
            cstm.setLong(5, user.getIdMunicipio().getId());
            cstm.setLong(6, user.getIdRole().getIdRole());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanEnlace user){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update2(?,?,?,?,?,?,?)}");
            cstm.setString(1, user.getNombre());
            cstm.setString(2, user.getLastname());
            cstm.setString(3, user.getPassword());
            cstm.setString(4, user.getEmail());
            cstm.setLong(5, user.getIdMunicipio().getId());
            cstm.setInt(6, user.getIdRole().getIdRole());
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
            cstm = con.prepareCall("{call sp_delete2(?)}");
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
