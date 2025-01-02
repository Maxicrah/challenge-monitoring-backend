package ar.com.maxi.challengemonitoring.controller;

import ar.com.maxi.challengemonitoring.model.User;
import ar.com.maxi.challengemonitoring.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"https://monitoring-challenge-2y0ww4n79-maximilianos-projects-a55ff8fb.vercel.app"})
public class UserController {

    private final IUserService userService;
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, User>> findById(@PathVariable("id") Long id) {
        User user = this.userService.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "user", user
        ));
    }



}
