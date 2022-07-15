package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "libro")
public class LibroModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String titulo;
    private String autor;
    private String descripcion;
    private String imagen;
    private Integer stock;
    private Long precio;
    private boolean destacado;

    public LibroModel() {
    }

    public LibroModel(Long id, String titulo, String autor, String descripcion, String imagen, Integer stock, Long precio, boolean destacado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.stock = stock;
        this.precio = precio;
        this.destacado = destacado;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    public String getImagen(){
        return imagen;
    }
    
    public void setStock(Integer stock){
        this.stock = stock;
    }
    public Integer getStock(){
        return stock;
    }

    public void setPrecio(Long precio){
        this.precio = precio;
    }
    public Long getPrecio(){
        return precio;
    }
    
    public void setDestacado(boolean destacado){
        this.destacado = destacado;
    }
    public boolean getDestacado(){
        return destacado;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", imagen='" + getImagen() + "'" +
            ", stock='" + getStock() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", destacado='" + getDestacado() + "'" +
            "}";
    }

}