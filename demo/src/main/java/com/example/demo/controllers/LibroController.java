package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LibroModel;
import com.example.demo.services.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private static final Log LOGGER = LogFactory.getLog(LibroController.class);

    @Autowired
    LibroService libroService;
    @CrossOrigin
    @GetMapping()
    public ArrayList<LibroModel> obtenerLibros(){
        LOGGER.info("CONTROLLER : LibroController with /libros invoke the get method");
		LOGGER.info("METHOD : obtenerLibros()");
        return libroService.obtenerLibros();

    }
    @CrossOrigin
    @PostMapping()
    public LibroModel guardarLibro(@RequestBody LibroModel libro){
		LOGGER.info("CONTROLLER : OfficeController with /libros/save invoke the post method");
		LOGGER.info("METHOD :  guardarLibro() -- PARAMS: office'"+libro+"'");
        return this.libroService.guardarLibro(libro);
    }

    @CrossOrigin
    @GetMapping(path =  "/{id}")
    public Optional<LibroModel>obtenerLibroPorId(@PathVariable("id") Long id){
        return this.libroService.obtenerPorId(id);
    }
    @CrossOrigin
    @GetMapping("/query")
    public ArrayList<LibroModel> obtenerLibroDestacado(@RequestParam("destacado") boolean destacado){
        return this.libroService.obtenerDestacado(destacado);
    }
    @CrossOrigin
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.libroService.eliminarLibro(id);
        if(ok){
            return "Se eliminó el libro con id" + id;
        }else{
            return "No pudo eliminar el libro con id"+ id;
        }
    }
}
