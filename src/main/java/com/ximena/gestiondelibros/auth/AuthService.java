package com.ximena.gestiondelibros.auth;

import com.ximena.gestiondelibros.user.User;
import com.ximena.gestiondelibros.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public User register(User user) {
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new IllegalStateException("El email ya está registrado.");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setActive(true);
    return userRepository.save(user);
  }


  public String login(String email, String password) {
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new IllegalStateException("Usuario no encontrado."));

    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new IllegalStateException("Contraseña incorrecta.");
    }
    return "Login exitoso para el usuario: " + email;
  }


}
