package com.distribuida.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dto.LibroService;
import com.distribuida.entities.Libro;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Libro> libros = libroService.findAll();
        model.addAttribute("libros", libros);
        return "libros";
    }

    @GetMapping("/findOne")
    public String findOne(
        @RequestParam("idLibro") @Nullable Integer idLibro,
        @RequestParam("opcion") @Nullable Integer opcion,
        Model model
    ) {
        if (idLibro != null) {
            Libro libro = libroService.findOne(idLibro);
            model.addAttribute("libro", libro);
        }

        if (opcion == 1) {
            return "libros-add";
        } else {
            return "libros-del";
        }
    }

    @PostMapping("/add")
    public String add(
        @RequestParam("idLibro") @Nullable Integer idLibro,
        @RequestParam("titulo") @Nullable String titulo,
        @RequestParam("editorial") @Nullable String editorial,
        @RequestParam("numPaginas") @Nullable Integer numPaginas,
        @RequestParam("edicion") @Nullable String edicion,
        @RequestParam("idioma") @Nullable String idioma,
        @RequestParam("fechaPublicacion") @Nullable Date fechaPublicacion,
        @RequestParam("descripcion") @Nullable String descripcion,
        @RequestParam("tipoPasta") @Nullable String tipoPasta,
        @RequestParam("ISBN") @Nullable String ISBN,
        @RequestParam("numEjemplares") @Nullable Integer numEjemplares,
        @RequestParam("portada") @Nullable String portada,
        @RequestParam("presentacion") @Nullable String presentacion,
        @RequestParam("precio") @Nullable Double precio,
        @RequestParam("idcategoria") @Nullable Integer idCategoria,
        @RequestParam("idautor") @Nullable Integer idAutor,
        Model model
    ) {
        if (idLibro == null) {
            libroService.add(
                0, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion,
                descripcion, tipoPasta, ISBN, numEjemplares, portada, presentacion,
                precio, idCategoria, idAutor
            );
        } else {
            libroService.up(
                idLibro, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion,
                descripcion, tipoPasta, ISBN, numEjemplares, portada, presentacion,
                precio, idCategoria, idAutor
            );
        }

        return "redirect:/libros/findAll";
    }

    @GetMapping("/del")
    public String delete(@RequestParam("idLibro") @Nullable Integer idLibro) {
        libroService.delete(idLibro);
        return "redirect:/libros/findAll";
    }
}
