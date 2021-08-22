package comite.vecinal.controller;

import com.google.gson.Gson;
import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import comite.vecinal.model.user.DaoUser;
import comite.vecinal.model.user.BeanUser;

@WebServlet(name = "ServletUser", value = {"/ServletUser", "/readUsers", "/createUser", "/getUserById", "/findById", "/updateUser", "/deleteUser" })
public class ServletUser extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletUser.class);
    BeanUser beanUser = new BeanUser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUsers", new DaoUser().findAll());
        request.getRequestDispatcher("/views/user/users.jsp").forward(request, response);
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
                int role = Integer.parseInt(request.getParameter("role"));
                int municipio = Integer.parseInt(request.getParameter("municipio"));

                BeanRole beanRole = new BeanRole(role,"");
                BeanMunicipio beanMunicipio = new BeanMunicipio(municipio,"");
                BeanUser beanUser = new BeanUser(0, name, lastname, password, email, 0, beanMunicipio, beanRole);

                if(new DaoUser().create(beanUser)){
                    request.setAttribute("message", "Usuario registrado correctamente");
                } else {
                    request.setAttribute("message", "Usuario no registrado");
                }

                doGet(request, response);
                break;

            case "getUserById":
                // do something
                long idUser = Long.parseLong(request.getParameter("id"));
                request.setAttribute("user", new DaoUser().findById(idUser));
                request.getRequestDispatcher("/views/user/update.jsp").forward(request, response);
                break;
            case "findById":
                // do something
                try {
                    Gson gson = new Gson();
                    long id5 = Long.parseLong(request.getParameter("id"));

                    map.put("user", new DaoUser().findById(id5));

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
                String password1 = request.getParameter("password");
                String email1 = request.getParameter("email");
                int role1 = Integer.parseInt(request.getParameter("role"));
                int municipio1 = Integer.parseInt(request.getParameter("municipio"));

                BeanRole beanRole1 = new BeanRole(role1,"");
                BeanMunicipio beanMunicipio1 = new BeanMunicipio(municipio1,"");
                BeanUser beanUser1 = new BeanUser(id1, name1, lastname1, password1, email1, 0, beanMunicipio1, beanRole1);

                if(new DaoUser().update(beanUser1)){
                    request.setAttribute("message", "Usuario modificado correctamente");
                } else {
                    request.setAttribute("message", "Usuario no modificado");
                }

                doGet(request, response);
                break;


            case "delete":
                // do something
                long id2 = Long.parseLong(request.getParameter("id"));
                if(new DaoUser().delete(id2)){
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
