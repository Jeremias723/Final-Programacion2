package com.parcial.videojuegos.repositories;


import com.parcial.videojuegos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria,Long> {
}
