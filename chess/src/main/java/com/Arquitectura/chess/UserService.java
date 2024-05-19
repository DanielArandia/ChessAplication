package com.Arquitectura.chess;

import com.Arquitectura.chess.controler.UsuarioDTO;
import com.Arquitectura.chess.model.User;
import com.Arquitectura.chess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UsuarioDTO usuarioDTO){

        User existingUser = userRepository.findByUsername(usuarioDTO.getUsername());
        if (existingUser != null) {
            // Aquí puedes manejar la situación de que el nombre de usuario ya existe
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        // Si el nombre de usuario no existe, crear el nuevo usuario
        User user = new User(usuarioDTO.getUsername(), usuarioDTO.getPassword());
        return userRepository.save(user);

    }

    public User getUserById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public boolean existeUsuario(String username, String password){
        return userRepository.existsByUsernameAndPassword(username, password);
    }


}
