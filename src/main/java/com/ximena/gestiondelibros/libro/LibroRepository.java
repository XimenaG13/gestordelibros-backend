package com.ximena.gestiondelibros.libro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
