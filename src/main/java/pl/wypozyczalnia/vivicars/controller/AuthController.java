package pl.wypozyczalnia.vivicars.controller;

import pl.wypozyczalnia.vivicars.config.LoginCredentials;
import pl.wypozyczalnia.vivicars.model.User;
import pl.wypozyczalnia.vivicars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials) {
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword()));
        user = userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/role/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException("User not found with username: " + username);
        }
        return user;
    }
}
