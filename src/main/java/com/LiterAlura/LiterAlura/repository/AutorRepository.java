package com.LiterAlura.LiterAlura.repository;

import com.LiterAlura.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombreIgnoreCase(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fecha AND a.fechaDeFallecimiento >= :fecha")
    List<Autor> autorVivoEnDeterminadoAnio(@Param("fecha") String fecha);
}