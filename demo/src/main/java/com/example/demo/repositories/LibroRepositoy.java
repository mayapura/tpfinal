package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LibroModel;

@Repository
public interface LibroRepositoy extends CrudRepository<LibroModel,Long> {
    public abstract ArrayList<LibroModel> findByDestacado(boolean destacado);
}
