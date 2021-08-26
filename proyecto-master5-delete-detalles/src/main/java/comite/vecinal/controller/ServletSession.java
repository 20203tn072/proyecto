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
        HttpSession session = request.getSession();

        //Matando la sesion
        session.setAttribute("session", null);
        session.invalidate();

        //Rediriguiendo a "/"
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);

        //HttpSession session = request.getSession();
        //if (session.getAttribute("session") != null) {
        //    request.setAttribute("listUsers", new DaoUser().findAll());
        //    request.getRequestDispatcher("/views/user/users.jsp").forward(request, response);
        //} else{
        //    request.getRequestDispatcher("/").forward(request, response);
        //}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        BeanUser beanUser = new BeanUser();
        DaoUser daoUser = new DaoUser();

        beanUser.setEmail(request.getParameter("email"));
        beanUser.setPassword(request.getParameter("password"));

        boolean res = daoUser.createSession(
                beanUser.getEmail(),
                beanUser.getPassword()
        );

        if (res){
            session.setAttribute("session", beanUser);
            request.getRequestDispatcher("views/user/inicio.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("views/user/inicio.jsp").forward(request, response);
        }
    }
}
