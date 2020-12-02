package Dao;

import Bean.Arbitros;

import java.sql.*;
import java.util.ArrayList;

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
                arbitro.setPais(rs.getString(3));


                arbitros.add(arbitro);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arbitros;
    }

    public void crearArbitro(Arbitros arbitros) {

        String sql = "INSERT INTO arbitros(nombre, pais)\n" +
                "VALUES (?, ?);";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, arbitros.getNombre());
            pstmt.setString(2, arbitros.getPais());

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Arbitros> busquedaPais(String pais) {

        ArrayList<Arbitros> arbitros = new ArrayList<>();

        String sql = "SELECT * FROM sw1lab8.arbitros where lower(pais) like ?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,pais + "%");


            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {
                    Arbitros arbitros1 = new Arbitros();
                    arbitros1.setIdArbitros(rs.getInt(1));
                    arbitros1.setNombre(rs.getString(2));
                    arbitros1.setPais(rs.getString(3));
                    arbitros.add(arbitros1);

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return arbitros;
    }

    public ArrayList<Arbitros> busquedaNombre(String nombre) {

        ArrayList<Arbitros> arbitros = new ArrayList<>();
        String sql = "SELECT * FROM sw1lab8.arbitros where lower(nombre) like ?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,nombre + "%");


            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {
                    Arbitros arbitros1 = new Arbitros();
                    arbitros1.setIdArbitros(rs.getInt(1));
                    arbitros1.setNombre(rs.getString(2));
                    arbitros1.setPais(rs.getString(3));
                    arbitros.add(arbitros1);

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arbitros;
    }

    public Arbitros buscarArbitro(int id){

        Arbitros arbitros = new Arbitros();
        String sql = "SELECT * FROM sw1lab8.arbitros where idArbitros = ?;";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    arbitros.setIdArbitros(rs.getInt(1));
                    arbitros.setNombre(rs.getString(2));
                    arbitros.setPais(rs.getString(3));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arbitros;
    }

    public void borrarArbitro(int id){

        try (Connection conn = getConnection();
              PreparedStatement pstmt = conn.prepareStatement("DELETE FROM arbitros WHERE idArbitros = ?");) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean buscarNombre(String nombre) {
        boolean encontrado = false;

        String sql = "SELECT * FROM arbitros WHERE nombre = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    encontrado = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return encontrado;
    }

}
