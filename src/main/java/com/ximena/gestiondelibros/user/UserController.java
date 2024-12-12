package com.ximena.gestiondelibros.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @PostMapping
  public User saveUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable int id, @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteUserById(id);
  }
}
