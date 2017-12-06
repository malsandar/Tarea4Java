/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

/**
 *
 * @author Julio
 */
public class Crud {

    public boolean agregarLibro(Libro libro) {
        boolean flag = false;
        try {
            Connection c = Conexion.getInstance();
            Statement s = c.createStatement();
            String query = "INSERT INTO LIBROS (CODIGO, ISBN, NOMBRE_LIBRO, NUM_EJEMPLARES, GENERO, TEMA, NOM_AUTOR, NACION_AUTOR, NOM_EDITORIAL, TIPOS_LECTOR) VALUES ('" + libro.getCodigo() + "', '" + libro.getIsnb() + "', '" + libro.getNombreLibro() + "', '" + libro.getNumEjemplares() + "', '" + libro.getGenero() + "', '" + libro.getTema() + "', '" + libro.getNombreAutor() + "', '" + libro.getNacionalidadAutor() + "', '" + libro.getNombreEditorial() + "', '" + libro.getTipoLector() + "')";
            s.executeUpdate(query);
            flag = true;
        } catch (SQLException ex) {
            System.out.println("ERRORS xD");
        }
        return flag;
    }

    public Libro buscarLibro(String codigo) {
        try {
            ResultSet rs = null;
            Connection c = Conexion.getInstance();
            Statement s = c.createStatement();
            String query = "SELECT * FROM LIBROS WHERE CODIGO = '" + codigo + "'";
            rs = s.executeQuery(query);
            if (rs.next()) {
                Libro nuevo = new Libro(Integer.parseInt(rs.getString("CODIGO")), Integer.parseInt(rs.getString("ISBN")), rs.getString("NOMBRE_LIBRO"), Integer.parseInt(rs.getString("NUM_EJEMPLARES")), rs.getString("GENERO").charAt(0), rs.getString("TEMA"), rs.getString("NOM_AUTOR"), rs.getString("NACION_AUTOR"), rs.getString("NOM_EDITORIAL"), rs.getString("TIPOS_LECTOR").charAt(0));

                return nuevo;
            } else {
                return null;
            }

        } catch (SQLException ex) {

        }
        return null;
    }

    public List<Libro> listarLibros() {
        List<Libro> lista = new ArrayList<Libro>();
        try {
            ResultSet rs = null;
            Connection c = Conexion.getInstance();
            Statement s = c.createStatement();
            String query = "SELECT * FROM LIBROS";
            rs = s.executeQuery(query);
            while (rs.next()) {
                //System.out.println("rs -> "+rs.getString("NOMBRE")+" - "+Double.parseDouble(rs.getString("VALOR_CONV")));
                lista.add(new Libro(Integer.parseInt(rs.getString("CODIGO")), Integer.parseInt(rs.getString("ISBN")), rs.getString("NOMBRE_LIBRO"), Integer.parseInt(rs.getString("NUM_EJEMPLARES")), rs.getString("GENERO").charAt(0), rs.getString("TEMA"), rs.getString("NOM_AUTOR"), rs.getString("NACION_AUTOR"), rs.getString("NOM_EDITORIAL"), rs.getString("TIPOS_LECTOR").charAt(0)));
            }
            return lista;

        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean borrarLibro(String codigo) {
        int resultado = buscarLibro(codigo).getCodigo();
        if (resultado != Integer.parseInt(codigo)) {
            System.out.println("No encontré nada :C");
            return false;
        } else {
            try {
                Connection c = Conexion.getInstance();
                Statement s = c.createStatement();
                String query = "DELETE FROM LIBROS WHERE CODIGO = '" + codigo + "'";
                s.executeUpdate(query);
                return true;
            } catch (SQLException ex) {

            }
        }
        return false;
    }

    public boolean modificarLibro(Libro libro) {
        boolean flag = false;
        int resultado = buscarLibro(libro.getCodigo() + "").getCodigo();
        if (resultado == Integer.parseInt(libro.getCodigo() + "")) {
            try {
                Connection c = Conexion.getInstance();
                Statement s = c.createStatement();
                String query = "UPDATE LIBROS SET CODIGO = '" + libro.getCodigo() + "', ISBN= '" + libro.getIsnb() + "', NOMBRE_LIBRO= '" + libro.getNombreLibro() + "', NUM_EJEMPLARES= '" + libro.getNumEjemplares() + "', GENERO= '" + libro.getGenero() + "', TEMA= '" + libro.getTema() + "', NOM_AUTOR= '" + libro.getNombreAutor() + "', NACION_AUTOR= '" + libro.getNacionalidadAutor() + "', NOM_EDITORIAL= '" + libro.getNombreEditorial() + "', TIPOS_LECTOR= '" + libro.getTipoLector() + "' WHERE CODIGO = '"+libro.getCodigo()+"'";
                s.executeUpdate(query);
                flag = true;
            } catch (SQLException ex) {
                System.out.println("ERRORS xD");
            }
        }
        else
        {
            System.out.println("ERRORS2 xD");
        }

        return flag;
    }
}
