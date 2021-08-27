package comite.vecinal.controller;

import com.google.gson.Gson;
import comite.vecinal.model.departamento.BeanDepartamento;
import comite.vecinal.model.incidente.BeanIncidente;
import comite.vecinal.model.incidente.DaoIncidente;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import comite.vecinal.model.user.BeanUser;
import comite.vecinal.model.user.DaoUser;
import comite.vecinal.model.userEnlace.BeanUserEnlace;
import comite.vecinal.model.userEnlace.DaoUserEnlace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletIncidente", value = {"/ServletIncidente", "/readIncidents", "/createIncidents", "/getIncidentById", "/updateIncident", "/deleteIncident" })
public class ServletIncidente extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletIncidente.class);
    BeanIncidente beanIncidente = new BeanIncidente();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listIncidents", new DaoIncidente().findAll());
        request.getRequestDispatcher("/views/presidente/incidentes.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map map = new HashMap();
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch(action){
            case "create":
                // do something
                String name = request.getParameter("name") != null ? request.getParameter("name") : "";
                String descripcion = request.getParameter("descripcion");
                long idUser =Long.parseLong(request.getParameter("id"));
                long iddepartamento =Long.parseLong(request.getParameter("iddepartamento"));


                BeanUser beanUser = new BeanUser(idUser,"","","","",0,null,null);
                BeanDepartamento beanDepartamento = new BeanDepartamento(iddepartamento,"");
                BeanIncidente beanIncidente = new BeanIncidente(0, name, descripcion,0, beanUser, beanDepartamento);

                if(new DaoIncidente().create(beanIncidente)){
                    request.setAttribute("message", "Usuario registrado correctamente");
                } else {
                    request.setAttribute("message", "Usuario no registrado");
                }

                doGet(request, response);
                break;

            case "getIncidentById":
            // do something
            long idIncident = Long.parseLong(request.getParameter("id"));
            request.setAttribute("incident", new DaoIncidente().findById(idIncident));
            request.getRequestDispatcher("/views/user/update.jsp").forward(request, response);
            break;

            case "findById":
                // do something
                try {
                    Gson gson = new Gson();
                    long id3 = Long.parseLong(request.getParameter("id"));

                    map.put("user", new DaoIncidente().findById(id3));

                    response.setStatus(200);
                }catch(Exception e){
                    response.setStatus(400);
                    logger.error("Usuario no encontrado.");
                }
                write(response, map);
                break;

            case "update":
                // do something

                long idIncidente1=Long.parseLong(request.getParameter("id"));
                String name1 = request.getParameter("name") != null ? request.getParameter("name") : "";
                String descripcion1 = request.getParameter("descripcion");
                long idUser1=Long.parseLong(request.getParameter("iduser"));
                long iddepartamento1=Long.parseLong(request.getParameter("iddepartamento"));


                BeanUser beanUser1 = new BeanUser(idUser1,"","","","",0,null,null);
                BeanDepartamento beanDepartamento1 = new BeanDepartamento(iddepartamento1,"");
                BeanIncidente beanIncidente1 = new BeanIncidente(0, name1, descripcion1,0, beanUser1, beanDepartamento1);

                if(new DaoIncidente().update(beanIncidente1)){
                    request.setAttribute("message", "Incidente modificado correctamente");
                } else {
                    request.setAttribute("message", "Incidente no modificado");
                }

                doGet(request, response);
                break;

            case "delete":
                // do something
                long id2 = Long.parseLong(request.getParameter("id"));
                long depto = Long.parseLong(request.getParameter("Departamento"));
                if(new DaoIncidente().delete(id2,depto)){
                    request.setAttribute("message", "Incidente terminado correctamente");
                } else {
                    request.setAttribute("message", "Incidente no terminado");
                }
                doGet(request, response);
                break;

            default:
                // no supported
                break;
        }
    }
    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));

    }
}

