/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Crud;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

/**
 *
 * @author Julio
 */
public class Registro {
    Crud crud;
    public Registro() {
        this.crud = new Crud();
    }
    
    public List<Libro> listar(){
        return this.crud.listarLibros();
    }
    
    public Libro buscar(String codigo){
        return this.crud.buscarLibro(codigo);
    }
    
    public boolean borrar(String codigo){
        return this.crud.borrarLibro(codigo);
    }
    
    public boolean agregar(int codigo, int isbn, String libro,int ejemplares,char generoFinal,String tema,String autor,String nacionalidad,String editorial,char lectorFinal){
        Libro nuevo = new Libro(codigo, isbn, libro, ejemplares,generoFinal, tema, autor, nacionalidad, editorial, lectorFinal);
        return this.crud.agregarLibro(nuevo);
    }
    
    public boolean modificar(int codigo, int isbn, String libro,int ejemplares,char generoFinal,String tema,String autor,String nacionalidad,String editorial,char lectorFinal){
        Libro nuevo = new Libro(codigo, isbn, libro, ejemplares,generoFinal, tema, autor, nacionalidad, editorial, lectorFinal);
        return this.crud.modificarLibro(nuevo);
    }
}
