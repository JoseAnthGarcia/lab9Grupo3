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

    public boolean validarString(String input){
        boolean valido = true;
        if(input.equals("")){
            valido=false;
        }
        return valido;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        DaoPartidos daoPartidos = new DaoPartidos();

        switch (action) {

            case "guardar":
                String jornada = request.getParameter("jornada");
                String fecha = request.getParameter("fecha");
                String local = request.getParameter("local");
                String visitante = request.getParameter("visitante");
                String arbitro = request.getParameter("arbitro");

                int localInt = Integer.parseInt(local);
                int visitanteInt = Integer.parseInt(visitante);

                boolean mismoEquipo = false;
                if(localInt==visitanteInt){
                    mismoEquipo=true;
                }

                boolean exitPartido = daoPartidos.bucarPartido(localInt, visitanteInt);


                if(validarString(jornada) &&
                validarString(fecha) &&
                        validarString(local) &&
                        validarString(visitante) &&
                        validarString(arbitro) &&
                        !mismoEquipo && !exitPartido
                ){
                    Partidos partido = new Partidos();
                    partido.setFecha(fecha);
                    partido.setNumeroJornada(Integer.parseInt(jornada));
                    SeleccionesNacionales localS = new SeleccionesNacionales();
                    localS.setIdSeleccionesNacionales(localInt);
                    partido.setSeleccionLocal(localS);
                    SeleccionesNacionales visitanteS = new SeleccionesNacionales();
                    visitanteS.setIdSeleccionesNacionales(visitanteInt);
                    partido.setSeleccionVisitante(visitanteS);
                    Arbitros arbitroP = new Arbitros();
                    arbitroP.setIdArbitros(Integer.parseInt(arbitro));
                    partido.setArbitro(arbitroP);
                    daoPartidos.crearPartido(partido);
                    response.sendRedirect(request.getContextPath()+"/PartidosServlet");
                }else{
                    response.sendRedirect(request.getContextPath()+"/PartidosServlet?action=crear");
                }

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
