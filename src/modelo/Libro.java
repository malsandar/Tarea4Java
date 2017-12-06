/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Julio
 */
public class Libro {
    private int codigo;
    private int isnb;
    private String nombreLibro;
    private int numEjemplares;
    private char genero;
    private String tema;
    private String nombreAutor;
    private String nacionalidadAutor;
    private String nombreEditorial;
    private char tipoLector;

    public Libro() {
    }

    
    public Libro(int codigo, int isnb, String nombreLibro, int numEjemplares, char genero, String tema, String nombreAutor, String nacionalidadAutor, String nombreEditorial, char tipoLector) {
        this.codigo = codigo;
        this.isnb = isnb;
        this.nombreLibro = nombreLibro;
        this.numEjemplares = numEjemplares;
        this.genero = genero;
        this.tema = tema;
        this.nombreAutor = nombreAutor;
        this.nacionalidadAutor = nacionalidadAutor;
        this.nombreEditorial = nombreEditorial;
        this.tipoLector = tipoLector;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIsnb() {
        return isnb;
    }

    public void setIsnb(int isnb) {
        this.isnb = isnb;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidadAutor() {
        return nacionalidadAutor;
    }

    public void setNacionalidadAutor(String nacionalidadAutor) {
        this.nacionalidadAutor = nacionalidadAutor;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public char getTipoLector() {
        return tipoLector;
    }

    public void setTipoLector(char tipoLector) {
        this.tipoLector = tipoLector;
    }
    
    
    
    
}
