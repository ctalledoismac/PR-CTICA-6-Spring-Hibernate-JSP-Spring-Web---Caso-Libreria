package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Libro;

public interface LibroService {

    List<Libro> findAll();

    Libro findOne(int id);

    void add(Libro libro);

    void add(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
             Date fechaPublicacion, String descripcion, String tipoPasta, String ISBN, int numEjemplares,
             String portada, String presentacion, double precio, int idAutor, int idCategoria);

    void up(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
            Date fechaPublicacion, String descripcion, String tipoPasta, String ISBN, int numEjemplares,
            String portada, String presentacion, double precio, int idAutor, int idCategoria);

    void update(Libro libro);

    void delete(int id);

    List<Libro> findAll(String busqueda);
}
