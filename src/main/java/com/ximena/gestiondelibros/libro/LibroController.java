package com.ximena.gestiondelibros.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

  @Autowired
  private LibroService libroService;

  @GetMapping
  public List<Libro> getAllLibros() {
    return libroService.getAllLibros();
  }

  @GetMapping("/{id}")
  public Libro getLibroById(@PathVariable int id) {
    return libroService.getLibroById(id);
  }

  @PostMapping
  public Libro saveLibro(@RequestBody Libro libro) {
    return libroService.saveLibro(libro);
  }

  @PutMapping("/{id}")
  public Libro updateLibro(@PathVariable int id, @RequestBody Libro libro) {
    return libroService.updateLibro(id, libro);
  }

  @DeleteMapping("/{id}")
  public void deleteLibro(@PathVariable int id) {
    libroService.deleteLibroById(id);
  }
}
