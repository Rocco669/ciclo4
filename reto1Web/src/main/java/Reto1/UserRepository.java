/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class UserRepository {
     @Autowired
    private UserCrudRepository userCrudRepository;
     
     public List <User> getAll(){
     return (List<User>) userCrudRepository.findAll();
     }
     
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
       
    public User save(User user) {
        return userCrudRepository.save(user);
    }
   
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
    
     public Optional<User> validaUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
     
}
