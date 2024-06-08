package com.LiterAlura.LiterAlura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne()
    private Autor autor;

    private String idiomas;
    private Integer numeroDeDescargas;

    public Libro() {

    }

    public Libro(DatosLibros datosLibros, Autor autor) {
        this.titulo = datosLibros.titulo();
        this.autor = autor;
        this.idiomas = datosLibros.idiomas().get(0);
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        return "********** LIBRO **********" + '\n' +
                "Titulo= " + titulo + '\n' +
                "Autor= " + autor.getNombre() + '\n' +
                "Idioma= " + idiomas + '\n' +
                "Número de descargas= " + numeroDeDescargas + '\n' +
                "***************************" + '\n';
    }
}