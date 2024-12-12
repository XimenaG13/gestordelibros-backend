package com.ximena.gestiondelibros.auth;

import com.ximena.gestiondelibros.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public User register(@RequestBody User user) {
    return authService.register(user);
  }

  @PostMapping("/login")
  public String login(@RequestBody LoginRequest loginRequest) {
    return authService.login(loginRequest.getEmail(), loginRequest.getPassword());
  }
}
