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
    public boolean validarString(String input){
        boolean resultado = true;
        boolean resultado2= true;
        if(input.equalsIgnoreCase("")){
            resultado = false;
        }
        try{
            int numero= Integer.parseInt(input);
            resultado2=false;
        }catch (NumberFormatException e){
            resultado2=true;
        }
        boolean resultadoFinal= resultado&&resultado2;


        return resultadoFinal;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("nombre");
        opciones.add("pais");
        DaoArbitros daoArbitros = new DaoArbitros();
        switch (action) {

            case "buscar":
                ArrayList<Arbitros> listaBusqueda = new ArrayList<>();
                String textoBuscar = request.getParameter("textoBuscar");
                if(Integer.parseInt(request.getParameter(("tipo")))==1){
                    listaBusqueda=daoArbitros.busquedaNombre(textoBuscar);
            }
                if(Integer.parseInt(request.getParameter(("tipo")))==2){
                    listaBusqueda=daoArbitros.busquedaPais(textoBuscar);
                }

                request.setAttribute("listaBusqueda", listaBusqueda);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Arbitros/list.jsp");
                requestDispatcher.forward(request, response);
                break;

            case "guardar":
                String nombre = request.getParameter("nombre");
                String pais = request.getParameter("pais");
                boolean nombreB = validarString(nombre);
                boolean nombreExis = false;
                if(daoArbitros.buscarNombre(nombre)){
                    nombreExis = true;
                }
                if(!nombreB || nombreExis){
                    request.setAttribute("nombreB",nombreB);
                    request.setAttribute("nombreExis",nombreExis);
                    RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("Arbitros/form.jsp");
                    requestDispatcher2.forward(request, response);
                }else{

                }

                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoArbitros daoArbitros = new DaoArbitros();
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
                request.setAttribute("listaArbitros",daoArbitros.listarArbitros() );
                request.setAttribute("opciones",opciones );
                view = request.getRequestDispatcher("/Arbitros/list.jsp");
                view.forward(request, response);
                break;
            case "crear":
                request.setAttribute("paises",paises);
                view = request.getRequestDispatcher("Arbitros/list.jsp");
                view.forward(request, response);
                break;


            case "borrar":
                /*
                Inserte su código aquí
                 */
                break;
        }
    }
}
