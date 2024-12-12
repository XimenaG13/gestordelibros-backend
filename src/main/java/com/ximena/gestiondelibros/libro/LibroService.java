package com.ximena.gestiondelibros.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

  @Autowired
  private LibroRepository libroRepository;

  public List<Libro> getAllLibros() {
    return libroRepository.findAll();
  }

  public Libro getLibroById(int id) {
    return libroRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Libro no encontrado con id: " + id));
  }

  public Libro saveLibro(Libro libro) {
    return libroRepository.save(libro);
  }

  public Libro updateLibro(int id, Libro libro) {
    Libro existingLibro = getLibroById(id);
    existingLibro.setTitulo(libro.getTitulo());
    existingLibro.setAutor(libro.getAutor());
    existingLibro.setEditorial(libro.getEditorial());
    return libroRepository.save(existingLibro);
  }

  public void deleteLibroById(int id) {
    if (!libroRepository.existsById(id)) {
      throw new IllegalStateException("Libro no encontrado con id: " + id);
    }
    libroRepository.deleteById(id);
  }
}
