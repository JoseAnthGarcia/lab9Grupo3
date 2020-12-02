package Controller;

import Bean.Arbitros;
import Bean.Partidos;
import Bean.SeleccionesNacionales;
import Dao.DaoArbitros;
import Dao.DaoPartidos;
import Dao.DaoSelecciones;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PartidosServlet", urlPatterns = {"/PartidosServlet", ""})
public class PartidosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        switch (action) {

            case "guardar":
                /*
                Inserte su código aquí
                 */
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        DaoPartidos daoPartidos = new DaoPartidos();
        DaoSelecciones daoSelecciones = new DaoSelecciones();
        DaoArbitros daoArbitros = new DaoArbitros();

        switch (action) {
            case "lista":
                ArrayList<Partidos> partidos = daoPartidos.listaDePartidos();
                request.setAttribute("partidosLista",partidos);
                view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
                break;
            case "crear":
                ArrayList<SeleccionesNacionales> selecciones = daoSelecciones.listarSelecciones();
                request.setAttribute("selecciones", selecciones);

                ArrayList<Arbitros> arbitros = daoArbitros.listarArbitros();
                request.setAttribute("arbitros", arbitros);

                view = request.getRequestDispatcher("/Partidos/form.jsp");
                view.forward(request, response);
                break;

        }

    }
}
