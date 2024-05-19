package com.Arquitectura.chess.controler;

import com.Arquitectura.chess.UserService;
import com.Arquitectura.chess.model.User;
import com.Arquitectura.chess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/crear")
    public void crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        userService.createUser(usuarioDTO);
    }


    @GetMapping("/verUsuarios")
    public List<User> verUsuarios(){
        return userRepository.findAll();
    }


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User searchUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping ("{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PostMapping("/verificarUsuarios")
    public boolean verificarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return userService.existeUsuario( usuarioDTO.getUsername(), usuarioDTO.getPassword());
    }
}
