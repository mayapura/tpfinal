package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.LibroModel;
import com.example.demo.repositories.LibroRepositoy;
@Service
public class LibroService {

    @Autowired
    LibroRepositoy libroRepository;
    public ArrayList<LibroModel> obtenerLibros(){
        return (ArrayList<LibroModel>) libroRepository.findAll();
    }

    public LibroModel guardarLibro(LibroModel libro){
        return libroRepository.save(libro);
    }

    public Optional<LibroModel> obtenerPorId(Long id){
        return libroRepository.findById(id);
    }

    public ArrayList<LibroModel> obtenerDestacado(boolean destacado){
        return libroRepository.findByDestacado(destacado);
    }
    
    public boolean eliminarLibro(Long id){
        try{
            libroRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
