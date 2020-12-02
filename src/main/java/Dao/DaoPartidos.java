package Dao;

import Bean.Arbitros;
import Bean.Estadios;
import Bean.Partidos;
import Bean.SeleccionesNacionales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DaoPartidos extends DaoBase{

    public ArrayList<Partidos> listaDePartidos(){

        ArrayList<Partidos> partidos = new ArrayList<>();

        String sql = "SELECT * FROM partidos p\n" +
                "INNER JOIN seleccionesnacionales sn2\n" +
                "ON p.seleccionVisitante= sn2.idSeleccionesNacionales\n" +
                "INNER JOIN seleccionesnacionales sn1\n" +
                "ON p.seleccionLocal= sn1.idSeleccionesNacionales\n" +
                "INNER JOIN estadios e ON sn1.estadios_idEstadios=e.idEstadios\n" +
                "INNER JOIN arbitros a ON p.arbitro=a.idArbitros;";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Partidos partido = new Partidos();
                partido.setIdPartido(rs.getInt(1));
                partido.setFecha(rs.getString("p.fecha"));
                partido.setNumeroJornada(rs.getInt("p.numeroJornada"));

                SeleccionesNacionales seleccionLocal = new SeleccionesNacionales();
                seleccionLocal.setIdSeleccionesNacionales(rs.getInt("sn1.idSeleccionesNacionales"));
                seleccionLocal.setNombre(rs.getString("sn1.nombre"));
                Estadios estadio = new Estadios();
                estadio.setIdEstadios(rs.getInt("e.idEstadios"));
                estadio.setNombre(rs.getString("e.nombre"));
                seleccionLocal.setEstadio(estadio);
                partido.setSeleccionLocal(seleccionLocal);

                SeleccionesNacionales seleccionVisitante = new SeleccionesNacionales();
                seleccionVisitante.setIdSeleccionesNacionales(rs.getInt("sn2.idSeleccionesNacionales"));
                seleccionVisitante.setNombre(rs.getString("sn2.nombre"));
                partido.setSeleccionVisitante(seleccionVisitante);

                Arbitros arbitro = new Arbitros();
                arbitro.setIdArbitros(rs.getInt("a.idArbitros"));
                arbitro.setNombre(rs.getString("a.nombre"));
                partido.setArbitro(arbitro);

                partidos.add(partido);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return partidos;
    }

    public void crearPartido(Partidos partidos){

        /*
                Inserte su código aquí
                 */
    }


}
