package com.ximena.gestiondelibros.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(int id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Usuario no encontrado con id: " + id));
  }

  public User saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public User updateUser(int id, User user) {
    User existingUser = getUserById(id);
    existingUser.setNombre(user.getNombre());
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(existingUser);
  }

  public void deleteUserById(int id) {
    if (!userRepository.existsById(id)) {
      throw new IllegalStateException("Usuario no encontrado con id: " + id);
    }
    userRepository.deleteById(id);
  }
}
