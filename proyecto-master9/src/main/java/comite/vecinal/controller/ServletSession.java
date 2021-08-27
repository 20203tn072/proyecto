package comite.vecinal.controller;

import comite.vecinal.model.user.BeanUser;
import comite.vecinal.model.user.DaoUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSession", urlPatterns = {"/login","/logout"})
public class ServletSession extends HttpServlet {
    /**
     * Cierre de la sesion de la aplicacion.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Obtener la sesion
        //HttpSession session = request.getSession();

        //Matando la sesion
        //session.setAttribute("session", null);
        //session.invalidate();

        //Rediriguiendo a "/"
        //request.getRequestDispatcher("/views/login.jsp").forward(request, response);

        /*
        HttpSession session = request.getSession();
        if (session.getAttribute("session") != null) {
            request.setAttribute("listUsers", new DaoUser().findAll());
            request.getRequestDispatcher("/views/user/users.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/").forward(request, response);
        }*/
        String action = request.getParameter("action");


        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        int idRol = Integer.parseInt(request.getParameter("Rol"));
        BeanUser beanUser = new BeanUser(0,"","",pass,email,0,null,null);

        if (new DaoUser().createSession(email,pass,idRol)) {
            switch (idRol){
                case 1:
                    request.getRequestDispatcher("/views/user/users.jsp").forward(request, response);
                    break;
                case 2:
                    request.getRequestDispatcher("/views/enlace/users.jsp").forward(request, response);
                    break;

                case 3:
                    request.getRequestDispatcher("/views/presidente/users.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("/views/login.jsp").forward(request, response);

                    break;
            }
        } else {
            request.setAttribute("message", "Usuario no encontrado");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        BeanUser beanUser = new BeanUser();
        DaoUser daoUser = new DaoUser();
        int idRol;

        beanUser.setEmail(request.getParameter("email"));
        beanUser.setPassword(request.getParameter("password"));
        idRol=Integer.parseInt(request.getParameter("Rol"));

        boolean res = daoUser.createSession(
                beanUser.getEmail(),
                beanUser.getPassword(),
                idRol
        );

        if (res){
            switch (idRol){
                case 1:
                    session.setAttribute("session", beanUser);
                    request.getRequestDispatcher("/views/user/inicio.jsp").forward(request, response);
                    break;
                case 2:
                    session.setAttribute("session", beanUser);
                    request.getRequestDispatcher("/views/enlace/inicio.jsp").forward(request, response);
                    break;

                case 3:
                    session.setAttribute("session", beanUser);
                    request.getRequestDispatcher("/views/presidente/inicio.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
            session.setAttribute("session", beanUser);
            request.getRequestDispatcher("views/user/inicio.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
