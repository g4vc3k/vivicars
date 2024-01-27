package pl.wypozyczalnia.vivicars.controller;

import pl.wypozyczalnia.vivicars.model.User;
import pl.wypozyczalnia.vivicars.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String username) {
        List<User> users = new ArrayList<User>();

        if (username == null)
            userRepository.findAll().forEach(users::add);
        else
            userRepository.findByUsernameContaining(username).forEach(users::add);

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userRepository.findById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {


        user.setUsername(user.getUsername());

        user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(user.isEnabled());

        user.setImie(user.getImie());
        user.setNazwisko(user.getNazwisko());
        user.setData_urodzenia(user.getData_urodzenia());
        user.setMiejscowosc(user.getMiejscowosc());
        user.setUlica(user.getUlica());
        user.setNr_lokalu(user.getNr_lokalu());
        user.setAuthorities(user.getAuthorities());
        user = userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User _user = userRepository.findById(id);


        _user.setUsername(user.getUsername());
        _user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword()));
        _user.setEnabled(user.isEnabled());
        _user.setAuthorities(user.getAuthorities());

        return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/enabled")
    public ResponseEntity<List<User>> findByEnabled() {
        List<User> users = userRepository.findByEnabled(true);

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
