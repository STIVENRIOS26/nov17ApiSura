package com.example.konectaAPI.repositorios;

import com.example.konectaAPI.entidades.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepositorio extends JpaRepository<Examen, Integer> {
}
