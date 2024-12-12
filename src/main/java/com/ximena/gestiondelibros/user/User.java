package com.ximena.gestiondelibros.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUsuario;
  private String numeroControl;
  private String nombre;
  private String email;
  private String password;
  private boolean isActive;

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNumeroControl() {
    return numeroControl;
  }

  public void setNumeroControl(String numeroControl) {
    this.numeroControl = numeroControl;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}

