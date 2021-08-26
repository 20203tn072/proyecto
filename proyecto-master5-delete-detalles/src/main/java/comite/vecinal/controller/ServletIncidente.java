package comite.vecinal.controller;

import comite.vecinal.model.incidente.BeanIncidente;
import comite.vecinal.model.incidente.DaoIncidente;
import comite.vecinal.model.user.DaoUser;
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

    }
}

