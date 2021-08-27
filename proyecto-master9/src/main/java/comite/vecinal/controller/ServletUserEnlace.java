package comite.vecinal.controller;

import com.google.gson.Gson;
import comite.vecinal.model.colonia.BeanColonia;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import comite.vecinal.model.user.DaoUser;
import comite.vecinal.model.userEnlace.BeanUserEnlace;
import comite.vecinal.model.userEnlace.DaoUserEnlace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletUserEnlace", value = {"/ServletUser2", "/readUsers2","/readEnlace2", "/createUser2", "/getUserById2", "/findById2", "/updateUser2", "/deleteUser2" })

public class ServletUserEnlace extends HttpServlet {

        Logger logger = LoggerFactory.getLogger(comite.vecinal.controller.ServletUserEnlace.class);
        BeanUserEnlace beanUserEnlace = new BeanUserEnlace();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("listUsers2", new DaoUserEnlace().findAll());
            request.getRequestDispatcher("/views/enlace/users.jsp").forward(request, response);
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
                    String lastname = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    int municipio = Integer.parseInt(request.getParameter("municipio"));
                    String colonia = request.getParameter("colonia");
                    int role = Integer.parseInt(request.getParameter("role"));


                    BeanRole beanRole = new BeanRole(role,"");
                    BeanMunicipio beanMunicipio= new BeanMunicipio(municipio,"");
                    BeanUserEnlace beanUserEnlace = new BeanUserEnlace(0, name, lastname, password, email, 0, beanRole,beanMunicipio, colonia);

                    if(new DaoUserEnlace().create(beanUserEnlace)){
                        request.setAttribute("message", "Usuario registrado correctamente");
                    } else {
                        request.setAttribute("message", "Usuario no registrado");
                    }

                    doGet(request, response);
                    break;

                case "getUserById":
                    // do something
                    long idUser = Long.parseLong(request.getParameter("id"));
                    request.setAttribute("user", new DaoUserEnlace().findById(idUser));
                    request.getRequestDispatcher("/views/enlace/update.jsp").forward(request, response);
                    break;

                case "findById":
                    // do something
                    try {
                        Gson gson = new Gson();
                        long id3 = Long.parseLong(request.getParameter("id"));

                        map.put("user", new DaoUserEnlace().findById(id3));

                        response.setStatus(200);
                    }catch(Exception e){
                        response.setStatus(400);
                        logger.error("Usuario no encontrado.");
                    }
                    write(response, map);
                    break;

                case "update":
                    // do something

                    String name1 = request.getParameter("name") != null ? request.getParameter("name") : "";
                    String lastname1 = request.getParameter("lastname");
                    long id1 = Long.parseLong(request.getParameter("id"));
                    String email1 = request.getParameter("email");
                    String password1 = request.getParameter("password");
                    int municipio1 = Integer.parseInt(request.getParameter("municipio"));
                    String colonia1 = request.getParameter("colonia");
                    int role1 = Integer.parseInt(request.getParameter("role"));



                    BeanRole beanRole1 = new BeanRole(role1,"");
                    BeanMunicipio beanMunicipio1= new BeanMunicipio(municipio1,"");
                    BeanUserEnlace beanUserEnlace1 = new BeanUserEnlace(id1, name1, lastname1, password1, email1, 0, beanRole1,beanMunicipio1, colonia1);

                    if(new DaoUserEnlace().update(beanUserEnlace1)){
                        request.setAttribute("message", "Usuario modificado correctamente");
                    } else {
                        request.setAttribute("message", "Usuario no modificado");
                    }

                    doGet(request, response);
                    break;


                case "delete":
                    // do something
                    long id2 = Long.parseLong(request.getParameter("id"));
                    if(new DaoUserEnlace().delete(id2)){
                        request.setAttribute("message", "Usuario eliminado correctamente");
                    } else {
                        request.setAttribute("message", "Usuario no eliminado");
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
