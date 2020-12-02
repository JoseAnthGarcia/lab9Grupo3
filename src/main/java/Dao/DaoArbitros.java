package Dao;

import Bean.Arbitros;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoArbitros extends DaoBase {
    public ArrayList<Arbitros> listarArbitros() {

        ArrayList<Arbitros> arbitros = new ArrayList<>();

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();) {


            ResultSet rs = stmt.executeQuery("SELECT * FROM sw1lab8.arbitros;");

            while (rs.next()) {
                Arbitros arbitro = new Arbitros();
                arbitro.setIdArbitros(rs.getInt(1));
                arbitro.setNombre(rs.getString(2));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arbitros;
    }

    public void crearArbitro(Arbitros arbitros) {

        /*
                Inserte su código aquí
                 */
    }

    public ArrayList<Arbitros> busquedaPais(String pais) {

        ArrayList<Arbitros> arbitros = new ArrayList<>();
        /*
                Inserte su código aquí
                 */
        return arbitros;
    }

    public ArrayList<Arbitros> busquedaNombre(String nombre) {

        ArrayList<Arbitros> arbitros = new ArrayList<>();
        /*
                Inserte su código aquí
                 */
        return arbitros;
    }

    public Arbitros buscarArbitro(int id){

        Arbitros arbitros = new Arbitros();
        /*
                Inserte su código aquí
                 */
        return arbitros;
    }

    public void borrarArbitro(int id){

        /*
                Inserte su código aquí
                 */
    }

}
