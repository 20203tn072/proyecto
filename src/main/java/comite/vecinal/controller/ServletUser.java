package comite.vecinal.controller;

import comite.vecinal.model.municipio.BeanMunicipio;
import comite.vecinal.model.role.BeanRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import comite.vecinal.model.user.DaoUser;
import comite.vecinal.model.user.BeanUser;

@WebServlet(name = "ServletUser", value = "/ServletUser")
public class ServletUser extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletUser.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUsers", new DaoUser().findAll());
        request.getRequestDispatcher("/views/user/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("user", new DaoUser().findById(id));
                request.getRequestDispatcher("/views/user/update.jsp").forward(request, response);
                break;
            case "update":
                // do something
                String name1 = request.getParameter("name") != null ? request.getParameter("name") : "";
                String lastname1 = request.getParameter("lastname");
                long id1 = Long.parseLong(request.getParameter("idUser"));
                String email1 = request.getParameter("email");
                String password1 = request.getParameter("password");
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
                if (new DaoUser().delete(Integer.parseInt(request.getParameter("idUser")))){
                    request.setAttribute("message", "Se ha eliminado correctamente");
                }else{
                    logger.error("No se ha eliminado correctamente");
                }
                break;

            default:
                //no supported
                request.getRequestDispatcher("/").forward(request, response);
                break;
        }
    }
}

