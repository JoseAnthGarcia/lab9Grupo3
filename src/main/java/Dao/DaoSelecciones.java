package Dao;

import Bean.Arbitros;
import Bean.Estadios;
import Bean.Partidos;
import Bean.SeleccionesNacionales;

import java.sql.*;
import java.util.ArrayList;

public class DaoSelecciones extends DaoBase{

    public ArrayList<SeleccionesNacionales> listarSelecciones(){

        ArrayList<SeleccionesNacionales> seleccionesNacionalesArrayList = new ArrayList<>();

        String sql = "SELECT * FROM seleccionesnacionales;";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                SeleccionesNacionales seleccion = new SeleccionesNacionales();
                seleccion.setIdSeleccionesNacionales(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));

                Estadios estadio = new Estadios();
                estadio.setIdEstadios(rs.getInt("4"));
                seleccion.setEstadio(estadio);

                seleccionesNacionalesArrayList.add(seleccion);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return seleccionesNacionalesArrayList;
    }

}
