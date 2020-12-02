package Controller;

import Bean.Arbitros;
import Dao.DaoArbitros;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArbitrosServlet", urlPatterns = {"/ArbitrosServlet"})
public class ArbitrosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("nombre");
        opciones.add("pais");

        switch (action) {

            case "buscar":
                /*
                Inserte su código aquí
                 */
                break;

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
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Peru");
        paises.add("Chile");
        paises.add("Argentina");
        paises.add("Paraguay");
        paises.add("Uruguay");
        paises.add("Colombia");
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("nombre");
        opciones.add("pais");

        switch (action) {
            case "lista":
                /*
                Inserte su código aquí
                 */
                view = request.getRequestDispatcher("/Arbitros/list.jsp");
                view.forward(request, response);
                break;
            case "crear":
                /*
                Inserte su código aquí
                 */

                break;
            case "borrar":
                /*
                Inserte su código aquí
                 */
                break;
        }
    }
}
